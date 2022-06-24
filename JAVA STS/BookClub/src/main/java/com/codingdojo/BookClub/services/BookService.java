package com.codingdojo.BookClub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.BookClub.models.Book;
import com.codingdojo.BookClub.repos.BookRepository;


@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
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
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	//UPDATE
	public Book updateBook(Book b) {
		return bookRepository.save(b);
	}
	
	//DELETE
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
}

