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

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		int stat = 1;

		AccountDAO accDAO = new AccountDAO();
		ProfileDAO profDAO = new ProfileDAO();
		if (name.equals("") && email.equals("") && address.equals("")) {
			stat = 0;
		}

		if (!username.equals("") && !password.equals("")) {
			try {
				accDAO.edit(id, username, password);
				profDAO.edit(id, stat, name, email, address);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		resp.sendRedirect("showacc");
	}
}
