package com.youssef.BooksApi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.youssef.BooksApi.Models.Book;
import com.youssef.BooksApi.repositories.BookRepository;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
 // updates a book
    public Book updateBook(String title, String desc, String lang, Integer numOfPages) {
 
    		Book book = new Book(title, desc, lang, numOfPages);
    		System.out.println(book);
    	   return bookRepository.save(book);
    	  
		
    	  
		
	}
 // Delete a book
    public void deleteBook(Long bookId) {
       bookRepository.deleteById(bookId);
    }
    
	
    
}
