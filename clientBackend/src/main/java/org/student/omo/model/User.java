package org.student.omo.model;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/** Represents information about user which is stored in the database. */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {


  @Id
  @GeneratedValue
  private long id;


  @NotBlank
  @Size(min = 6, max = 32)
  @NonNull
  private String username;


  @NotBlank
  @NonNull
  private String password;


  @Email
  private String email;


  @OneToMany
  private List<Member> members;

  @Override
  public String toString() {
    return username;
  }
}
