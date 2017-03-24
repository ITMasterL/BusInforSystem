package form;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import dao.busticketDao;

public class busticketForm {
	private String ticketNO;
	private String buslineNO;
	private String departcity;
	private String arrivalcity;
	private String ticketbuydate;
	private String ticketusedate;
	private String departtime;
	private String arrivaltime;
	private double ticketprice;
	private String ticketmemo;
	private Map<String,String> msg = new HashMap<String, String>();
	busticketDao busticketDao = new busticketDao();
	
	public boolean validate() throws SQLException, ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		if ("".equals(buslineNO)) {
			msg.put("buslineNO","请选择线路编号！");
		}else if (busticketDao.findBusline(buslineNO)!=null) {
			msg.put("buslineNO","该线路已经被使用！");
		}
		
		if (0.0==ticketprice) {
			msg.put("ticketprice", "请输入票价！");
		}
		
		if ("".equals(ticketbuydate)) {
			msg.put("ticketbuydate","请输入购票日期！");
		}
		
		if ("".equals(ticketusedate)) {
			msg.put("ticketusedate", "请输入使用日期！");
		}else if ("".equals(ticketbuydate)) {
			
		}else if (format.parse(ticketbuydate).after(format.parse(ticketusedate))) {
			msg.put("ticketusedate", "请输入正确使用日期！");
		}
		
		return msg.isEmpty();
		
	}
	
	
	
	public String getTicketNO() {
		return ticketNO;
	}
	public void setTicketNO(String ticketNO) {
		this.ticketNO = ticketNO;
	}
	public String getBuslineNO() {
		return buslineNO;
	}
	public void setBuslineNO(String buslineNO) {
		this.buslineNO = buslineNO;
	}
	public String getDepartcity() {
		return departcity;
	}
	public void setDepartcity(String departcity) {
		this.departcity = departcity;
	}
	public String getArrivalcity() {
		return arrivalcity;
	}
	public void setArrivalcity(String arrivalcity) {
		this.arrivalcity = arrivalcity;
	}
	public String getTicketbuydate() {
		return ticketbuydate;
	}
	public void setTicketbuydate(String ticketbuydate) {
		this.ticketbuydate = ticketbuydate;
	}
	public String getTicketusedate() {
		return ticketusedate;
	}
	public void setTicketusedate(String ticketusedate) {
		this.ticketusedate = ticketusedate;
	}
	public String getDeparttime() {
		return departtime;
	}
	public void setDeparttime(String departtime) {
		this.departtime = departtime;
	}
	public String getArrivaltime() {
		return arrivaltime;
	}
	public void setArrivaltime(String arrivaltime) {
		this.arrivaltime = arrivaltime;
	}
	public double getTicketprice() {
		return ticketprice;
	}
	public void setTicketprice(double ticketprice) {
		this.ticketprice = ticketprice;
	}
	public String getTicketmemo() {
		return ticketmemo;
	}
	public void setTicketmemo(String ticketmemo) {
		this.ticketmemo = ticketmemo;
	}
	public Map<String, String> getMsg() {
		return msg;
	}
	public void setMsg(Map<String, String> msg) {
		this.msg = msg;
	}
}
