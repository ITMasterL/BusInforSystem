package form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class busForm {
	private String busNO;
	private String bustype;
	private String buydate;
	private String usedate;
	private int seatnum;
	private String TV;
	private String aircondition;
	private String busmemo;
	private Map<String, String> msg = new HashMap<String, String>();
	
 	public boolean validate() throws ParseException {
 		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if ("".equals(bustype)) {
			msg.put("bustype", "请选择车辆类型！");
		}
		
		if ("".equals(buydate)) {
			msg.put("buydate", "请输入购买日期！");
		}
		
		if ("".equals(usedate)) {
			msg.put("usedate","请输入使用日期");
		}else if ("".equals(buydate)) {
			
		} else if (format.parse(buydate).after(format.parse(usedate))) {
			msg.put("usedate","请输正确使用时期！");
		}
		
		if (0==seatnum) {
			msg.put("seatnum", "请输入最大载客人数！");
		}
		
		if ("".equals(TV)) {
			msg.put("TV","请选择是否有TV!");
		}
		
		if ("".equals(aircondition)) {
			msg.put("aircondition", "请选择是否有空调！");
		}
		
		return msg.isEmpty();
		
	}
	
	public String getBusNO() {
		return busNO;
	}
	public void setBusNO(String busNO) {
		this.busNO = busNO;
	}
	public String getBustype() {
		return bustype;
	}
	public void setBustype(String bustype) {
		this.bustype = bustype;
	}
	public String getBuydate() {
		return buydate;
	}
	public void setBuydate(String buydate) {
		this.buydate = buydate;
	}
	public String getUsedate() {
		return usedate;
	}
	public void setUsedate(String usedate) {
		this.usedate = usedate;
	}
	public int getSeatnum() {
		return seatnum;
	}
	public void setSeatnum(int seatnum) {
		this.seatnum = seatnum;
	}
	public String getTV() {
		return TV;
	}
	public void setTV(String tV) {
		TV = tV;
	}
	public String getAircondition() {
		return aircondition;
	}
	public void setAircondition(String aircondition) {
		this.aircondition = aircondition;
	}
	public String getBusmemo() {
		return busmemo;
	}
	public void setBusmemo(String busmemo) {
		this.busmemo = busmemo;
	}



	public Map<String, String> getMsg() {
		return msg;
	}



	public void setMsg(Map<String, String> msg) {
		this.msg = msg;
	}
}
