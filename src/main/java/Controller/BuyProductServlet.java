package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BuyProductDao;
import Model.ProductBean;

@WebServlet("/buy")
public class BuyProductServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	HttpSession session = req.getSession(false);
	if(session==null)
	{
		req.setAttribute("msg", "session has expired!!!!!!!!!");
		req.getRequestDispatcher("CustomerLogin.html").forward(req, resp);
	}
	else
	{
		String pcode = req.getParameter("pCode");
		BuyProductDao bpd=new BuyProductDao();
		ProductBean pbean = bpd.getDeatils(pcode);
		req.setAttribute("pcode", pbean);
		req.getRequestDispatcher("BuyProduct.jsp").forward(req, resp);
		
	}
		
		
	
		
		
	}

}
