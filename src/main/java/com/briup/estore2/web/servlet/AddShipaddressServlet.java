package com.briup.estore2.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore2.bean.Customer;
import com.briup.estore2.bean.Shipaddress;
import com.briup.estore2.service.impl.CustomerServiceImpl;
import com.briup.estore2.service.impl.ShipaddressServiceImpl;

/**
 * Servlet implementation class AddShipaddressServlet
 */
@WebServlet("/AddShipaddressServlet")
public class AddShipaddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收参数
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String telephone = request.getParameter("telephone");
		String customerId = request.getParameter("customerId");
		Long cid = Long.parseLong(customerId);
		
		Shipaddress shipaddress = new Shipaddress();
		shipaddress.setShipuname(name);
		shipaddress.setPhone(telephone);
		shipaddress.setAdres(address);
		CustomerServiceImpl cs = new CustomerServiceImpl();
		Customer customer;
		try {
			customer = cs.findCustomerById(cid);
			shipaddress.setCustomer(customer);
			System.out.println(shipaddress);
			//调用service层存值
			ShipaddressServiceImpl shipService = new ShipaddressServiceImpl();
			shipService.addShipaddress(shipaddress);
			request.getSession().setAttribute("shipaddress", shipaddress);
			response.sendRedirect("ShowAllShipaddServlet?customerId="+cid);
		} catch (Exception e) {
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
