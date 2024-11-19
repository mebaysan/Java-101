package com.mebaysan.quick_intro.services;

import com.mebaysan.quick_intro.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
