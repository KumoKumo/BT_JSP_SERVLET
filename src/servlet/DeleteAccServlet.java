package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import dao.ProfileDAO;
import model.Account;

@WebServlet("/delacc")
public class DeleteAccServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Account acc = (Account) session.getAttribute("userAcc");
		if (acc.getStatus() != 1) {
			resp.sendRedirect("welcome.jsp");
		} else {
			doDel(req, resp);
		}
	}

	private void doDel(HttpServletRequest req, HttpServletResponse resp) {
		int id = Integer.parseInt(req.getParameter("id"));
		ProfileDAO profDAO = new ProfileDAO();
		AccountDAO accDAO = new AccountDAO();
		try {
			profDAO.delProf(id);
			accDAO.del(id);
			resp.sendRedirect("showacc");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
