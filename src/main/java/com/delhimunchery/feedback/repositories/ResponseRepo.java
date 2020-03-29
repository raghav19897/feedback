package com.delhimunchery.feedback.repositories;

import com.delhimunchery.feedback.domain.Responses;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ResponseRepo extends JpaRepository<Responses, Long> {

  @Query("select r from Responses r where r.response=?1")
  List<Responses> findByResponse(float response);

  @Query("select r from Responses r where r.submitDate=?1")
  List<Responses> findByDate(LocalDateTime date);
}
