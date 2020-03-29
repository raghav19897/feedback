package com.delhimunchery.feedback.repositories;

import com.delhimunchery.feedback.domain.Response;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseRepo extends JpaRepository<Response, Long> {

}
