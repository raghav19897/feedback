package com.delhimunchery.feedback.repositories;

import com.delhimunchery.feedback.domain.Response;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ResponseRepo extends JpaRepository<Response, Long> {
  @Query("select r from Response r where r.question.id = ?1")
  List<Response> findAllByQuestionId(long questionId);
}
