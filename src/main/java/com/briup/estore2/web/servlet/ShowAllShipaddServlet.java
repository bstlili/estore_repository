package com.briup.estore2.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore2.bean.Shipaddress;
import com.briup.estore2.service.impl.ShipaddressServiceImpl;
import com.briup.estore2.util.exception.ShipaddressException;
@WebServlet("/ShowAllShipaddServlet")
public class ShowAllShipaddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String customerId = request.getParameter("customerId");
		Long cid = Long.parseLong(customerId);
	
		ShipaddressServiceImpl serviceImpl = new ShipaddressServiceImpl();
		try {
			List<Shipaddress> list = serviceImpl.findShipaddressByCustomerId(cid);
			HttpSession session = request.getSession();
			session.setAttribute("shipList", list);
			response.sendRedirect("confirm.jsp");
		} catch (ShipaddressException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
