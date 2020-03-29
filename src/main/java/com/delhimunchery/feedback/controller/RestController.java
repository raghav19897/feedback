package com.delhimunchery.feedback.controller;

import com.delhimunchery.feedback.domain.Responses;
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

  @PostMapping("/SendResponse")
  @CrossOrigin
  private void addResponse(@RequestParam float response) {
    Responses r = new Responses();
    r.setResponse(response);

    responseRepo.save(r);
  }

  @GetMapping("/GetAllData")
  @CrossOrigin
  private List<Responses> getData() {
    return responseRepo.findAll();
  }

  @GetMapping("/GetByResponse")
  @CrossOrigin
  private List<Responses> getDataByResponse(@RequestParam float response) {
    return responseRepo.findByResponse(response);
  }

  @GetMapping("/GetByDate")
  @CrossOrigin
  private List<Responses> getDataByDate(@RequestParam String date) throws ParseException {
    Date dateObj = new Date();
    List<Responses> returnObj = null;
    try {
      dateObj = new SimpleDateFormat("yyyy-MM-dd").parse(date);
      returnObj = responseRepo.findByDate(dateObj.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
    } catch (ParseException e) {
      throw e;
    }
    return returnObj;
  }
}
