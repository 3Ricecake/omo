package org.student.omo.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.student.omo.model.Member;
import org.student.omo.repository.MemberRepository;

/**
 * Service manages of messages. Here is implemented such features as adding, deleting, editing, getting of messages.
 */
@Log
@Service
@RequiredArgsConstructor
public class MemberService {

  /**
   * Instance of the {@link MemberRepository} object.
   */
  private final MemberRepository memberRepository;

  /**
   * Add message to repository and returns id of the added message.
   *
   * @param member source of the new message.
   * @return identifier of the new stored message.
   */
  public long addMessage(Member member) {
    return memberRepository.save(member).getId();
  }

  /**
   * Removes {@link Member} from database by it's id.
   *
   * @param messageId received id of message.
   */
  public void deleteMessage(long messageId) {
    memberRepository.deleteById(messageId);
  }

  /**
   * Return message by its id.
   *
   * @param messageId identifier of a message.
   * @return message.
   */
  public Optional<Member> getMessage(long messageId) {
    return memberRepository.findById(messageId);
  }

  /**
   * Returns list of all messages in JSON format.
   *
   * @return list of the messages.
   */
  public List<Member> getAllMessages() {
    return memberRepository.findAll();
  }
}
