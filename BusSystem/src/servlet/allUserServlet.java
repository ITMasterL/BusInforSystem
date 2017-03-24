package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userDao;
import domain.User;

public class allUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		userDao userDao = new userDao();
		try {
			List<User> allUser = userDao.findAllUser();
			request.setAttribute("user",allUser);
			request.getRequestDispatcher("/admin/user/list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
