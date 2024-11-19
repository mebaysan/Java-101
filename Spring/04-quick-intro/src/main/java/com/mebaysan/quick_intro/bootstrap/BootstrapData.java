package com.mebaysan.quick_intro.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mebaysan.quick_intro.domain.Author;
import com.mebaysan.quick_intro.domain.Book;
import com.mebaysan.quick_intro.domain.Publisher;
import com.mebaysan.quick_intro.repositories.AuthorRepository;
import com.mebaysan.quick_intro.repositories.BookRepository;
import com.mebaysan.quick_intro.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    @Autowired
    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
            PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Data bootstrapping is started...");

        Publisher publisher = new Publisher();
        publisher.setPublisherName("Packt Publishing");
        publisher.setAddress("Birmingham");
        publisher.setCity("Birmingham");
        publisher.setState("Alabama");
        publisher.setZipCode("35203");
        Publisher savedPublisher = publisherRepository.save(publisher);

        Author author1 = new Author();
        author1.setFirstName("Enes");
        author1.setLastName("Baysan");

        Author author2 = new Author();
        author2.setFirstName("John");
        author2.setLastName("Doe");

        Book book1 = new Book();
        book1.setTitle("Domain Driven Design");
        book1.setIsbn("123456");

        Book book2 = new Book();
        book2.setTitle("J2EE Development without EJB");
        book2.setIsbn("654321");

        Author author1Saved = authorRepository.save(author1);
        Author author2Saved = authorRepository.save(author2);
        Book book1Saved = bookRepository.save(book1);
        Book book2Saved = bookRepository.save(book2);

        author1Saved.getBooks().add(book1Saved);
        author2Saved.getBooks().add(book2Saved);
        authorRepository.save(author1);
        authorRepository.save(author2);

        book1Saved.setPublisher(savedPublisher);
        book2Saved.setPublisher(savedPublisher);
        bookRepository.save(book1);
        bookRepository.save(book2);

        System.out.println("Number of authors: " + authorRepository.count());
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());

        System.out.println("Data bootstrapping is finished...");

    }

}
