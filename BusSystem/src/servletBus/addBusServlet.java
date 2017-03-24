package servletBus;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import util.UUIDUtil;
import dao.busDao;
import domain.Bus;
import form.busForm;

public class addBusServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		busDao busdao = new busDao();
		busForm bus = new busForm();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setLenient(false);
		
		
		
			try {
				BeanUtils.populate(bus,request.getParameterMap());
				if (!bus.validate()) {
					request.setAttribute("msg",bus.getMsg());
					request.getRequestDispatcher("/admin/bus/add.jsp").forward(request, response);
					return;
				}
				System.out.println(bus.getBustype());
				System.out.println(bus.getBuydate());
				bus.setBusNO(UUIDUtil.getUUID());
				busdao.addBus(bus.getBusNO(),bus.getBustype(),format.parse(bus.getBuydate()),format.parse(bus.getUsedate()),Integer.toString(bus.getSeatnum()),bus.getTV(),bus.getAircondition(),bus.getBusmemo());
				request.getRequestDispatcher("/allBusServlet").forward(request, response);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
