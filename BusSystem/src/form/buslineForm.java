package form;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import dao.buslineDao;

public class buslineForm {
	private String buslineNO;
	private String busNO;
	private String departcity;
	private String arrivalcity;
	private String departdate;
	private String arrivaldate;
	private String buslinememo;
	private Map<String, String> msg = new HashMap<String, String>();
	buslineDao buslineDao = new buslineDao();
	
	/*public boolean repBusNO() {
		return busDao.findbus(busNO);
	}*/
	
	public boolean validate() throws ParseException, SQLException {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		if ("".equals(busNO)) {
			msg.put("busNO", "请选择汽车编号！");
		}else if (buslineDao.findBus(busNO)!=null) {
			msg.put("busNO","此车已被其他线路使用！");
		}
		
		if ("".equals(departcity)) {
			msg.put("departcity", "请输入起始站！");
		}
		
		if ("".equals(arrivalcity)) {
			msg.put("arrivalcity", "请输入终点站！");
		}
		
		if ("".equals(departdate)) {
			msg.put("departdate","请输入出发时间！");
		}
		
		if ("".equals(arrivaldate)) {
			msg.put("arrivaldate", "请输入到达时间！");
		}else if ("".equals(departdate)) {
			
		}else if (format.parse(departdate).after(format.parse(arrivaldate))) {
			msg.put("arrivaldate", "请输入正确到达时间！");
		}
		
		return msg.isEmpty();
		
	}
	
	public Map<String, String> getMsg() {
		return msg;
	}
	public void setMsg(Map<String, String> msg) {
		this.msg = msg;
	}
	public String getBuslineNO() {
		return buslineNO;
	}
	public void setBuslineNO(String buslineNO) {
		this.buslineNO = buslineNO;
	}
	public String getBusNO() {
		return busNO;
	}
	public void setBusNO(String busNO) {
		this.busNO = busNO;
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
	public String getDepartdate() {
		return departdate;
	}
	public void setDepartdate(String departdate) {
		this.departdate = departdate;
	}
	public String getArrivaldate() {
		return arrivaldate;
	}
	public void setArrivaldate(String arrivaldate) {
		this.arrivaldate = arrivaldate;
	}
	public String getBuslinememo() {
		return buslinememo;
	}
	public void setBuslinememo(String buslinememo) {
		this.buslinememo = buslinememo;
	}
	
	
	
}
