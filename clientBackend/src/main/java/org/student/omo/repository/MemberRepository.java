package org.student.omo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.student.omo.model.Member;

/** Represents database repository for the {@link Member} entity. */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
