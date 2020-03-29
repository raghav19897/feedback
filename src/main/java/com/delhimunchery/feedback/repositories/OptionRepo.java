package com.delhimunchery.feedback.repositories;

import com.delhimunchery.feedback.domain.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepo extends JpaRepository<Option, Long> {

}
