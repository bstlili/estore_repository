package com.briup.estore2.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore2.bean.Customer;
import com.briup.estore2.bean.OrderForm;
import com.briup.estore2.bean.Shipaddress;
import com.briup.estore2.bean.ShoppingCar;
import com.briup.estore2.service.OrderFormService;
import com.briup.estore2.service.ShipaddressService;
import com.briup.estore2.service.impl.OrderFormServiceImpl;
import com.briup.estore2.service.impl.ShipaddressServiceImpl;
import com.briup.estore2.util.exception.OrderFormException;
import com.briup.estore2.util.exception.ShipaddressException;

/**
 * Servlet implementation class ConfirmOrderServlet
 */
@WebServlet("/ConfirmOrderServlet")
public class ConfirmOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("sid");
		Long shipId = Long.parseLong(sid);
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		ShoppingCar shoppingCar = (ShoppingCar) session.getAttribute("shoppingCar");
		
		Shipaddress shipaddress = new Shipaddress();
		if (shipId==1) {
			shipaddress.setShipuname(customer.getName());
			shipaddress.setPhone(customer.getTelephone());
			shipaddress.setAdres(customer.getAddress());
			shipaddress.setCustomer(customer);
			
		}else{
			ShipaddressService service = new ShipaddressServiceImpl();
			try {
				shipaddress = service.findShipaddressById(shipId);
			
			} catch (ShipaddressException e) {
				e.printStackTrace();
			}
		}
		
		OrderForm order = new OrderForm();
		order.setCost(shoppingCar.getCost());
		order.setOrderDate(new Date());
		order.setCustomer(customer);
		order.setOrderLine(shoppingCar.getOrderLine().values());
		order.setShipaddress(shipaddress);
		request.getSession().setAttribute("order", order);
		System.out.println(order);
		OrderFormService service = new OrderFormServiceImpl();
		try {
			service.confirmOrder(order);
			//清空购物车
			shoppingCar.clear();
		} catch (OrderFormException e) {
			e.printStackTrace();
		}
		//页面跳转
		response.sendRedirect("confirmSuc.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
