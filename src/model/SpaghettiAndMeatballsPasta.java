package model;

public class SpaghettiAndMeatballsPasta implements PastaInterface {

	private String name;
	private String category;
	private String description;
	private String imageSource;
	
	SpaghettiAndMeatballsPasta(){
		this.name = "Spaghetti and Meatballs";
		this.category = "Pasta";
		this.description = "Classic spaghetti with giant meatballs, baked and simmered in chunky red wine tomato sauce";
		this.imageSource = "images/spaghetti-meatballs.png";
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
