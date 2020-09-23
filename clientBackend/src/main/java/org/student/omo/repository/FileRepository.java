package org.student.omo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.student.omo.model.File;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {

  public Optional<File> findByFilename(String filename);
}
