package dao;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import util.C3P0Util;
import domain.User;
import form.UserForm;

public class userDao {
	
	/**
	 * 登陆是通过查找用户判断
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User findUser(User user)throws Exception {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "select * from user where username=? and password=?";
		return qr.query(sql, new BeanHandler<User>(User.class),user.getUsername(),user.getPassword());
	}
	
	/**
	 * 添加用户信息
	 * @param userForm
	 * @throws SQLException
	 */
	public void addUser(UserForm userForm) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "insert into user(userID,username,password,permission) values(?,?,?,?)";
		qr.update(sql,userForm.getUserID(),userForm.getUsername(),userForm.getPassword(),userForm.getPermission());
	}

	/**
	 * 查找重复用户名
	 * @param userForm
	 * @return
	 * @throws SQLException
	 */
	public boolean validateUser(UserForm userForm) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "select * from user where username=?";
		User user = qr.query(sql, new BeanHandler<User>(User.class),userForm.getUsername());
		if (user==null) {
			return false;
		}
		return true;
	}
	
	/**
	 * 管理员查询列表显示查询
	 * @return
	 * @throws SQLException
	 */
	public List<User> findAllUser() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "select * from user where permission='普通管理员'";
		return qr.query(sql, new BeanListHandler<User>(User.class));
	}

	/**
	 * 编辑页面显示的信息查询
	 * @param userID
	 * @return
	 * @throws SQLException
	 */
	public User findEditUser(String userID) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "select * from user where userID=?";
		return qr.query(sql, new BeanHandler<User>(User.class),userID);
		
	}

	/**
	 * 多条件查询
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public List<User> selectUser(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "select * from user where permission='普通管理员'";
		List<String> list = new ArrayList<String>();
		if (!"".equals(user.getUserID().trim())) {
			sql+=" and userID like ?";
			list.add("%"+user.getUserID().trim()+"%");
		}
		if (!"".equals(user.getUsername().trim())) {
			sql+=" and username like ?";
			list.add("%"+user.getUsername().trim()+"%");
		}
		return qr.query(sql, new BeanListHandler<User>(User.class),list.toArray());
	}

	/**
	 * 修改表中某条数据
	 * @param user
	 * @throws SQLException
	 */
	public void updateUser(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "update user set username=?,password=? where userID=?";
		qr.update(sql,user.getUsername(),user.getPassword(),user.getUserID());
	}

	/**
	 * 删除某用户
	 * @param userID
	 * @throws SQLException
	 */
	public void deleteUser(String userID) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql= "delete from user where userID=?";
		qr.update(sql,userID);
	}

	/**
	 * 修改密码时查询原密码是否正确
	 * @param userID
	 * @param password
	 * @throws SQLException
	 */
	public User findPwdUser(String userID, String password) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "select * from user where userID=? and password=?";
		return qr.query(sql, new BeanHandler<User>(User.class),userID,password);
		
	}

}













