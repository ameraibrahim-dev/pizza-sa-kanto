package model;

public class Product implements Cloneable{
	
	String productID;
	String ProductName;
	String ProductCategory;
	String ProductDescription;
	String ProductImageSource;
	
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getProductCategory() {
		return ProductCategory;
	}
	public void setProductCategory(String productCategory) {
		ProductCategory = productCategory;
	}
	public String getProductDescription() {
		return ProductDescription;
	}
	public void setProductDescription(String productDescription) {
		ProductDescription = productDescription;
	}
	public String getProductImageSource() {
		return ProductImageSource;
	}
	public void setProductImageSource(String productImageSource) {
		ProductImageSource = productImageSource;
	}
	
	public Object clone() {
		Object clone = null;
		
		try {
			clone = super.clone();
		} catch (CloneNotSupportedException cnse){
		}
		
		return clone;
	}
}
