package servletBusticket;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.busticketDao;

public class deleteBusticketServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ticketNO = request.getParameter("ticketNO");
		busticketDao busticketDao = new busticketDao();
		
		try {
			busticketDao.deleteBusticketSerclet(ticketNO);
			request.getRequestDispatcher("/allBusticketServlet").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
