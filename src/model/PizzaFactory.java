package model;

public class PizzaFactory extends AbstractFactory {
	
	public PizzaInterface getPizza(String product) {
		PizzaInterface pizza = null;
		
		switch(product.toUpperCase()) {
		case "HAWAIIAN":
			pizza = new HawaiianPizza();
			break;
		case "ROASTEDGARLICSHRIMP":
			pizza = new RoastedGarlicShrimpPizza();
			break;
		case "FOURSEASONS":
			pizza = new FourSeasonsAllMeatPizza();
			break;
		}	
		
		return pizza;
	}

	@Override
	public PastaInterface getPasta(String product) {
		// TODO Auto-generated method stub
		return null;
	}
}
