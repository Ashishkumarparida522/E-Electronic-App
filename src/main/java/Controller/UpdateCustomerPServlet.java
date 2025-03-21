package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.GetProductById;
import DAO.UpdateCpDao;
import Model.CustomerBean;
@WebServlet("/updateProduct")
public class UpdateCustomerPServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		if(session==null)
		{
			req.setAttribute("msg", "session has expired");
			RequestDispatcher rd = req.getRequestDispatcher("CustomerLogin.html");
			rd.forward(req, resp);
			
		}
		else
		{
			CustomerBean customerBean = new CustomerBean();
			GetProductById gpid=new GetProductById();
			String pcode = req.getParameter("pCode");
			int rqty = Integer.parseInt(req.getParameter("requiredQuantity"));								
			 int count=new UpdateCpDao().UpdateCProduct(pcode, rqty);
			 if (count>0) {
		            req.setAttribute("customerName", ((CustomerBean) req.getSession().getAttribute("name")).getFname());
		            req.setAttribute("totalCharge", rqty*Integer.parseInt(new GetProductById().getProductById(pcode).getpPrice()));

		            req.getRequestDispatcher("orderConfirmed.jsp").forward(req, resp);
		        } else {
		            resp.getWriter().write("Error processing order!");
		        }
			 
			 
			
		}
		
		
		
	} 
	
}
