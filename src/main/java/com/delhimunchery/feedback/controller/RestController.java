package com.delhimunchery.feedback.controller;

import com.delhimunchery.feedback.domain.Responses;
import com.delhimunchery.feedback.repositories.ResponseRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestController {

  @Autowired
  private ResponseRepo responseRepo;

  @GetMapping("/SendResponse")
  @CrossOrigin
  private void addResponse(@RequestParam float response) {
    Responses r = new Responses();
    r.setResponse(response);

    responseRepo.save(r);
  }

  @GetMapping("/GetAllData")
  @CrossOrigin
  private List<Responses> getData(){
    return responseRepo.findAll();
  }
}
