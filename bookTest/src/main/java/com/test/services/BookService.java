package com.test.services;


import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.dao.BookRepository;
import com.test.entities.Book;

@Component
public class BookService {
//	private static List<Book> list = new ArrayList<>();
//	static {
//		list.add(new Book(2, "c", "dennis"));
//		list.add(new Book(3, "c++", "d"));
//	}
	@Autowired
	private BookRepository bkRep; 

	public List<Book> getAllBooks() {
	List<Book> list=(List<Book>)	this.bkRep.findAll();
		return list;
	}

	public Book getBookById(int id) {
		Book book = null;
try {
//		book = list.stream().filter(e -> e.getId() == id).findFirst().get();
		book=this.bkRep.findById(id);

}catch(Exception e) {e.printStackTrace();
}
return book;
	}

	public Book addBook(Book b) {
		Book book=this.bkRep.save(b);
		return book;
	}
	
	public void deleteBook(int id) {
//		list=list.stream().filter(book->book.getId()!=id).collect(Collectors.toList());
		this.bkRep.deleteById(id);
	
	}

	public void updateBook(Book book,int bookId) {
//		list=list.stream().map(b->{
//			if(b.getId()==bookId) {
//				b.setAuthor(book.getAuthor());
//				b.setTitle(book.getTitle());
//			}
//			return b;
//			
//		}).collect(Collectors.toList());
		book.setId(bookId);
		this.bkRep.save(book);
	}
	
}
