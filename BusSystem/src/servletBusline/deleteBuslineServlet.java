package servletBusline;

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

public class deleteBuslineServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String buslineNO = request.getParameter("buslineNO");
		buslineDao buslineDao = new buslineDao();
		busticketDao busticketDao = new busticketDao();
		
		try {
			if (busticketDao.findBusline(buslineNO)!=null) {
				List<BusLine> busline = buslineDao.findAllBusline();
				request.setAttribute("msg_delete", "还有车票使用此线路，请先删除车票信息！");
				request.setAttribute("busline", busline);
				request.getRequestDispatcher("/admin/busline/list.jsp").forward(request, response);
				return;
			}
			buslineDao.delectBusline(buslineNO);
			
			request.getRequestDispatcher("/allBuslineServlet").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
