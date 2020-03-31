package com.delhimunchery.feedback;

public class OptionBody {
  private long rank;
  private String value;
  private String url;
  private long questionId;

  public long getRank() {
    return rank;
  }

  public void setRank(long rank) {
    this.rank = rank;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public long getQuestionId() {
    return questionId;
  }

  public void setQuestionId(long questionId) {
    this.questionId = questionId;
  }
}
