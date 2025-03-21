package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.ProductBean;

public class GetProductById {
	
	
	public ProductBean getProductById(String pCode)
	{
		ProductBean pbean=null;
		try
		{
			
			Connection con = DbConenction.getCon();
			PreparedStatement st = con.prepareStatement("select * from product where pCode=?");
			st.setString(1, pCode);
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				pbean =new ProductBean();
				pbean.setpCode(rs.getString(1));
				pbean.setpName(rs.getString(2));
				pbean.setpCompnay(rs.getString(3));
				pbean.setpPrice(rs.getString(4));
				pbean.setpQuantity(rs.getString(5));
				
			}
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return pbean;
		
	}

}
