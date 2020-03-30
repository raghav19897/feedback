package com.delhimunchery.feedback.controller;

import com.delhimunchery.feedback.domain.Option;
import com.delhimunchery.feedback.domain.Question;
import com.delhimunchery.feedback.repositories.OptionRepo;
import com.delhimunchery.feedback.repositories.QuestionRepo;
import com.delhimunchery.feedback.repositories.ResponseRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestController {

  long CURRENT_QUESTION = 0;

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
  public void addOption(@RequestParam long rank, @RequestParam String value, @RequestParam String url, @RequestParam long questionId){
    Option option = new Option();
    option.setRank(rank);
    option.setValue(value);
    option.setImageURL(url);
    option.setQuestion(questionRepo.findById(questionId).orElse(null));
    optionRepo.save(option);
  }

  @GetMapping("/currentQuestion")
  public Question getCurrentQuestion() {
    Optional<Question> question = questionRepo.findById(CURRENT_QUESTION);
    return question.orElse(null);
  }

  @GetMapping("/options")
  public List<Option> getOptionsForCurrentQuestion(){
    return optionRepo.findAllByQuestionId(CURRENT_QUESTION);
  }
}
