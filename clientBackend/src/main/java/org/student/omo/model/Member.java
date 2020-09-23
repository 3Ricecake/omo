package org.student.omo.model;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Member {

  @Id
  @GeneratedValue
  private long id;

  @Size(max = 100)
  private String name;

  @Size(max = 1024)
  private String phone;

  @OneToOne(cascade = CascadeType.REMOVE)
  private File file;

  @CreationTimestamp
  private LocalDateTime timestamp;

  private boolean edited;

  @ManyToOne
  private User code;
}
