package org.student.omo.rest.controller.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.student.omo.rest.controller.FileController;
import org.student.omo.service.FileService;
import org.student.omo.service.internal.FileResource;

@Component
@RequiredArgsConstructor
public class DefaultFileController implements FileController {

  private final FileService fileService;

  @Override
  public ResponseEntity<FileResource> getFile(@PathVariable String filename) {
    return fileService.getResource(filename)
      .map(f -> ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf(f.getMime())).body(f))
      .orElseGet(() -> ResponseEntity.noContent().build());
  }
}
