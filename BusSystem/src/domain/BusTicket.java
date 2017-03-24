package domain;


public class BusTicket {
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
	public BusTicket() {
		super();
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
	
	
}
