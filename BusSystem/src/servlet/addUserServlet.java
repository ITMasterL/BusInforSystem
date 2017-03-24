package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import util.UUIDUtil;
import dao.userDao;
import domain.User;
import form.UserForm;

public class addUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		userDao userDao = new userDao();
		User user = new User();
		String checkcode_session = (String) request.getSession().getAttribute("checkcode_session");
		UserForm userForm = new UserForm();
		/*String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		String reppwd = request.getParameter("reppassword");
		String ckcode = request.getParameter("ckcode");*/
		/*if ("".equals(username)) {
			request.setAttribute("name_msg", "不能为空！");
			request.getRequestDispatcher("/admin/user/add.jsp").forward(request, response);
			return;
		}
		if ("".equals(pwd)) {
			request.setAttribute("pwd_msg", "不能为空！");
			request.getRequestDispatcher("/admin/user/add.jsp").forward(request, response);
			return;
		}
		if ("".equals(reppwd)) {
			request.setAttribute("reppwd_msg", "不能为空！");
			request.getRequestDispatcher("/admin/user/add.jsp").forward(request, response);
			return;
		}
		if ("".equals(ckcode)) {
			request.setAttribute("ckcode_msg", "不能为空！");
			request.getRequestDispatcher("/index.jsp").forward(request,	response);
			return;
		}
		if (!pwd.equals(reppwd)) {
			request.setAttribute("pwd", "密码不一致");
			request.getRequestDispatcher("/admin/user/add.jsp").forward(request, response);
			return;
		}
		if (!checkcode_session.equals(ckcode)) {
			request.setAttribute("ckcode", "验证码错误！");
			request.getRequestDispatcher("/admin/user/add.jsp").forward(request,response);
			return;
		}*/
		
		try {
			BeanUtils.populate(userForm, request.getParameterMap());
			userForm.setPermission("普通管理员");
			if (userDao.validateUser(userForm)) {
				request.setAttribute("user_msg", "用户名已存在！");
				request.getRequestDispatcher("/admin/user/add.jsp").forward(request, response);
				return;
			}
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		if (!userForm.validate(checkcode_session)) {
			request.setAttribute("msg", userForm.getMessage());
			request.getRequestDispatcher("/admin/user/add.jsp").forward(request, response);
			return;
		}
		try {
			userForm.setUserID(UUIDUtil.getUUID());
			userDao.addUser(userForm);
			request.getRequestDispatcher("/admin/login/welcome.jsp").forward(request, response);
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
