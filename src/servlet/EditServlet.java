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
import model.Profile;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
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
			forward(req, resp);
		}
	}

	private void forward(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		AccountDAO accDAO = new AccountDAO();
		ProfileDAO profDAO = new ProfileDAO();

		try {
			Account acc = accDAO.getAcc(id);
			Profile prof = profDAO.getProfile(id);
			req.setAttribute("acc", acc);
			req.setAttribute("prof", prof);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher rd = req.getRequestDispatcher("edit.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Account acc = (Account) session.getAttribute("userAcc");
		if (acc.getStatus() != 1) {
			resp.sendRedirect("welcome.jsp");
		} else {
			redirect(req, resp);
		}
	}

	private void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		int role = Integer.parseInt(req.getParameter("role"));
		int stat = 1;

		AccountDAO accDAO = new AccountDAO();
		ProfileDAO profDAO = new ProfileDAO();
		if (name.equals("") && email.equals("") && address.equals("")) {
			stat = 0;
		}

		if (!username.equals("") && !password.equals("")) {
			try {
				accDAO.edit(id, username, password, role);
				profDAO.edit(id, stat, name, email, address);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		resp.sendRedirect("showacc");
	}
}
