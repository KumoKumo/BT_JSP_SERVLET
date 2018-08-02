package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import model.Account;

@WebServlet("/checkLog")
public class checkLogInServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AccountDAO accDAO = new AccountDAO();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Account acc = new Account();
		try {
			if (accDAO.check(username, password)!=0) {
				acc = accDAO.getAcc(accDAO.check(username, password));
				HttpSession session = req.getSession();
				session.setAttribute("userAcc", acc);
				resp.sendRedirect("welcome.jsp");
			} else {
				resp.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
