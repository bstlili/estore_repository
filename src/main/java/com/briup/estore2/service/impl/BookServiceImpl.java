package com.briup.estore2.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore2.bean.Book;
import com.briup.estore2.dao.BookDao;
import com.briup.estore2.service.BookService;
import com.briup.estore2.util.MyBatisSqlSessionFactory;
import com.briup.estore2.util.exception.BookException;

public class BookServiceImpl implements BookService{
	SqlSession session = MyBatisSqlSessionFactory.openSession();
	BookDao mapper = session.getMapper(BookDao.class);

	@Override
	public List<Book> findAllBooks() throws BookException {
		List<Book> books = mapper.selectAllBooks();
		return books;
	}
	
	public static void main(String[] args) {
		BookServiceImpl bookServiceImpl = new BookServiceImpl();
		try {
			List<Book> books = bookServiceImpl.findBookByKeyWord("spring");
			for (Book book : books) {
				System.out.println(book);
			}
		} catch (BookException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addBook() throws BookException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Book findBookById(Long id) throws BookException {
		// TODO Auto-generated method stub
		Book book = mapper.findBookById(id);
		return book;
	}

	@Override
	public Book findBookByName(String name) throws BookException {
		// TODO Auto-generated method stub
		Book book = mapper.findBookByName(name);
		return book;
	}

	@Override
	public List<Book> findBookByKeyWord(String keyword) throws BookException {
		List<Book> books = mapper.findBookByKeyWord("%"+keyword+"%");
		return books;
	}
}
