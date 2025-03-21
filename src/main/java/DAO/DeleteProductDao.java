package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Model.ProductBean;

public class DeleteProductDao {
	
	
	
	public int  deleteProduct(ProductBean pbean)
	{
		int count=0;
		try
		{
			Connection con = DbConenction.getCon();
			PreparedStatement stm = con.prepareStatement("delete from product where pcode=?");
			stm.setString(1, pbean.getpCode());
			 count = stm.executeUpdate();
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		return count;
		
		
	}

}
