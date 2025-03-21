package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Model.ProductBean;

public class UpdateProductDao {
	
	
	
	public int update(ProductBean pb)
	{
		int count=0;
		
		try
		{
			Connection con = DbConenction.getCon();
			PreparedStatement st = con.prepareStatement("update product set pprice=? ,pqty=? where pcode=? ");
			st.setString(1,pb.getpPrice());
			st.setString(2, pb.getpQuantity());
			st.setString(3, pb.getpCode());
			
			count = st.executeUpdate();
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return count;
		
	}

}
