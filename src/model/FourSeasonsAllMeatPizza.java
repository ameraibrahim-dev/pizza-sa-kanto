package model;

public class FourSeasonsAllMeatPizza implements PizzaInterface {

	private String name;
	private String category;
	private String description;
	private String imageSource;
	
	FourSeasonsAllMeatPizza(){
		this.name = "Four Seasons All Meat";
		this.category = "Pizza";
		this.description = "4 of our greatest hits in 1 pizza: New York's Finest, Manhattan Meatlovers, Hawaiian, and Pepperoni";
		this.imageSource = "images/four-seasons.png";
	}
	
	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getImageSource() {
		return imageSource;
	}

	public void setImageSource(String imageSource) {
		this.imageSource = imageSource;
	}
}
