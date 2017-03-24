package servletBus;

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

public class deleteBusServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String busNO = request.getParameter("busNO");
		busDao busdao = new busDao();
		buslineDao buslineDao = new buslineDao();
		
		try {
			List<Bus> bus = busdao.findAllBus();
			if (buslineDao.findBus(busNO)!=null) {
				request.setAttribute("bus", bus);
				request.setAttribute("msg_delete","还有线路使用此车，请先删除线路信息！");
				request.getRequestDispatcher("/admin/bus/list.jsp").forward(request, response);
				return;
			}
			busdao.delectBus(busNO);
			request.getRequestDispatcher("/allBusServlet").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
