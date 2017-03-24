package servletBusticket;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import util.UUIDUtil;
import dao.buslineDao;
import dao.busticketDao;
import domain.BusLine;
import form.busticketForm;

public class addBusticketServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		busticketForm busticket = new busticketForm();
		busticketDao busticketDao = new busticketDao();
		buslineDao buslineDao = new buslineDao();
		List<Object> list = new ArrayList<Object>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatime = new SimpleDateFormat("HH:mm");
		format.setLenient(false);
		
		try {
			BeanUtils.populate(busticket, request.getParameterMap());
			List<BusLine> allBusline = buslineDao.findAllBusline();
			if (!busticket.validate()) {
				request.setAttribute("busline", allBusline);
				request.setAttribute("msg",busticket.getMsg());
				request.getRequestDispatcher("/admin/busticket/add.jsp").forward(request, response);
				return;
			}
			BusLine busline = buslineDao.findBusline(busticket.getBuslineNO());
			busticket.setTicketNO(UUIDUtil.getUUID());
			
			busticket.setDepartcity(busline.getDepartcity());
			busticket.setArrivalcity(busline.getArrivalcity());
			busticket.setDeparttime(busline.getDepartdate());
			busticket.setArrivaltime(busline.getArrivaldate());
			
			list.add(busticket.getTicketNO());
			list.add(busticket.getBuslineNO());
			list.add(busticket.getDepartcity());
			list.add(busticket.getArrivalcity());
			list.add(format.parse(busticket.getTicketbuydate()));
			list.add(format.parse(busticket.getTicketusedate()));
			list.add(formatime.parse(busticket.getDeparttime()));
			list.add(formatime.parse(busticket.getArrivaltime()));
			list.add(Double.toString(busticket.getTicketprice()));
			list.add(busticket.getTicketmemo());
			

			busticketDao.addBusticket(list);
			
			request.getRequestDispatcher("/allBusticketServlet").forward(request, response);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
