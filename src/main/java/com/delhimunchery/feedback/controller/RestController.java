package com.delhimunchery.feedback.controller;

import com.delhimunchery.feedback.domain.Option;
import com.delhimunchery.feedback.domain.Response;
import com.delhimunchery.feedback.repositories.OptionRepo;
import com.delhimunchery.feedback.repositories.QuestionRepo;
import com.delhimunchery.feedback.repositories.ResponseRepo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

  @PostMapping("/SendResponse")
  @CrossOrigin
  private void addResponse(@RequestParam int response) {
    Response r = new Response();
    r.setResponse(response);

    responseRepo.save(r);
  }

  @GetMapping("/GetAllData")
  @CrossOrigin
  private List<Response> getData() {
    return responseRepo.findAll();
  }

  @GetMapping("/GetByResponse")
  @CrossOrigin
  private List<Response> sendDataByResponse(@RequestParam int response) {
    return responseRepo.findByResponse(response);
  }

  @GetMapping("/GetByDate")
  @CrossOrigin
  private List<Response> sendDataByDate(@RequestParam String date) throws ParseException {
    Date dateObj = new Date();
    List<Response> returnObj = null;
    try {
      dateObj = new SimpleDateFormat("yyyy-MM-dd").parse(date);
      returnObj = responseRepo
          .findByDate(dateObj.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
    } catch (ParseException e) {
      throw e;
    }
    return returnObj;
  }

  @GetMapping("/GetQuestion")
  public String getQuestion(@RequestParam int questionNo){
    return questionRepo.findByQuestionNo(questionNo);
  }

  @GetMapping("/GetOption")
  public Option getOption(@RequestParam int optionId){
    return optionRepo.findByOptionId(optionId);
  }
}
