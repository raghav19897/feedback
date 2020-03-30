package com.delhimunchery.feedback.domain;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Option {

  @Id
  @GeneratedValue
  private long id;
  private long rank;
  private String value;
  private String imageURL;
  @CreationTimestamp
  private Date creationDate;
  @UpdateTimestamp
  private Date lastModified;

  @ManyToOne
  @JoinColumn(name = "question_id", referencedColumnName = "id")
  private Question question;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getScore() {
    return score;
  }

  public void setScore(long score) {
    this.score = score;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getImageURL() {
    return imageURL;
  }

  public void setImageURL(String imageURL) {
    this.imageURL = imageURL;
  }

  public Question getQuestion() {
    return question;
  }

  public void setQuestion(Question question) {
    this.question = question;
  }
}
