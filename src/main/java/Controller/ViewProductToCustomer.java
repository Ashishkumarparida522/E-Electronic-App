package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ViewProductDao;
import Model.CustomerBean;
import Model.ProductBean;


@SuppressWarnings("serial")
@WebServlet("/viewp2")
public class ViewProductToCustomer extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
//		CustomerBean cbean = new CustomerBean();
		HttpSession session = req.getSession(false);
		if(session==null)
		{
			req.setAttribute("msg","session has expired");
			RequestDispatcher rd = req.getRequestDispatcher("CustomerLogin.html");
			rd.forward(req, resp);
		}
		else
		{
//			session.setAttribute("cname", cbean);
			ArrayList<ProductBean> vpd=new ViewProductDao().viewProduct();
			req.setAttribute("plist", vpd);
			RequestDispatcher rd = req.getRequestDispatcher("CustomerViewProduct.jsp");
			rd.forward(req, resp);
			
		}
		
	
		
	}
	
	
	


	
	
}
