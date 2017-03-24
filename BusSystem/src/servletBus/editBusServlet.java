package servletBus;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.busDao;
import domain.Bus;

public class editBusServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String busNO = request.getParameter("busNO");
		busDao busdao = new busDao();
		try {
			Bus bus = busdao.findbus(busNO);
			request.setAttribute("bus", bus);
			request.getRequestDispatcher("admin/bus/edit.jsp").forward(request,response);
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
