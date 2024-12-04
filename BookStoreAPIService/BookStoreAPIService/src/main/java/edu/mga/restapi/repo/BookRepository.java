package edu.mga.restapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mga.restapi.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>  {

}
