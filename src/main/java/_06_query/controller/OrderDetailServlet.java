package _06_query.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _03_ShoppingCart.model.Order_Bean;
import _03_ShoppingCart.model.Order_DAO;
import _03_ShoppingCart.model.OrderDetail_Bean;
@WebServlet("/_06_query/orderDetail.do")
public class OrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String ordId = request.getParameter("ordId");
		int no  = Integer.valueOf(ordId);   // ###
		try {
			Order_DAO ordDAO = new Order_DAO();
			Order_Bean ob = ordDAO.getOrder(no);
			request.setAttribute("OrderBean", ob);
			RequestDispatcher  rd = request.getRequestDispatcher("ShowOrderDetail.jsp");
			rd.forward(request, response);
			return;
		} catch (SQLException e) {
			throw new ServletException(e);
		} catch (NamingException e) {
			throw new ServletException(e);
		}
	}

	public void displayOrderBean(Order_Bean ob) {
//		System.out.println("ob.getOrderNo()=" + ob.getOrderNo());
//		System.out.println("ob.getUserID()=" + ob.getUserId());
//		System.out.println("ob.getOrderDate=" + ob.getOrderDate());
//		System.out.println("ob.getTotalAmount=" + ob.getTotalAmount());
//		System.out.println("ob.getInvoiceTitle=" + ob.getInvoiceTitle());
//		System.out.println("ob.getBNO=" + ob.getBno());
//		System.out.println("ob.getShippingAddress=" + ob.getShippingAddress());
//		System.out.println("ob.getCancelTag=" + ob.getCancelTag());
//		System.out.println("==============訂單明細=================");
		List<OrderDetail_Bean> items = ob.getItems();
		for (OrderDetail_Bean oib : items) {
//			System.out.println("---------------一筆明細---------------");
//			System.out.println("   oib.getSeqno()=" + oib.getSeqno());
//			System.out.println("   oib.getOrderNo()=" + oib.getOrderNo());
//			System.out.println("   oib.getBookId()=" + oib.getBookId());
//			System.out.println("   oib.getDescription()="
//					+ oib.getDescription());
//			System.out.println("   oib.getAmount()=" + oib.getAmount());
//			System.out.println("   oib.getUnitPrice()=" + oib.getUnitPrice());
//			System.out.println("   oib.getDiscount()=" + oib.getDiscount());
		}
	}
}