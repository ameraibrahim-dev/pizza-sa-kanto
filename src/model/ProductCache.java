package model;

import java.util.*;

public class ProductCache {
	
	private static  Hashtable<String, Product> productMap = new Hashtable<String, Product>();
	
	public static Product getProduct(String productID) {
		Product cachedProduct = productMap.get(productID);
		return (Product) cachedProduct.clone();
	}
	
	public static void loadCache() {
		ChickenAlfredoPasta chickenAlfredo = new ChickenAlfredoPasta();
		chickenAlfredo.setProductID("CHICKENALFREDO");
		productMap.put(chickenAlfredo.getProductID(), chickenAlfredo);

		SpaghettiAndMeatballsPasta spaghettiMeatballs = new SpaghettiAndMeatballsPasta();
		spaghettiMeatballs.setProductID("SPAGHETTIMEATBALLS");
		productMap.put(spaghettiMeatballs.getProductID(), spaghettiMeatballs);
		
		ShrimpAlfredoPasta shrimpAlfredo = new ShrimpAlfredoPasta();
		shrimpAlfredo.setProductID("SHRIMPALFREDO");
		productMap.put(shrimpAlfredo.getProductID(), shrimpAlfredo);
		
	}
}
	
	

