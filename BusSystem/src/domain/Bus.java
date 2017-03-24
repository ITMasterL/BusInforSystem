package domain;

import java.util.Date;

public class Bus {
	private String busNO;
	private String bustype;
	private String buydate;
	private String usedate;
	private int seatnum;
	private String TV;
	private String aircondition;
	private String busmemo;
	public Bus() {
		super();
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

}
