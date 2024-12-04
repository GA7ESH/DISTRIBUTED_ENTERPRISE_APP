package edu.mga.restapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mga.restapi.model.Book;
import edu.mga.restapi.service.BookService;


@RestController
@RequestMapping(value = {
		 "/api"
		})
public class BookController {

	private static Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookService bookService;
	
	/**
	 * @URL http://xxx.xxx.xxx.xxx:8080/book/create
	 * @Method Post
	 * @param   {
	 *				"author": "Mike Smith",
	 * 				"title": "Jaav programming",
	 * 				"description": "Description",
	 * 				"price": 15.45
     * 			}
	 * @return
	 */		
	@RequestMapping(method=RequestMethod.POST, value="/book/create")
	public Book addBook(@Valid @RequestBody Book model) {
		logger.info("book: "+model);
		
		return bookService.addBook(model);
	}
	
	/**
	 * @URL http://xxx.xxx.xxx.xxx:8080/book/{id}
	 * @Method GET
	 * @param   {
	 * 				"id": 1,
	 *				"author": "Mike Smith",
	 * 				"title": "Jaav programming",
	 * 				"description": "Description",
	 * 				"price": 15.45
     * 			}
	 * @return
	 */	
	@RequestMapping(method=RequestMethod.GET, value="/book/{id}")
	public Book getBook(@PathVariable Long id) {
		logger.info("bookid: "+id);
		
		return bookService.findBook(id);
	}
	
	/**
	 * @URL http://xxx.xxx.xxx.xxx:8080/book/get
	 * @Method GET
	 * @param  [ {
	 * 				"id": 1,
	 *				"author": "Mike Smith",
	 * 				"title": "Jaav programming",
	 * 				"description": "Description",
	 * 				"price": 15.45
     * 			},
     * 			...
     * 			]
	 * @return
	 */	
	@RequestMapping(method=RequestMethod.GET, value="/book/get")
	public List<Book> getAllBooks() {
		logger.info("bookid: ");
		
		return bookService.findAllBooks();
	}
	
	/**
	 * @URL http://xxx.xxx.xxx.xxx:8080/book/{id}
	 * @Method GET
	 * @param  
	 * @return "Message"
	 */	
	@RequestMapping(method=RequestMethod.DELETE, value="/book/{id}")
	public String deleteBook(@PathVariable Long id) {
		logger.info("bookid: " + id);
		Book book = bookService.findBook(id);
		bookService.deleteBook(book);
		
		return "Successfully deleted";
	}
}
