package edu.mga.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mga.restapi.model.Book;
import edu.mga.restapi.repo.BookRepository;

@Service
public class BookService {

	@Autowired
	protected BookRepository bookRepository;
	
	public Book addBook(Book book) {
		return bookRepository.saveAndFlush(book);
	}
	
	public Book findBook(Long bookId) {
		return bookRepository.findById(bookId).get();
	}
	
	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}
	
	public void deleteBook(Book book) {
		bookRepository.delete(book);
	}
}
