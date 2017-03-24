package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.userDao;
import domain.User;

public class updatePwdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");
		userDao userDao = new userDao();
		try {
			User finduser = userDao.findPwdUser(userID,password);
			User user = userDao.findEditUser(userID);
			request.setAttribute("user", user);
			if ("".equals(request.getParameter("username"))) {
				request.setAttribute("msg_username","用户名不能为空！");
				request.getRequestDispatcher("/admin/user/editpwd.jsp").forward(request, response);
				return;
			} else if (request.getParameter("username").length()<2||request.getParameter("username").length()>8) { // 用户名由2-8位字母组成
				request.setAttribute("msg_username", "用户名由3-8位字符组成！");
				request.getRequestDispatcher("/admin/user/editpwd.jsp").forward(request, response);
				return;
			}
			
			if ("".equals(request.getParameter("password"))) {
				request.setAttribute("msg_pwd", "请填写原密码！");
				request.getRequestDispatcher("/admin/user/editpwd.jsp").forward(request, response);
				return;
			}
			
			if ("".equals(request.getParameter("newpassword"))) {
				request.setAttribute("msg_npwd", "请填写新密码！");
				request.getRequestDispatcher("/admin/user/editpwd.jsp").forward(request, response);
				return;
			}
			
			if ("".equals(request.getParameter("repassword"))) {
				request.setAttribute("msg_repwd", "请确认密码！");
				request.getRequestDispatcher("/admin/user/editpwd.jsp").forward(request, response);
				return;
			}else if (!request.getParameter("newpassword").equals(request.getParameter("repassword"))) {
				request.setAttribute("msg_repwd", "密码不一致！");
				request.getRequestDispatcher("/admin/user/editpwd.jsp").forward(request, response);
				return;
			}
			
			if (finduser==null) {
				request.setAttribute("msg_pwd","密码不正确！");
				request.getRequestDispatcher("/admin/user/editpwd.jsp").forward(request, response);
				return;
			}
			
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("newpassword"));
			userDao.updateUser(user);
			response.getWriter().write("修改成功！2秒后跳回主页");
			response.setHeader("refresh", "2;url=" + request.getContextPath()+ "/admin/login/welcome.jsp");
			
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
