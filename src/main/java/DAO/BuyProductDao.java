package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.ProductBean;

public class BuyProductDao {
	

	
	 public ProductBean getDeatils(String Pcode)
	
	{
		  ProductBean pbean=null;
		try
		{
			Connection con = DbConenction.getCon();
			PreparedStatement stm = con.prepareStatement("select * from product where Pcode=?");
			stm.setString(1, Pcode);
			ResultSet rs = stm.executeQuery();
			if(rs.next())
			{
				pbean=new ProductBean();
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
