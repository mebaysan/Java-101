package com.mebaysan.quick_intro.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mebaysan.quick_intro.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
