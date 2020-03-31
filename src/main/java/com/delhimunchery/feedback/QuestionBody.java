package com.delhimunchery.feedback;

import com.delhimunchery.feedback.domain.Option;
import com.delhimunchery.feedback.domain.Question;
import java.util.List;

public class QuestionBody {
  private Question question;
  private List<Option> options;

  public QuestionBody(Question question, List<Option> options){
    this.question = question;
    this.options = options;
  }

  public Question getQuestion() {
    return question;
  }

  public void setQuestion(Question question) {
    this.question = question;
  }

  public List<Option> getOptions() {
    return options;
  }

  public void setOptions(List<Option> options) {
    this.options = options;
  }
}
