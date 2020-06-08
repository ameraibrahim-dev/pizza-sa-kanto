package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Cart implements Facade{
	
	private ArrayList<ProductOrder> cartProducts = new ArrayList<ProductOrder>();
	
	private boolean isCardValid = false;
	
	private float grossPay = 0.0f;
	private float VAT = 0.0f;
	private float netPay = 0.0f;	
	
	private static float taxRate = 0.12f;

	
	public ArrayList<ProductOrder> getCartProducts() {
		return cartProducts;
	}

	public void setCartProducts(ArrayList<ProductOrder> cartProducts) {
		this.cartProducts = cartProducts; 
	}
	
	
	public boolean isCardValid() {
		return isCardValid;
	}

	public void setCardValid(boolean isCardValid) {
		this.isCardValid = isCardValid;
	}

	
	public float getGrossPay() {
		return grossPay;
	}

	public void setGrossPay(float grossPay) {
		this.grossPay = grossPay;
	}

	
	public float getVAT() {
		return VAT;
	}

	public void setVAT(float VAT) {
		this.VAT = VAT;
	}

	
	public float getNetPay() {
		return netPay;
	}

	public void setNetPay(float netPay) {
		this.netPay = netPay;
	}

	public void addToCart(ProductOrder product) {
		boolean itemInCart = false;
		
		//Check if product is already in cart
		for (int index = 0; index < cartProducts.size(); index ++) {
			if(cartProducts.get(index).getProductID().equals(product.getProductID())) {
				System.out.println("product already in cart");
				itemInCart = true;
			}
		}
		
		//if product already in cart, update quantity
		if(itemInCart) {
			for (int index = 0; index < cartProducts.size(); index ++) {
				if(cartProducts.get(index).getProductID().equals(product.getProductID())) {
					System.out.println("Update product quantity");
					cartProducts.get(index).setQuantity((cartProducts.get(index).getQuantity() + product.getQuantity()));
					cartProducts.get(index).computeTotalPrice();
				}
			}
		}else { //else add product to cart
			System.out.println("new product added");
			cartProducts.add(product);
		}
	}
	
	public void removeFromCart(String productID) {
		System.out.println("removeFromCart() is called");
		for (int index = 0; index < cartProducts.size(); index ++) {
			if(cartProducts.get(index).getProductID().equals(productID)) {
				System.out.println("Delete item from Cart");
				cartProducts.remove(cartProducts.get(index));
			}
		}
	}

	public int cartTotal() {
		return cartProducts.size();
	}
	
	public String getProductName(String productID) {
		String productName = null;
		Iterator<ProductOrder> productsIterator = cartProducts.iterator();
		
		while (productsIterator.hasNext()) {
			ProductOrder product = (ProductOrder) productsIterator.next();
			if (product.getProductID().equals(productID)) {
				productName = product.getName();
			}
		}
		return productName;
	}
	
	public void clearCart() {
		cartProducts.clear();
	}

	public void computeGrossPay() {
		float sum = 0.0f;
		
		Iterator<ProductOrder> productsIterator = cartProducts.iterator();
		
		while (productsIterator.hasNext()) {
			ProductOrder product = (ProductOrder) productsIterator.next();
			sum += product.getTotalPrice();
		}
		
		this.grossPay = sum;
	}


	public void computeVAT() {
		this.VAT = this.grossPay*taxRate;
	}


	public void computeNetPay() {
		this.netPay = grossPay - VAT;
	}
	
	//Facade Design Pattern
	@Override
	public void process() {
		computeGrossPay();
		computeVAT();
		computeNetPay();
	}
}
