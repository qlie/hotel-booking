package com.fenglinwan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fenglinwan.service.OrderService;
import com.fenglinwan.service.RoomService;

/**
 * Servlet implementation class SaveOrderServlet
 */
@WebServlet("/SaveOrderServlet")
public class SaveOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SaveOrderServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = (String) request.getSession().getAttribute("name");
		String userId = (String) request.getSession().getAttribute("id");
		String usersex = (String) request.getSession().getAttribute("sex");
		String userPhone = (String) request.getSession().getAttribute("phone");
		String hotelId = (String) request.getSession().getAttribute("hotelId");
		String hotelName = (String) request.getSession().getAttribute("hotelName");
		String roomName = (String) request.getSession().getAttribute("roomName");
		String roomId = (String) request.getSession().getAttribute("roomId");
		String roomMoney = (String) request.getSession().getAttribute("money");
		String orderdate = (String) request.getSession().getAttribute("choosedate");
		String roomType = (String) request.getSession().getAttribute("roomType");
		int result = new OrderService().ie(userName, userId, usersex, userPhone, hotelId, hotelName, roomName, roomId,
				roomMoney, roomType, orderdate);
		if (result > 0) {
			System.out.println("会员下单成功");
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head><title>预定成功</title></head>");
			out.println("<body>");
			out.println("<h1 align='center'>预定成功！</h1>");
			out.println("<a href='index.jsp'>返回首页</a>");
			out.println("</body></html>");
			out.flush();
			out.close();
		} else {
			System.out.println("下单失败");
		}

	}

}
