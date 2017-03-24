package servletBus;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.busDao;
import domain.Bus;

public class allBusServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		busDao busDao = new busDao();
		List<Bus> list = new ArrayList<Bus>();
		try {
			list = busDao.findAllBus();
			request.setAttribute("bus",list);
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
