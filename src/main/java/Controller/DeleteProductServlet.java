package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DeleteProductDao;
import Model.AdminBean;
import Model.ProductBean;
@WebServlet("/delete")
public class DeleteProductServlet  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	

		HttpSession session = req.getSession(false);
		if(session==null)
		{
			req.setAttribute("msg", "session expired");
			req.getRequestDispatcher("AdminLogin.html").forward(req, resp);
		}
		else
		{
		   AdminBean abean=new AdminBean();
		   abean.setFname("ashish");
			ProductBean pbean=new ProductBean();
			pbean.setpCode(req.getParameter("pCode"));
			DeleteProductDao dps=new DeleteProductDao();
			int count = dps.deleteProduct(pbean);
			if (count>0)
			{
				session.setAttribute("aname", abean);
				req.setAttribute("msg", "product deleted");
				RequestDispatcher rd = req.getRequestDispatcher("DeleteProduct.jsp");
				rd.forward(req, resp);
				
			}
		
		}
		
		
	}

}
