package servletBusticket;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.buslineDao;
import dao.busticketDao;
import domain.BusLine;
import domain.BusTicket;

public class editBusticketServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ticketNO = request.getParameter("ticketNO");
		buslineDao buslineDao = new buslineDao();
		busticketDao busticketDao = new busticketDao();
		
		try {
			BusTicket ticket = busticketDao.findBusticket(ticketNO);
			List<BusLine> busline = buslineDao.findAllBusline();
			request.setAttribute("busline", busline);
			request.setAttribute("busticket",ticket);
			request.getRequestDispatcher("/admin/busticket/edit.jsp").forward(request, response);
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
