package org.student.omo.rest.controller.implementation;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.student.omo.model.Member;
import org.student.omo.rest.controller.MemberController;
import org.student.omo.rest.dto.member.MemberRequest;
import org.student.omo.rest.dto.member.MessageResponse;
import org.student.omo.service.FileService;
import org.student.omo.service.MemberService;
import org.student.omo.service.UserService;

@Log
@RequiredArgsConstructor
@Component
public class DefaultMemberController implements MemberController {

  private final MemberService memberService;
  private final UserService userService;
  private final FileService fileService;

  @Override
  public ResponseEntity<List<MessageResponse>> getMembers() {
    var messages = memberService.getAllMessages().stream()
      .map(m -> MessageResponse.builder()
        .id(m.getId())
        .name(m.getName())
        .phone(m.getPhone())
        .timestamp(m.getTimestamp())
        .file(m.getFile() != null ? m.getFile().getFilename() : null)
        .build())
      .collect(Collectors.toList());
    var httpStatus = !messages.isEmpty() ? HttpStatus.OK : HttpStatus.NO_CONTENT;
    return ResponseEntity.status(httpStatus).body(messages);
  }

  @Override
  public ResponseEntity<MessageResponse> getMember(@PathVariable long id) {
    var message = memberService.getMessage(id);
    return message
      .map(m -> MessageResponse.builder()
        .id(m.getId())
        .name(m.getName())
        .phone(m.getPhone())
        .timestamp(m.getTimestamp())
        .file(m.getFile() != null ? m.getFile().getFilename() : null)
        .build())
      .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
  }

  @Override
  public ResponseEntity<MessageResponse> addMember(@RequestBody MemberRequest memberRequest) {
    var file = memberRequest.getFile().map(fileService::save);
    Long id = null;
    try {
      id = memberService.addMessage(
        Member.builder()
          .name(memberRequest.getName())
          .phone(memberRequest.getPhone())
          .file(file.orElse(null))
          .build()
      );
    } catch (Exception e) {
      file.ifPresent(f -> fileService.delete(f.getId()));
      throw e;
    }
    return ResponseEntity.ok(MessageResponse.builder().id(id).build());
  }

  @Override
  public ResponseEntity deleteMember(@PathVariable long id) {
    memberService.deleteMessage(id);
    return ResponseEntity.ok().build();
  }
}
