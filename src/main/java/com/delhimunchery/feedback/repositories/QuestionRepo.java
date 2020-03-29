package com.delhimunchery.feedback.repositories;

import com.delhimunchery.feedback.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuestionRepo extends JpaRepository<Question, Long> {
  @Query("select q.question from Question q where q.questionNo = ?1")
  String findByQuestionNo(int questionNo);
}
