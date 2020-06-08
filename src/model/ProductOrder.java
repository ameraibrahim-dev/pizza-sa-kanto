package model;

public class ProductOrder implements Facade{

	private String productID;
	private String name;
	private String category;
	private String description;
	private String imageSource;
	private String size;
	private int quantity;
	private double totalPrice;
	
	public ProductOrder(String name, String category, String description, String imageSource, String size, int quantity){
		this.name = name;
		this.category = category;
		this.description = description;
		this.imageSource = imageSource;
		this.size = size;
		this.quantity = quantity;
	}
	

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getImageSource() {
		return imageSource;
	}

	public void setImageSource(String imageSource) {
		this.imageSource = imageSource;
	}


	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public void createProductID() {
		String[] names = name.split(" ");
		String ID = "";
		
		for(String name : names) {
			ID += name;
		}
		
		this.productID = ID + size;
	}

	public void computeTotalPrice() {
		switch(name.toUpperCase()) {
		case "HAWAIIAN":
			if(size.equals("9")) {
				this.totalPrice =  315 * quantity;
			}else if(size.equals("12")) {
				this.totalPrice =  525 * quantity;
			}else if(size.equals("15")) {
					this.totalPrice =  735 * quantity;
			}else {
				this.totalPrice =  945 * quantity;
			}
			break;
		case "ROASTED GARLIC AND SHRIMP":
			if(size.equals("9")) {
				this.totalPrice =  420 * quantity;
			}else if(size.equals("12")) {
				this.totalPrice =  630 * quantity;
			}else if(size.equals("15")) {
					this.totalPrice =  840 * quantity;
			}else {
				this.totalPrice =  1050 * quantity;
			}
			break;
		case "FOUR SEASONS ALL MEAT":
			if(size.equals("9")) {
				this.totalPrice =  525 * quantity;
			}else if(size.equals("12")) {
				this.totalPrice =  735 * quantity;
			}else if(size.equals("15")) {
					this.totalPrice =  945 * quantity;
			}else {
				this.totalPrice =  1155 * quantity;
			}
			break;
		case "CHICKEN ALFREDO":
			if(size.equals("Regular")) {
				this.totalPrice =  210 * quantity;
			}else {
				this.totalPrice =  380 * quantity;
			}
			break;
		case "SPAGHETTI AND MEATBALLS":
			if(size.equals("Regular")) {
				this.totalPrice =  210* quantity;
			}else {
				this.totalPrice =  380 * quantity;
			}
			break;
		case "SHRIMP ALFREDO":
			if(size.equals("Regular")) {
				this.totalPrice =  245 * quantity;
			}else {
				this.totalPrice =  420 * quantity;
			}
			break;
		}
		
	}
	
	//Facade Design Pattern
	@Override
	public void process() {
		createProductID();
		 computeTotalPrice(); 
	}
}
