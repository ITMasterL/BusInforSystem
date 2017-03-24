package servletBusline;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.buslineDao;
import domain.BusLine;

public class allBuslineServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		buslineDao buslinedao = new buslineDao();
		List<BusLine> list = new ArrayList<BusLine>();
		try {
			list = buslinedao.findAllBusline();
			request.setAttribute("busline", list);
			request.getRequestDispatcher("/admin/busline/list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
