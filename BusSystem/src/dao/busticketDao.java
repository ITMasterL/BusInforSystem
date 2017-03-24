package dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import util.C3P0Util;
import domain.BusTicket;

public class busticketDao {

	/**
	 * 查询所有车票的列表信息
	 * @return
	 * @throws SQLException
	 */
	public List<BusTicket> findAllBusticket() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "select * from busticket";
		return qr.query(sql, new BeanListHandler<BusTicket>(BusTicket.class));
		
	}
	
	/**
	 * 根据获取的信息进行多条件查询
	 * @param busTicket
	 * @return
	 * @throws SQLException
	 * @throws ParseException 
	 */
	public List<BusTicket> selectBusticket(BusTicket busTicket) throws SQLException, ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setLenient(false);
		
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "select * from busticket where 1=1";
		List<Object> list = new ArrayList<Object>();
		if (!"".equals(busTicket.getTicketNO().trim())) {
			sql+=" and ticketNO like ?";
			list.add("%"+busTicket.getTicketNO().trim()+"%");
		}
		if (!"".equals(busTicket.getBuslineNO().trim())) {
			sql+=" and buslineNO like ?";
			list.add("%"+busTicket.getBuslineNO().trim()+"%");
		}
		if (!"".equals(busTicket.getDepartcity().trim())) {
			sql+=" and departcity=?";
			list.add(busTicket.getDepartcity().trim());
		}
		if (!"".equals(busTicket.getArrivalcity().trim())) {
			sql+=" and arrivalcity=?";
			list.add(busTicket.getArrivalcity().trim());
		}
		if (!"".equals(busTicket.getTicketbuydate().trim())) {
			sql+=" and ticketbuydate=?";
			list.add(format.parse(busTicket.getTicketbuydate().trim()));
		}
		if (!"".equals(busTicket.getTicketusedate().trim())) {
			sql+=" and ticketusedate=?";
			list.add(format.parse(busTicket.getTicketusedate().trim()));
		}
		if (!"0.0".equals(Double.toString(busTicket.getTicketprice()).trim())) {
			sql+=" and ticketprice=?";
			list.add(Double.toString(busTicket.getTicketprice()).trim());
		} 
		
		return qr.query(sql, new BeanListHandler<BusTicket>(BusTicket.class),list.toArray());
		
	}
	
	/**
	 * 点击编辑按钮时，根据ID获取所要编辑的数据
	 * @param ticketNO
	 * @return
	 * @throws SQLException
	 */
	public BusTicket findBusticket(String ticketNO) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "select * from busticket where ticketNO=?";
		return qr.query(sql,new BeanHandler<BusTicket>(BusTicket.class),ticketNO);
	}

	/**
	 * 根据获取的ID删除某列数据
	 * @param ticketNO
	 * @throws SQLException 
	 */
	public void deleteBusticketSerclet(String ticketNO) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "delete from busticket where ticketNO=?";
		qr.update(sql,ticketNO);
	}

	/**
	 * 修改车票信息
	 * @param list
	 * @throws SQLException
	 */
	/* 
	 public void updateBusticket(String ticketNO, String busNO,
			String departcity, String arrivalcity, String ticketbuydate,
			String ticketusedate, String ticketprice, String ticketmemo) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "update busticket set busNO=?,departcity=?,arrivalcity=?,ticketbuydate=?,ticketusedate=?,ticketprice=?,ticketmemo=? where ticketNO=?";
		qr.update(sql,busNO,departcity,arrivalcity,ticketbuydate,ticketusedate,ticketprice,ticketmemo,ticketNO);
	}*/
	
	//此方法是上个注释放发的简化版
	public void updateBusticket(List<Object> list) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "update busticket set buslineNO=?,departcity=?,arrivalcity=?,ticketbuydate=?,ticketusedate=?,departtime=?,arrivaltime=?,ticketprice=?,ticketmemo=? where ticketNO=?";
		qr.update(sql,list.toArray());
	}
	
	/**
	 * 添加车票信息
	 * @param list
	 * @throws SQLException
	 */
	public void addBusticket(List<Object> list) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "insert into busticket(ticketNO,buslineNO,departcity,arrivalcity,ticketbuydate,ticketusedate,departtime,arrivaltime,ticketprice,ticketmemo) values(?,?,?,?,?,?,?,?,?,?)";
		qr.update(sql,list.toArray());
	}

	/**
	 * 查询该线路时候已经被其他车票所用
	 * @param buslineNO
	 * @return
	 * @throws SQLException
	 */
	public BusTicket findBusline(String buslineNO) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "select * from busticket where buslineNO=?";
		return qr.query(sql,new BeanHandler<BusTicket>(BusTicket.class),buslineNO);
	}
}
