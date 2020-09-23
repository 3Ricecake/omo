package org.student.omo.rest.controller.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.student.omo.model.User;
import org.student.omo.rest.controller.UserController;
import org.student.omo.rest.dto.auth.AuthRequest;
import org.student.omo.rest.dto.auth.AuthResponse;
import org.student.omo.rest.dto.register.RegisterRequest;
import org.student.omo.rest.dto.register.RegisterResponse;
import org.student.omo.rest.dto.user.UserResponse;
import org.student.omo.service.UserService;

@Component
@RequiredArgsConstructor
public class DefaultUserController implements UserController {

  private final UserService userService;

  @Override
  public ResponseEntity<UserResponse> currentUser() {
    return userService.getCurrentUser()
      .map(user -> UserResponse.builder()
        .username(user.getUsername())
        .email(user.getEmail())
        .build()
      )
      .map(ResponseEntity::ok)
      .orElseGet(() -> ResponseEntity.noContent().build());
  }

  @Override
  public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequest) {
    return userService.save(
      User.builder()
        .username(registerRequest.getUsername())
        .password(registerRequest.getPassword())
        .email(registerRequest.getEmail().get())
        .build())
      .map(User::getId)
      .map(id -> ResponseEntity.ok(new RegisterResponse(id)))
      .orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).build());
  }

  @Override
  public ResponseEntity<AuthResponse> signIn(@RequestBody AuthRequest authRequest) {
    return userService.login(authRequest.getUsername(), authRequest.getPassword())
      .map(token -> ResponseEntity.accepted().body(new AuthResponse(token)))
      .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
  }
}
