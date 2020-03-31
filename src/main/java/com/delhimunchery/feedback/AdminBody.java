package com.delhimunchery.feedback;

import com.delhimunchery.feedback.domain.Option;
import com.delhimunchery.feedback.domain.Question;
import java.util.ArrayList;
import java.util.List;

public class AdminBody {

  private List<Question> questions;
  private List<Option> options;
  private ArrayList<ResponseBody> allResponses;

  public AdminBody(List<Question> questions, List<Option> options, ArrayList<ResponseBody> allResponses){
    this.questions = questions;
    this.options = options;
    this.allResponses = allResponses;
  }

  public List<Question> getQuestions() {
    return questions;
  }

  public void setQuestions(List<Question> questions) {
    this.questions = questions;
  }

  public List<Option> getOptions() {
    return options;
  }

  public void setOptions(List<Option> options) {
    this.options = options;
  }

  public ArrayList<ResponseBody> getAllResponses() {
    return allResponses;
  }

  public void setAllResponses(ArrayList<ResponseBody> allResponses) {
    this.allResponses = allResponses;
  }
}
