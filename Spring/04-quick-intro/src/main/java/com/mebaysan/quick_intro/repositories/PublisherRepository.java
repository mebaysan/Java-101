package com.mebaysan.quick_intro.repositories;

import org.springframework.data.repository.CrudRepository;
import com.mebaysan.quick_intro.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
