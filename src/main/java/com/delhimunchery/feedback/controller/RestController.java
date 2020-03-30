package com.delhimunchery.feedback.controller;

import com.delhimunchery.feedback.OptionBody;
import com.delhimunchery.feedback.domain.Option;
import com.delhimunchery.feedback.domain.Question;
import com.delhimunchery.feedback.domain.Response;
import com.delhimunchery.feedback.repositories.OptionRepo;
import com.delhimunchery.feedback.repositories.QuestionRepo;
import com.delhimunchery.feedback.repositories.ResponseRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin
public class RestController {

  long CURRENT_QUESTION = 1;

  @Autowired
  private ResponseRepo responseRepo;
  @Autowired
  private QuestionRepo questionRepo;
  @Autowired
  private OptionRepo optionRepo;

  @PostMapping("/currentQuestion")
  public void setCurrentQuestion(@RequestParam long questionId) {
    CURRENT_QUESTION = questionId;
  }

  @PostMapping("/question")
  public void addQuestion(@RequestParam String question) {
    Question newQuestion = new Question();
    newQuestion.setQuestion(question);
    questionRepo.save(newQuestion);
  }

  @PostMapping("/option")
  public void addOption(@RequestBody OptionBody optionBody) {
    Option option = new Option();
    option.setRank(optionBody.getRank());
    option.setValue(optionBody.getValue());
    option.setImageURL(optionBody.getUrl());
    option.setQuestion(questionRepo.findById(optionBody.getQuestioId()).orElse(null));
    optionRepo.save(option);
  }

  @GetMapping("/currentQuestion")
  public Question getCurrentQuestion() {
    Optional<Question> question = questionRepo.findById(CURRENT_QUESTION);
    return question.orElse(null);
  }

  @GetMapping("/options")
  public List<Option> getOptionsForCurrentQuestion() {
    return optionRepo.findAllByQuestionId(CURRENT_QUESTION);
  }

  @GetMapping("response")
  public void addResponse(@RequestParam long optionId) {
    Response response = new Response();
    Optional<Question> question = questionRepo.findById(CURRENT_QUESTION);
    Optional<Option> option = optionRepo.findById(optionId);
    if (question.isPresent() && option.isPresent()) {
      response.setQuestion(question.get());
      response.setOption(option.get());
      responseRepo.save(response);
    }
  }
}
