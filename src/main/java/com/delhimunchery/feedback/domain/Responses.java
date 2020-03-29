package com.delhimunchery.feedback.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "responses")
public class Responses {

  @Id
  @GeneratedValue
  private int id;
  private float response;
  @CreationTimestamp
  @Column(name = "date")
  private LocalDateTime submitDate;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public float getResponse() {
    return response;
  }

  public void setResponse(float response) {
    this.response = response;
  }

  public LocalDateTime getSubmitDate() {
    return submitDate;
  }

  public void setSubmitDate(LocalDateTime submitDate) {
    this.submitDate = submitDate;
  }
}
