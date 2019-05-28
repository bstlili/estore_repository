package com.briup.estore2.service;

import java.util.List;

import com.briup.estore2.bean.Book;
import com.briup.estore2.util.exception.BookException;

public interface BookService {

	public List<Book> findAllBooks() throws BookException;
	
	public Book findBookById(Long id) throws BookException;
	
	public List<Book> findBookByKeyWord(String keyword) throws BookException;
	
	public Book findBookByName(String name) throws BookException;
	
	public void addBook() throws BookException;
}
