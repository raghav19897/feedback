package com.delhimunchery.feedback.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "questions")
public class Question {
  @Id
  @Column(name = "question_no")
  private int questionNo;
  private String question;
  @Column(name = "options_id")
  private String optionsId;//comma separated string for all valid option ids

  public int getQuestionNo() {
    return questionNo;
  }

  public void setQuestionNo(int questionNo) {
    this.questionNo = questionNo;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public String getOptionsId() {
    return optionsId;
  }

  public void setOptionsId(String optionsId) {
    this.optionsId = optionsId;
  }
}
