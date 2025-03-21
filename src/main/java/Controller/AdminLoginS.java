package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AdminDao;
import Model.AdminBean;
@WebServlet("/login")
public class AdminLoginS extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		AdminDao admindao=new AdminDao();
		AdminBean abean = admindao.adminLogin(req.getParameter("name"),req.getParameter("pass"));
		
		if(abean==null)
		{
			
			RequestDispatcher rd = req.getRequestDispatcher("AdminLogin.html");
			rd.forward(req, resp);
				
			}
		
		else
		{
			HttpSession session = req.getSession();
			session.setAttribute("aname", abean);
			RequestDispatcher rd = req.getRequestDispatcher("AdminHome.jsp");
			rd.forward(req, resp);
		}
	
		
		
	}

}
