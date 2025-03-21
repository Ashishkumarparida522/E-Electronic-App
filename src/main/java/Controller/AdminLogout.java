package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/alogout")
public class AdminLogout extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	HttpSession session = req.getSession(false);
	if(session==null)
		{
		req.setAttribute("msg","session has expired!!!!!!!");
		RequestDispatcher rd = req.getRequestDispatcher("AdminLogin.html");
		rd.forward(req, resp);
			
		}
	else
	{
		RequestDispatcher rd = req.getRequestDispatcher("AdminLogout.jsp");
		rd.forward(req, resp);
	}
		
		
	}
}
