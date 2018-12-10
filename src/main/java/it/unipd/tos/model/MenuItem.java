package it.unipd.tos.model;

public class MenuItem {

	public enum itemType {Pizze,Primi};
	private itemType type;
	String name;
	private double price;
	
	public MenuItem(itemType type, String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public itemType type() {
		return type;
	}
	public String name() {
		return name;
	}
	
	public double price() {
		return price;
	}

}
