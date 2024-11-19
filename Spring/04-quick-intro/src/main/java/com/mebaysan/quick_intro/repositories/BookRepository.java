package com.mebaysan.quick_intro.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mebaysan.quick_intro.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
