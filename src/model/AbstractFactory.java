package model;


public abstract class AbstractFactory {
	
	public abstract PizzaInterface getPizza(String product);
	public abstract PastaInterface getPasta(String product);

}
