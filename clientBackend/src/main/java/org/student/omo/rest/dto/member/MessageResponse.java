package org.student.omo.rest.dto.member;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponse {

  private Long id;
  private String name;
  private String phone;
  private LocalDateTime timestamp;
  private String file;
}
