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


@WebServlet("/delacc")
public class DeleteAccServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		ProfileDAO profDAO = new ProfileDAO();
		AccountDAO accDAO= new AccountDAO();
		try {
			profDAO.delProf(id);
			accDAO.del(id);
			resp.sendRedirect("showacc");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
