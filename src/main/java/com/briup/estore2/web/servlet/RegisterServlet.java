package com.briup.estore2.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore2.bean.Customer;
import com.briup.estore2.service.impl.CustomerServiceImpl;
import com.briup.estore2.util.exception.CustomerException;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String zip = request.getParameter("zip");
		String address = request.getParameter("address");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		
		System.out.println(name);
		System.out.println(password);
		System.out.println(zip);
		System.out.println(address);
		System.out.println(telephone);
		System.out.println(email);
		Customer customer = new Customer();
		customer.setName(name);
		customer.setPassword(password);
		customer.setZip(zip);
		customer.setAddress(address);
		customer.setEmail(email);
		customer.setTelephone(telephone);
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
		try {
			customerServiceImpl.register(customer);
			HttpSession session = request.getSession();
			session.setAttribute("customer", customer);
		} catch (CustomerException e) {
			e.printStackTrace();
		}
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
