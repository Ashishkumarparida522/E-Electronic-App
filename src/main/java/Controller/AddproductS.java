package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AddProduct;
import Model.AdminBean;
import Model.ProductBean;
@SuppressWarnings("serial")
@WebServlet("/addp")
public class AddproductS  extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		
		ProductBean pb=new ProductBean();
		pb.setpCode(req.getParameter("pcode"));
		pb.setpName(req.getParameter("pname"));
		pb.setpCompnay(req.getParameter("pcomp"));
		pb.setpPrice(req.getParameter("pprice"));
		pb.setpQuantity(req.getParameter("pqty"));
		
		
		AdminBean abean=new AdminBean();
		abean.setFname("ashish");
		
		AddProduct ap=new AddProduct();
		int count = ap.insertProduct(pb);
		if(count>0)
		{
			HttpSession session = req.getSession();
			session.setAttribute("name", abean);
			
			req.setAttribute("msg","data inserted successfully");
			RequestDispatcher rd = req.getRequestDispatcher("AddProduct.jsp");
			rd.forward(req, resp);
		}
		
		
		
		
	}
	
	

}
