package model;

public class PastaFactory extends AbstractFactory{
	
	public PastaInterface getPasta(String product) {
		PastaInterface pasta = null;
		
		switch(product.toUpperCase()) {
		case "CHICKENALFREDO":
			pasta = new ChickenAlfredoPasta();
			break;
		case "SPAGHETTIMEATBALLS":
			pasta = new SpaghettiAndMeatballsPasta();
			break;
		case "SHRIMPALFREDO":
			pasta = new ShrimpAlfredoPasta();
			break;
		}
		
		return pasta;
	}

	@Override
	public PizzaInterface getPizza(String product) {
		// TODO Auto-generated method stub
		return null;
	}
}
