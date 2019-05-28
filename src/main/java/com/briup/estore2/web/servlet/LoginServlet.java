package com.briup.estore2.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore2.bean.Customer;
import com.briup.estore2.service.impl.CustomerServiceImpl;
import com.briup.estore2.util.exception.CustomerException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		CustomerServiceImpl cs = new CustomerServiceImpl();
		Customer customer;
		try {
			customer = cs.findCustomerByName(name);
			if (customer==null) {
				System.out.println("用户不存在");
			}else{
				if (customer.getName().equals(name) && customer.getPassword().equals(password)) {
					System.out.println("登录成功");
					request.getSession().setAttribute("customer", customer);
					response.sendRedirect("index.jsp");
				}
			}
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
