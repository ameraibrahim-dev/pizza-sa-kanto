package model;

public class CustomerAddress {

	private String houseNumber;
	private String street;
	private String barangaySubdivision;
	private String city;
	private String province;
	private String zipCode;
	
	public CustomerAddress(String houseNumber, String street, String barangaySubdivision, String city, String province, String zipCode){
		this.houseNumber = houseNumber;
		this.street = street;
		this.barangaySubdivision = barangaySubdivision;
		this.city = city;
		this.province = province;
		this.zipCode = zipCode;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getBarangaySubdivision() {
		return barangaySubdivision;
	}

	public void setBarangaySubdivision(String barangaySubdivision) {
		this.barangaySubdivision = barangaySubdivision;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
}
