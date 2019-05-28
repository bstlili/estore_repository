package com.briup.estore2.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore2.bean.OrderForm;
import com.briup.estore2.service.OrderFormService;
import com.briup.estore2.service.impl.OrderFormServiceImpl;
import com.briup.estore2.util.exception.OrderFormException;

/**
 * Servlet implementation class ShowAllOrder
 */
@WebServlet("/ShowAllOrderServlet")
public class ShowAllOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		Long id = Long.parseLong(cid);
		OrderFormService service = new OrderFormServiceImpl();
		try {
			List<OrderForm> orders = service.findAllOrderByCustomerId(id);
			request.getSession().setAttribute("orders", orders);
			response.sendRedirect("orders.jsp");
		} catch (OrderFormException e) {
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
