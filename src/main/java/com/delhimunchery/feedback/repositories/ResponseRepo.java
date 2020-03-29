package com.delhimunchery.feedback.repositories;

import com.delhimunchery.feedback.domain.Response;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ResponseRepo extends JpaRepository<Response, Long> {

  @Query("select r from Response r where r.response=?1")
  List<Response> findByResponse(int response);

  @Query("select r from Response r where r.submitDate=?1")
  List<Response> findByDate(LocalDateTime date);
}
