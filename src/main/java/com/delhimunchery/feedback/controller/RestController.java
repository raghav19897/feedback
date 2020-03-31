package com.delhimunchery.feedback.controller;

import com.delhimunchery.feedback.AdminBody;
import com.delhimunchery.feedback.OptionBody;
import com.delhimunchery.feedback.QuestionBody;
import com.delhimunchery.feedback.ResponseBody;
import com.delhimunchery.feedback.domain.Option;
import com.delhimunchery.feedback.domain.Question;
import com.delhimunchery.feedback.domain.Response;
import com.delhimunchery.feedback.repositories.OptionRepo;
import com.delhimunchery.feedback.repositories.QuestionRepo;
import com.delhimunchery.feedback.repositories.ResponseRepo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
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
    option.setQuestion(questionRepo.findById(optionBody.getQuestionId()).orElse(null));
    optionRepo.save(option);
  }

  @GetMapping("/question")
  public QuestionBody getCurrentQuestion() {
    Question question = questionRepo.findById(CURRENT_QUESTION).orElse(null);
    List<Option> option = optionRepo.findAllByQuestionId(CURRENT_QUESTION);
    return new QuestionBody(question, option);
  }

  @GetMapping("/response")
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

  private List<Question> getAllQuestions(){
    return questionRepo.findAll();
  }

  private List<Option> getAllOptions(){
    return optionRepo.findAll();
  }

  private List<Response> getAllResponsesForQuestion(long questionId){
    return responseRepo.findAllByQuestionId(questionId);
  }

  @GetMapping("/allResponses")
  public AdminBody getAllResponses(){
    ArrayList<ResponseBody> allResponses = new ArrayList<>();
    List<Question> allQuestions = getAllQuestions();
    for (Question allQuestion : allQuestions) {
      long questionId = allQuestion.getId();
      allResponses.add(new ResponseBody(questionId, getAllResponsesForQuestion(questionId)));
    }
    List<Option> allOptions = getAllOptions();
    return new AdminBody(allQuestions, allOptions, allResponses);
  }
}
