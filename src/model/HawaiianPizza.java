package model;

public class HawaiianPizza implements PizzaInterface {

	private String name;
	private String category;
	private String description;
	private String imageSource;
	
	HawaiianPizza(){
		this.name = "HAWAIIAN";
		this.category = "Pizza";
		this.description = "A local favorite with sweet pineapples, and savory ham and crumbled bacon";
		this.imageSource = "images/hawaiian.png";
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
