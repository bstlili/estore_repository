package com.briup.estore2.dao;

import java.util.List;

import com.briup.estore2.bean.Book;

public interface BookDao {
	public List<Book> selectAllBooks();
	public Book findBookById(Long id);
	public Book findBookByName(String name);
	public List<Book> findBookByKeyWord(String keyword);
}
