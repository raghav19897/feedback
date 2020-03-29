package com.delhimunchery.feedback.repositories;

import com.delhimunchery.feedback.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question, Long> {

}
