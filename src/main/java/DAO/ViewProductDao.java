package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Model.ProductBean;

public class ViewProductDao {

    public ArrayList<ProductBean> viewProduct() {
        ArrayList<ProductBean> productList = new ArrayList<>();
        
        try {
            Connection conn = DbConenction.getCon(); 
            String sql = "Select * from product"; 
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
        
            while (rs.next()) {
                ProductBean product = new ProductBean();
                product.setpCode(rs.getString(1)); 
                product.setpName(rs.getString(2));
                product.setpCompnay(rs.getString(3));
                product.setpPrice(rs.getString(4));
                product.setpQuantity(rs.getString(5));
                
                productList.add(product);
            }
            
            rs.close();
            pstmt.close();
            conn.close();
            
            System.out.println("Number of products fetched: " + productList.size());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList.isEmpty() ? null : productList;
    }
}
