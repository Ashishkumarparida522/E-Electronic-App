package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Model.ProductBean;

public class AddProduct {
	
	
	public int insertProduct( ProductBean pbean)
	{
		int count=0;
		try
		{
			Connection con = DbConenction.getCon();
			PreparedStatement st = con.prepareStatement("insert into  product values (?,?,?,?,?)");
			st.setString(1,pbean.getpCode());
			st.setString(2, pbean.getpName());
			st.setString(3, pbean.getpCompnay());
			st.setString(4, pbean.getpPrice());
			st.setString(5, pbean.getpQuantity());
			count  = st.executeUpdate();
		}
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return count;
		
		
	}

}
