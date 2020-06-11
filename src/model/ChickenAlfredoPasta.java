package model;

public class ChickenAlfredoPasta extends Product implements PastaInterface {

	private String name;
	private String category;
	private String description;
	private String imageSource;
	
	ChickenAlfredoPasta(){
		this.name = "Chicken Alfredo";
		this.category = "Pasta";
		this.description = "Creamy pasta with chicken strips, olives, and basil chiffonade";
		this.imageSource = "images/chicken-alfredo.png"; 
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
