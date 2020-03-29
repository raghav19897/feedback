package com.delhimunchery.feedback.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "options")
public class Option {
  @Id
  @GeneratedValue
  @Column(name = "option_id")
  private int optionId;
  private int score;
  private String name;
  @Column(name = "image_url")
  private String imageURL;

  public int getOptionId() {
    return optionId;
  }

  public void setOptionId(int optionId) {
    this.optionId = optionId;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public String getImageURL() {
    return imageURL;
  }

  public void setImageURL(String imageURL) {
    this.imageURL = imageURL;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
