package servletBusticket;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.busDao;
import dao.buslineDao;
import domain.Bus;
import domain.BusLine;

public class allbuslineNoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		buslineDao buslineDao = new buslineDao();
		try {
			List<BusLine> busline = buslineDao.findAllBusline();
			request.setAttribute("busline",busline);
			request.getRequestDispatcher("/admin/busticket/add.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
