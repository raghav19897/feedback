package com.delhimunchery.feedback.repositories;

import com.delhimunchery.feedback.domain.Responses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseRepo extends JpaRepository<Responses, Long> {

}
