package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CustomerLoginDao;
import Model.CustomerBean;

@SuppressWarnings("serial")
@WebServlet("/clogin")
public class CustomerLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CustomerBean cbean = new CustomerLoginDao ().cLogin(req.getParameter("name"), req.getParameter("password"));
		if(cbean==null)
		{
			req.setAttribute("msg","invalid login credential!!!!!!");
			RequestDispatcher rd = req.getRequestDispatcher("CustomerHome.jsp");
			rd.forward(req, resp);
			
		}
		
		else
		{
			HttpSession session = req.getSession();
			session.setAttribute("name", cbean);
			RequestDispatcher rd = req.getRequestDispatcher("CustomerHome.jsp");
			rd.forward(req, resp);
			
		}
		
	}

	
	
	
}
