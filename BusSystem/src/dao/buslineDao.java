package dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import domain.BusLine;
import util.C3P0Util;

public class buslineDao {
	/**
	 * 查看汽车线路的全部列表内容
	 * @return
	 * @throws SQLException
	 */
	public List<BusLine> findAllBusline() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "select * from busline";
		return qr.query(sql, new BeanListHandler<BusLine>(BusLine.class));
	}
	/**
	 * 根据条件进行多条件查询
	 * @param buslineNO
	 * @param departcity
	 * @param arrivalcity
	 * @param busNO
	 * @param price
	 * @param departdate
	 * @param arrivaldate
	 * @return
	 * @throws SQLException
	 * @throws ParseException 
	 */
	public List selectBusline(String buslineNO, String departcity, String arrivalcity, String busNO, String departdate, String arrivaldate) throws SQLException, ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		format.setLenient(false);
		
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "select * from busline where 1=1";
		List<Object> list = new ArrayList<Object>();
		if (!"".equals(buslineNO.trim())) {
			sql+=" and buslineNO like ?";
			list.add("%"+buslineNO.trim()+"%");
		}
		if (!"".equals(busNO.trim())) {
			sql+=" and busNO like ?";
			list.add("%"+busNO.trim()+"%");
		}
		if (!"".equals(departcity.trim())) {
			sql+=" and departcity=?";
			list.add(departcity.trim());
		}
		if (!"".equals(arrivalcity.trim())) {
			sql+=" and arrivalcity=?";
			list.add(arrivalcity.trim());
		}
		if (!"".equals(departdate.trim())) {
			sql+=" and departdate = ?";
			list.add(format.parse(departdate));
		}
		if (!"".equals(arrivaldate.trim())) {
			sql+=" and arrivaldate = ?";
			
			list.add(format.parse(arrivaldate));
		}
		
		return qr.query(sql, new BeanListHandler<BusLine>(BusLine.class),list.toArray());
		
	}
	
	/**
	 * 通过编辑按钮  在edit页面的显示数据
	 * @param buslineNO
	 * @return 
	 * @throws SQLException
	 */
	public BusLine editFindBusline(String buslineNO) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "select * from busline where buslineNO=?";
		return qr.query(sql, new BeanHandler<BusLine>(BusLine.class),buslineNO);
	}
	
	/**
	 * 修改线路信息
	 * @param busline
	 * @throws SQLException
	 */
	public void updateBusline(BusLine busline) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "update busline set departcity=?,busNO=?,arrivalcity=?,departdate=?,arrivaldate=?,buslinememo=? where buslineNO=?";
		qr.update(sql,busline.getDepartcity(),busline.getBusNO(),busline.getArrivalcity(),busline.getDepartdate(),busline.getArrivaldate(),busline.getBuslinememo(),busline.getBuslineNO());
	}
	
	/**
	 * 删除线路信息
	 * @param buslineNO
	 * @throws SQLException
	 */
	public void delectBusline(String buslineNO) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "delete from busline where buslineNO=?";
		qr.update(sql,buslineNO);
	}
	
	/**
	 * 添加线路信息 
	 * @param list
	 * @throws SQLException
	 */
	public void addBusline(List<Object> list) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "insert into busline(buslineNO,departcity,arrivalcity,departdate,arrivaldate,busNO,buslinememo) values(?,?,?,?,?,?,?)";
		qr.update(sql,list.toArray());
	}
	
	/**
	 * 添加车票信息页面上选择的某条线路的其他信息
	 * @param buslineNO
	 * @return
	 * @throws SQLException
	 */
	public BusLine findBusline(String buslineNO) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "select * from busline where buslineNO=?";
		return qr.query(sql, new BeanHandler<BusLine>(BusLine.class),buslineNO);
	}
	
	/**
	 * 查询该车是否已被其他线路使用
	 * @param busNO
	 * @return
	 * @throws SQLException
	 */
	public BusLine findBus(String busNO) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "select * from busline where busNO=?";
		return qr.query(sql, new BeanHandler<BusLine>(BusLine.class),busNO);
	}
}
