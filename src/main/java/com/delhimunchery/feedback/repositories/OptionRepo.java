package com.delhimunchery.feedback.repositories;

import com.delhimunchery.feedback.domain.Option;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OptionRepo extends JpaRepository<Option, Long> {
  @Query("select option from Option option where option.question.id = ?1")
  List<Option> findAllByQuestionId(long questionId);
}
