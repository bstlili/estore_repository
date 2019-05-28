package com.briup.estore2.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore2.bean.Customer;
import com.briup.estore2.bean.OrderForm;
import com.briup.estore2.service.OrderFormService;
import com.briup.estore2.service.impl.OrderFormServiceImpl;
import com.briup.estore2.util.exception.OrderFormException;

/**
 * Servlet implementation class DelOrderServlet
 */
@WebServlet("/DelOrderServlet")
public class DelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//删除特定的订单
		//接收要删除的订单编号
		String oid = request.getParameter("orderid");
		Long orderId = Long.parseLong(oid);
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		//调用service层方法
		OrderFormService service = new OrderFormServiceImpl();
		try {
			//删除对应订单
			service.delOrderById(orderId);
			List<OrderForm> orders = service.findAllOrderByCustomerId(customer.getId());
			session.setAttribute("orders", orders);
		} catch (OrderFormException e) {
			e.printStackTrace();
		}
		String url="orders.jsp";
		response.sendRedirect(url);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
