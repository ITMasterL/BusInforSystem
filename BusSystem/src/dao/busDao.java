package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import util.C3P0Util;
import domain.Bus;

public class busDao {
	
	/**
	 * 汽车信息列表查询
	 * @return
	 * @throws SQLException
	 */
	public List<Bus> findAllBus () throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "select * from bus";
		return qr.query(sql, new BeanListHandler<Bus>(Bus.class));
	}
	
	/**
	 * 根据查询条件查询
	 * @param busNO
	 * @param bustype
	 * @param buydate
	 * @param usedate
	 * @param seatnum
	 * @param TV
	 * @param aircondition
	 * @return
	 * @throws SQLException
	 */
	
	public List<Bus> selectBus(String busNO,String bustype,String buydate,String usedate,String seatnum,String TV,String aircondition) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		List<Object> list = new ArrayList<Object>();
		String sql = "select * from bus where 1=1";
		if (!"".equals(busNO.trim())) {
			sql+=" and busNO like ?";
			list.add("%"+busNO+"%");
		}
		if (!"".equals(bustype.trim())) {
			sql+=" and bustype like ?";
			list.add("%"+bustype+"%");
		}
		if (!"".equals(buydate.trim())) {
			sql+=" and buydate like ?";
			list.add("%"+buydate.trim()+"%");
		}
		if (!"".equals(usedate.trim())) {
			sql+=" and usedate like ?";
			list.add("%"+usedate.trim()+"%");
		}
		if (!"".equals(seatnum.trim())) {
			sql+=" and seatnum=?";
			list.add(seatnum);
		}
		if (!"".equals(TV.trim())) {
			sql+=" and TV=?";
			list.add(TV);
		}
		if (!"".equals(aircondition.trim())) {
			sql+=" and aircondition=?";
			list.add(aircondition);
		}
		for (Object object : list.toArray()) {
			System.out.println();
		}
		return qr.query(sql, new BeanListHandler<Bus>(Bus.class),list.toArray());
	}
	
	/**
	 * 根据list页面传来的busNO 查询信息 填在编辑页面
	 * @param busNO
	 * @return
	 * @throws SQLException
	 */
	
	public Bus findbus(String busNO) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "select * from bus where busNO=?";
		return qr.query(sql, new BeanHandler<Bus>(Bus.class),busNO);
	}
	
	/**
	 * 修改汽车信息
	 * @param busNO
	 * @param bustype
	 * @param buydate
	 * @param usedate
	 * @param seatnum
	 * @param TV
	 * @param aircondition
	 * @param busmemo
	 * @throws SQLException
	 */
	public void updateBus(String busNO, String bustype, Date buydate,Date usedate, String seatnum, String TV, String aircondition,String busmemo) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "update bus set bustype=?,buydate=?,usedate=?,seatnum=?,TV=?,aircondition=?,busmemo=? where busNO=?";
		qr.update(sql,bustype,buydate,usedate,seatnum,TV,aircondition,busmemo,busNO);
	}
	/**
	 * 删除汽车信息
	 * @param busNO
	 * @throws SQLException 
	 */
	public void delectBus(String busNO) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("delete from bus where busNO=?",busNO);
	}
	/**
	 * 添加车辆信息
	 * @param bus
	 * @throws SQLException 
	 */
	public void addBus(String busNO,String bustype, Date buydate,Date usedate, String seatnum, String TV, String aircondition,String busmemo) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "insert into bus(busNO,bustype,buydate,usedate,seatnum,TV,aircondition,busmemo) values(?,?,?,?,?,?,?,?)";
		qr.update(sql,busNO,bustype,buydate,usedate,seatnum,TV,aircondition,busmemo);
	}
	
	/**
	 * 查找是否汽车编号已被其他线路占用
	 *//*
	public boolean repbusNO(String busNO) {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "select * from bus where busNO=?";
		qr.query(sql, busNO);
		
	}*/
}
