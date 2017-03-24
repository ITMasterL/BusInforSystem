package servletBusline;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.busDao;
import dao.buslineDao;
import domain.Bus;
import domain.BusLine;

public class editBuslineServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String buslineNO = request.getParameter("buslineNO");
		buslineDao buslineDao = new buslineDao();
		busDao busDao = new busDao();
		BusLine busLine = new BusLine();
		try {
			busLine = buslineDao.editFindBusline(buslineNO);
			List<Bus> busNO = busDao.findAllBus();
			request.setAttribute("busline", busLine);
			request.setAttribute("bus", busNO);
			request.getRequestDispatcher("/admin/busline/edit.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
