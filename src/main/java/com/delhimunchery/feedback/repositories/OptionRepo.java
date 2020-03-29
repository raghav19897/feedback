package com.delhimunchery.feedback.repositories;

import com.delhimunchery.feedback.domain.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OptionRepo extends JpaRepository<Option, Long> {
  @Query("select o from Option o where o.optionId = ?1")
  Option findByOptionId(int optionId);
}
