package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.AdminBean;

public class AdminDao {
	
	public AdminBean adminLogin(String uname,String password)
	{
		AdminBean abean=null;
		
		
		try
		
		{
			Connection con = DbConenction.getCon();
			
			PreparedStatement st = con.prepareStatement("select * from admin where name =? and password=?");
			st.setString(1, uname);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			
			if(rs.next())
			{
				abean =new AdminBean();
				abean.setName(rs.getString(1));
				abean.setPwd(rs.getString(2));
				abean.setFname(rs.getString(3));
				abean.setLname(rs.getString(4));
				abean.setAddress(rs.getString(5));
				abean.setMid(rs.getString(6));
				abean.setPhone(rs.getString(7));	
			}
		}
		
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return abean ;
	}

}
