package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import dao.ProfileDAO;
import model.Account;

@WebServlet("/add")
public class AddAccServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Account acc = (Account) session.getAttribute("userAcc");
		if (acc.getStatus() != 1) {
			resp.sendRedirect("welcome.jsp");
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("add_acc.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Account acc = (Account) session.getAttribute("userAcc");
		if (acc.getStatus() != 1) {
			resp.sendRedirect("welcome.jsp");
		} else {
			doAdd(req, resp);
		}
	}

	private void doAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username").trim();
		String password = req.getParameter("password").trim();
		int role = Integer.parseInt(req.getParameter("role"));

		AccountDAO accDAO = new AccountDAO();
		ProfileDAO profDAO = new ProfileDAO();

		if (!username.equals("") && !password.equals("")) {
			try {
				accDAO.add(username, password, role);
				profDAO.add();
				;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		resp.sendRedirect("showacc");
	}
}
