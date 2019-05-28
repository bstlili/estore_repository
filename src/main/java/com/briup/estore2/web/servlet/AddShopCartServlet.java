package com.briup.estore2.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore2.bean.Book;
import com.briup.estore2.bean.OrderLine;
import com.briup.estore2.bean.ShoppingCar;
import com.briup.estore2.service.impl.BookServiceImpl;
import com.briup.estore2.util.exception.BookException;

/**
 * Servlet implementation class AddShopCartServlet
 */
@WebServlet("/AddShopCartServlet")
public class AddShopCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddShopCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bookName = request.getParameter("bn");
		String num = request.getParameter("num");
		int n = Integer.parseInt(num);
		System.out.println(bookName+" "+num);
		
		HttpSession session = request.getSession();
		ShoppingCar shoppingCar = (ShoppingCar) session.getAttribute("shoppingCar");
		OrderLine line = new OrderLine();
		
		BookServiceImpl bs = new BookServiceImpl();
		Book book;
		try {
			book = bs.findBookByName(bookName);
			line.setBook(book);
			line.setNum(n);
			System.out.println(line);
			if (shoppingCar==null) {
				shoppingCar=new ShoppingCar();
			}
			shoppingCar.add(line,n);
			session.setAttribute("shoppingCar", shoppingCar);
			
		} catch (BookException e) {
			e.printStackTrace();
		}
		response.sendRedirect("shopCart.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
