package model;

public class ShrimpAlfredoPasta implements PastaInterface {

	private String name;
	private String category;
	private String description;
	private String imageSource;
	
	ShrimpAlfredoPasta(){
		this.name = "Shrimp Alfredo";
		this.category = "Pasta";
		this.description = "Creamy pasta with shrimps, olives, and basil chiffonade";
		this.imageSource = "images/shrimp-alfredo.png";
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
