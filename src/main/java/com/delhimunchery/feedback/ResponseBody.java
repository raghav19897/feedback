package com.delhimunchery.feedback;

import com.delhimunchery.feedback.domain.Response;
import java.util.List;

public class ResponseBody {
  private long questionNo;
  private List<Response> response;

  public ResponseBody(long questionNo, List<Response> response){
    this.questionNo = questionNo;
    this.response = response;
  }

  public long getQuestionNo() {
    return questionNo;
  }

  public void setQuestionNo(long questionNo) {
    this.questionNo = questionNo;
  }

  public List<Response> getResponse() {
    return response;
  }

  public void setResponse(List<Response> response) {
    this.response = response;
  }
}
