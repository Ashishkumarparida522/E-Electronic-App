package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.CustomerBean;

public class CustomerLoginDao {
	
	
	
	public CustomerBean cLogin(String name ,String Password)
	{
		CustomerBean cbean=null;
		
		try {
			Connection con = DbConenction.getCon();
			PreparedStatement stm = con.prepareStatement("select * from customer where name=? and password=?");
			stm.setString(1, name);
			stm.setString(2, Password);
			ResultSet rs = stm.executeQuery();
			if(rs.next())
			{
				cbean=new CustomerBean();
				cbean.setName(rs.getString(1));
				cbean.setPassword(rs.getString(2));
				cbean.setFname(rs.getString(3));
				cbean.setLname(rs.getString(4));
				cbean.setAddress(rs.getString(5));
				cbean.setMid(rs.getString(6));
				cbean.setPhone(rs.getString(7));
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		return cbean;
		
	}

}
