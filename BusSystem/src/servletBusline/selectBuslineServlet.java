package servletBusline;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.buslineDao;
import domain.BusLine;

public class selectBuslineServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		BusLine busline = new BusLine();
		buslineDao buslinedao = new buslineDao();
		
			try {
				BeanUtils.populate(busline, request.getParameterMap());
				List list = buslinedao.selectBusline(busline.getBuslineNO(),busline.getDepartcity(),busline.getArrivalcity(),busline.getBusNO(),busline.getDepartdate(),busline.getArrivaldate());
				
				request.setAttribute("busline",list);
				request.getRequestDispatcher("/admin/busline/list.jsp").forward(request, response);
				
			} catch (IllegalAccessException e) {
				System.out.println("IllegalAccessException");
			} catch (InvocationTargetException e) {
				System.out.println("InvocationTargetException");
			} catch (SQLException e) {
				System.out.println("SQLException");
				e.printStackTrace();
			} catch (ParseException e) {
				System.out.println("ParseException");
				e.printStackTrace();
			}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
