package com.briup.estore2.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore2.bean.ShoppingCar;

/**
 * Servlet implementation class UpdateShopCartServlet
 */
@WebServlet("/UpdateShopCartServlet")
public class UpdateShopCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateShopCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ղ���
		String id = request.getParameter("id");
		String num = request.getParameter("num");
		
		Long bookId = Long.parseLong(id);
		Integer n = Integer.parseInt(num);
		
		//��ȡ���ﳵ
		HttpSession session = request.getSession();
		ShoppingCar shoppingCar = (ShoppingCar) session.getAttribute("shoppingCar");
		shoppingCar.update(bookId, n);
		//���´���session
		session.setAttribute("shoppingCar", shoppingCar);
		//������ת��shopCart.jspҳ��
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
