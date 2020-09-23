package org.student.omo.rest.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.student.omo.rest.dto.member.MemberRequest;
import org.student.omo.rest.dto.member.MessageResponse;

@RestController
@RequestMapping("/api/members")
public interface MemberController {

  @GetMapping
  ResponseEntity<List<MessageResponse>> getMembers();

  @GetMapping("/{id}")
  ResponseEntity<MessageResponse> getMember(@PathVariable long id);

  @PostMapping
  ResponseEntity<MessageResponse> addMember(@RequestBody MemberRequest memberRequest);

  @DeleteMapping("/{id}")
  ResponseEntity deleteMember(@PathVariable long id);
}
