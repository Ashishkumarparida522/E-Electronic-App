package Model;

import java.io.Serializable;

public class ProductBean implements Serializable{
	
	
	private String pCode;
	private String pName;
	private String pCompnay;
	private String pPrice;
	private String pQuantity;
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpCompnay() {
		return pCompnay;
	}
	public void setpCompnay(String pCompnay) {
		this.pCompnay = pCompnay;
	}
	public String getpPrice() {
		return pPrice;
	}
	public void setpPrice(String pPrice) {
		this.pPrice = pPrice;
	}
	public String getpQuantity() {
		return pQuantity;
	}
	public void setpQuantity(String pQuantity) {
		this.pQuantity = pQuantity;
	}
	
	public ProductBean()
	{
		
	}
	

}
