package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDAO;
import dao.ProfileDAO;

@WebServlet("/add")
public class AddAccServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		AccountDAO accDAO = new AccountDAO();
		ProfileDAO profDAO = new ProfileDAO();

		if (!username.equals("") && !password.equals("")) {
			try {
				accDAO.add(username, password);
				profDAO.add();;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		RequestDispatcher rd = req.getRequestDispatcher("showacc");
		rd.forward(req, resp);
	}
}
