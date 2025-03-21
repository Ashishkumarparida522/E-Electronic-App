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
import Model.AdminBean;
import Model.ProductBean;
@WebServlet("/viewp")
public class ViewProductServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ViewProductDao vpd=new ViewProductDao();
		ArrayList<ProductBean> viewProduct = vpd.viewProduct();
		HttpSession session = req.getSession(false);
		if(session==null)
		{
			req.setAttribute("msg", "session has expired");
			RequestDispatcher rd = req.getRequestDispatcher("AdminLogin.html");
			rd.forward(req, resp);
		}
		
		
		
		if(viewProduct ==null)
		{
		viewProduct=new ArrayList<>();
		}
		else
		{
			req.setAttribute("product", viewProduct);
			RequestDispatcher rd = req.getRequestDispatcher("/ViewProduct.jsp");
			rd.forward(req, resp);
//			AdminBean abean=new AdminBean();
//			session.setAttribute("aname", abean);
			
			
		}
	
		
	}

}
