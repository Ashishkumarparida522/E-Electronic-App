package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdateCpDao {
	
	
	public int  UpdateCProduct(String pCode,int requireqQuantity)
	{
		int count=0;
		
		try
		{
			Connection con = DbConenction.getCon();
			PreparedStatement stm = con.prepareStatement("select * from product where pcode=?");
			stm.setString(1, pCode);
			ResultSet rs = stm.executeQuery();
			int currentQuantity=0;
			if(rs.next())
			{
				currentQuantity=Integer.parseInt(rs.getString(5));
				
			}
			
			if(currentQuantity>=requireqQuantity)
			{
				
				PreparedStatement stm2 = con.prepareStatement("update product set pqty=? where pcode=?");
				stm2.setString(1, String.valueOf(currentQuantity - requireqQuantity));
				stm2.setString(2, pCode);
				count = stm2.executeUpdate();	
			}
			else
			{
				System.out.println("insufficient stuck");
			}
			
			
			
		}
		catch (Exception e) {
			e.printStackTrace();

		}
		return count;
		
		
	}

}
