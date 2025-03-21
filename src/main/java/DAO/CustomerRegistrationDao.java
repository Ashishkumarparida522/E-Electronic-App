package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Model.CustomerBean;

public class CustomerRegistrationDao {
	
	public int regCustomer(CustomerBean cb)
	{
		
		int count =0;
		try
		{
			
			Connection con = DbConenction.getCon();
		   PreparedStatement stm=con.prepareStatement("insert into customer values(?,?,?,?,?,?,?)");
			stm.setString(1, cb.getName());
			stm.setString(2, cb.getPassword());
			stm.setString(3, cb.getFname());
			stm.setString(4, cb.getLname());
			stm.setString(5, cb.getAddress());
			stm.setString(6, cb.getMid());
			stm.setString(7, cb.getPhone());
			count = stm.executeUpdate();
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return count;
	}
	
	

}
