package servletBus;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.busDao;
import domain.Bus;

public class selectBusServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String busNO = request.getParameter("busNO");
		String bustype = request.getParameter("bustype");
		String buydate = request.getParameter("buydate");
		String usedate = request.getParameter("usedate");
		String seatnum = request.getParameter("seatnum");
		String TV = request.getParameter("TV");
		String aircondition = request.getParameter("aircondition");
		
		try {
			busDao busdao = new busDao();
			List<Bus> list = busdao.selectBus(busNO, bustype, buydate, usedate, seatnum, TV, aircondition);
			
			request.setAttribute("bus", list);
			request.getRequestDispatcher("/admin/bus/list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
