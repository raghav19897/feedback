package com.delhimunchery.feedback.controller;

import com.delhimunchery.feedback.domain.Question;
import com.delhimunchery.feedback.repositories.OptionRepo;
import com.delhimunchery.feedback.repositories.QuestionRepo;
import com.delhimunchery.feedback.repositories.ResponseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestController {

  @Autowired
  private ResponseRepo responseRepo;
  @Autowired
  private QuestionRepo questionRepo;
  @Autowired
  private OptionRepo optionRepo;

  @PostMapping("/question")
  public void addQuestion(@RequestParam String question) {
    Question newQuestion = new Question();
    newQuestion.setQuestion(question);
    questionRepo.save(newQuestion);
  }
}
