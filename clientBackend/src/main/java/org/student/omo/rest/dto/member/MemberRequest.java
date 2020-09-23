package org.student.omo.rest.dto.member;

import java.util.Optional;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberRequest {

  private String name;
  private String phone;
  private String file;

  public Optional<String> getFile() {
    return Optional.ofNullable(file);
  }
}
