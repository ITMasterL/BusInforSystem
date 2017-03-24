package servletBusline;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import util.UUIDUtil;
import dao.busDao;
import dao.buslineDao;
import domain.Bus;
import form.buslineForm;

public class addBuslineServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		buslineForm busline = new buslineForm(); 
		buslineDao buslineDao = new buslineDao();
		busDao busDao = new busDao();
		
		List<Object> list = new ArrayList<Object>();
//		list.add(Integer.toString(busline.getBuslineNO()));
		
		try {
			BeanUtils.populate(busline, request.getParameterMap());
			List<Bus> bus = busDao.findAllBus();
			if (!busline.validate()) {
				request.setAttribute("msg", busline.getMsg());
				request.setAttribute("bus", bus);
				request.getRequestDispatcher("/admin/busline/add.jsp").forward(request, response);
				return;
			}
			busline.setBuslineNO(UUIDUtil.getUUID());
			list.add(busline.getBuslineNO());
			list.add(busline.getDepartcity());
			list.add(busline.getArrivalcity());
			list.add(busline.getDepartdate());
			list.add(busline.getArrivaldate());
			list.add(busline.getBusNO());
			list.add(busline.getBuslinememo());
			
			buslineDao.addBusline(list);
			
			request.getRequestDispatcher("/allBuslineServlet").forward(request, response);
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
