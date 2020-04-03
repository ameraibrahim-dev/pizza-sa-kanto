package model;

public class RoastedGarlicShrimpPizza implements PizzaInterface {

	private String name;
	private String category;
	private String description;
	private String imageSource;
	
	RoastedGarlicShrimpPizza(){
		this.name = "Roasted Garlic and Shrimp";
		this.category = "Pizza";
		this.description = "Juicy shrimps, onions, and garlic on a bed of white wine sauce";
		this.imageSource = "images/garlic-shrimp.png";
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
