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

import dao.buslineDao;
import dao.busticketDao;
import domain.BusLine;
import domain.BusTicket;

public class updateBusticketServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatime = new SimpleDateFormat("HH:mm");
		format.setLenient(false);
		
		BusTicket busticket = new BusTicket();
		busticketDao busticketDao = new busticketDao();
		buslineDao buslineDao = new buslineDao();
		String buslineNO = request.getParameter("buslineNO");
		List<Object> list = new ArrayList<Object>();
		try {
			
			BusLine busline = buslineDao.findBusline(buslineNO);
			BeanUtils.populate(busticket, request.getParameterMap());
			busticket.setDepartcity(busline.getDepartcity());
			busticket.setArrivalcity(busline.getArrivalcity());
			busticket.setDeparttime(busline.getDepartdate());
			busticket.setArrivaltime(busline.getArrivaldate());
			
			list.add(busticket.getBuslineNO());
			list.add(busticket.getDepartcity());
			list.add(busticket.getArrivalcity());
			list.add(format.parse(busticket.getTicketbuydate()));
			list.add(format.parse(busticket.getTicketusedate()));
			list.add(formatime.parse(busticket.getDeparttime()));
			list.add(formatime.parse(busticket.getArrivaltime()));
			list.add(Double.toString(busticket.getTicketprice()));
			list.add(busticket.getTicketmemo());
			list.add(busticket.getTicketNO());

			busticketDao.updateBusticket(list);
			
			/*busticketDao.updateBusticket(
					Integer.toString(busticket.getTicketNO()),
					Integer.toString(busticket.getBusNO()),
					busticket.getDepartcity(), busticket.getArrivalcity(),
					busticket.getTicketbuydate(), busticket.getTicketusedate(),
					Double.toString(busticket.getTicketprice()),
					busticket.getTicketmemo());*/

			request.getRequestDispatcher("/allBusticketServlet").forward(
					request, response);
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
