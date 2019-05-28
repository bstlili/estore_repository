package com.briup.estore2.web.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.briup.estore2.bean.Book;
import com.briup.estore2.service.impl.BookServiceImpl;
import com.briup.estore2.util.exception.BookException;

/**
 * Application Lifecycle Listener implementation class ApplicationListener
 *
 */
@WebListener
public class ApplicationListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ApplicationListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext application = sce.getServletContext();
    	
    	BookServiceImpl bookService = new BookServiceImpl();
    	List<Book> books;
		try {
			books = bookService.findAllBooks();
			application.setAttribute("books", books);
		} catch (BookException e) {
			e.printStackTrace();
		}
    }
	
}
