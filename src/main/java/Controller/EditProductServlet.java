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

import DAO.GetProductById;
import Model.ProductBean;

@WebServlet("/edit")
public class EditProductServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		if(session==null)
		{
			req.setAttribute("msg", "session Expired");
			req.getRequestDispatcher("AdminLogin.html").forward(req, resp);
			
		}
		else
		{
			String pcode = req.getParameter("pCode");
			GetProductById gpi=new GetProductById();
			ProductBean pbean = gpi.getProductById(pcode);
			req.setAttribute("pbean", pbean);
			RequestDispatcher rd = req.getRequestDispatcher("EditProduct.jsp");
			rd.forward(req, resp);
		
			
		}
	}
}
