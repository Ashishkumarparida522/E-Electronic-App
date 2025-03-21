package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CustomerRegistrationDao;
import Model.CustomerBean;




@WebServlet("/register")
public class CustomerRegservlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			CustomerBean cbean=new CustomerBean();
			cbean.setName(req.getParameter("name"));
			cbean.setPassword(req.getParameter("password"));
			cbean.setFname(req.getParameter("fname"));
			cbean.setLname(req.getParameter("lname"));
			cbean.setAddress(req.getParameter("address"));
			cbean.setMid(req.getParameter("mid"));
			cbean.setPhone(req.getParameter("phone"));
			
			
			CustomerRegistrationDao crd=new CustomerRegistrationDao();
			   int count = crd.regCustomer(cbean);
			   
			   
			   if(count >0)
			   {
				   
				   RequestDispatcher rd = req.getRequestDispatcher("CustomerLogin.html");
				   rd.forward(req, resp);
				   
			   }
			   else
			   {
				   
				   PrintWriter out = resp.getWriter();
				   out.println("not registered, try agin!!!!!!!!!!!");
				   RequestDispatcher rd = req.getRequestDispatcher("CustomerReg.html");
				   rd.include(req, resp);
				   
			   }
		
	}

}
