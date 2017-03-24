package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.userDao;
import domain.User;

public class loginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = new User();
		String ckcode = (String) request.getParameter("ckcode");
		
		
		try {
			BeanUtils.populate(user, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if("".equals(user.getUsername())){
			request.setAttribute("username_msg", "请填写用户名！");
			request.getRequestDispatcher("/index.jsp").forward(request,response);
			return;
		}
		if ("".equals(user.getPassword())) {
			request.setAttribute("password_msg", "请填写密码！");
			request.getRequestDispatcher("/index.jsp").forward(request,response);
			return;
		}
		if("".equals(ckcode)){
			request.setAttribute("ckcode_msg", "请填写验证码！");
			request.getRequestDispatcher("/index.jsp").forward(request,response);
			return;
		}
		//判断验证码是否为空或错误
		String checkcode_session = (String) request.getSession().getAttribute("checkcode_session");
		if (!checkcode_session.equals(ckcode)) {
			request.setAttribute("ckcode_msg", "验证码错误！");
			request.getRequestDispatcher("/index.jsp").forward(request,response);
			return;
		}
		
		

		userDao ud = new userDao();
		User u;
		try {
			u = ud.findUser(user);
			if (u != null) {
				if ("超级管理员".equals(u.getPermission())) {
					request.setAttribute("uID", u.getUserID());
					request.getRequestDispatcher("/admin/login/superHome.jsp").forward(request, response); // 页面跳转先考虑是否经过servlet层处理
				}else if ("普通管理员".equals(u.getPermission())) {
					request.setAttribute("uID", u.getUserID());
					request.getRequestDispatcher("/admin/login/home.jsp").forward(request, response); // 页面跳转先考虑是否经过servlet层处理
				}
			} else {
				request.setAttribute("login_msg", "用户名密码错误！");
				request.getRequestDispatcher("/index.jsp").forward(request,response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
