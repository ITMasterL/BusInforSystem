package servletBusticket;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.buslineDao;
import dao.busticketDao;
import domain.BusLine;
import domain.BusTicket;

public class allBusticketServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		busticketDao busticketDao = new busticketDao();
		buslineDao buslineDao = new buslineDao();
		List<BusTicket> list = new ArrayList<BusTicket>();
		try {
			list = busticketDao.findAllBusticket();
			BusLine busline = buslineDao.findBusline("a6a1f886-1741-44ca-97b2-8f72ff4e4436");
			request.setAttribute("busline",busline);
			request.setAttribute("busticket",list);
			request.getRequestDispatcher("/admin/busticket/list.jsp").forward(request, response);
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
