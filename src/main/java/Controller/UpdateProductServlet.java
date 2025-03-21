package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UpdateProductDao;
import Model.ProductBean;
@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session = req.getSession(false);
		if(session==null)
		{
			req.setAttribute("msg", "session expired");
			req.getRequestDispatcher("AdminLogin.html").forward(req, resp);
		}
		
		else
		{
			String pCode=req.getParameter("pcode");
			
		
		String pprice = req.getParameter("pprice");
		String pqty = req.getParameter("pqty");
		ProductBean pb=new ProductBean();
		
		pb.setpPrice(pprice);
		pb.setpQuantity(pqty);
		pb.setpCode(pCode);
		UpdateProductDao upd=new UpdateProductDao();
		int count = upd.update(pb);
		if(count>0)
		{
			req.setAttribute("msg", "products details updated");
			RequestDispatcher rd = req.getRequestDispatcher("UpdateProduct.jsp");
			
			rd.forward(req, resp);
			
		}
		
		}
		
		
		
	}

}
