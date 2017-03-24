package servletBus;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.busDao;
import domain.Bus;

public class updateBusServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setLenient(false);
		
		Bus bus = new Bus();
		try {
			BeanUtils.populate(bus, request.getParameterMap());
			busDao busdao = new busDao();
			busdao.updateBus(bus.getBusNO(),bus.getBustype(),format.parse(bus.getBuydate()),format.parse(bus.getUsedate()),Integer.toString(bus.getSeatnum()),bus.getTV(),bus.getAircondition(),bus.getBusmemo());
			
			request.getRequestDispatcher("/allBusServlet").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
