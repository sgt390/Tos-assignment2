package it.unipd.tos.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import it.unipd.tos.business.Bill;
import it.unipd.tos.business.exception.RestaurantBillException;

public class MenuItemTest {

	/*
	 * issue #8 . ordine semplice (senza offerte)
	 */
	@Test
	public void sum_smallOrderPrice() {
		Bill bill = new Bill();

		ArrayList<MenuItem> order = new ArrayList<MenuItem>();

		order.add(new MenuItem(MenuItem.itemType.Pizze, "Verdure", 6.50));
		order.add(new MenuItem(MenuItem.itemType.Pizze, "Tonno e Cipolle", 6.00));
		order.add(new MenuItem(MenuItem.itemType.Pizze, "Ananas", 1.50));
		order.add(new MenuItem(MenuItem.itemType.Primi, "Risotto ai funghi", 7.50));

		try {
			assertEquals(21.50, bill.getOrderPrice(order), 0);
		} catch (RestaurantBillException e) {
			e.printStackTrace();
		}
	}

	/*
	 * issue #9 . ordine con >10 ordinazioni
	 */
	@Test
	public void sum_moreThen10ItemsPrice() {
		Bill bill = new Bill();

		ArrayList<MenuItem> order = new ArrayList<MenuItem>();

		order.add(new MenuItem(MenuItem.itemType.Pizze, "Verdure", 6.50));
		order.add(new MenuItem(MenuItem.itemType.Pizze, "Tonno e Cipolle", 6.00));
		order.add(new MenuItem(MenuItem.itemType.Pizze, "Ananas", 1.50));
		order.add(new MenuItem(MenuItem.itemType.Primi, "Risotto ai funghi", 7.50));
		order.add(new MenuItem(MenuItem.itemType.Primi, "Pasta", 4.20));
		order.add(new MenuItem(MenuItem.itemType.Primi, "Riso", 3.80));
		order.add(new MenuItem(MenuItem.itemType.Primi, "Minestrone", 4.00));
		order.add(new MenuItem(MenuItem.itemType.Primi, "Minestra", 2.00));
		order.add(new MenuItem(MenuItem.itemType.Pizze, "Viennese", 6.50));
		order.add(new MenuItem(MenuItem.itemType.Pizze, "Margherita", 4.00));
		order.add(new MenuItem(MenuItem.itemType.Pizze, "Calzone", 6.50));
		try {
			assertEquals(51.00, bill.getOrderPrice(order), 0);
		} catch (RestaurantBillException e) {
			e.printStackTrace();
		}
	}

	/*
	 * issue #9 . ordine con >10 ordinazioni
	 */
	@Test
	public void sum_moreThen100euroOrderSalePrice() {
		Bill bill = new Bill();

		ArrayList<MenuItem> order = new ArrayList<MenuItem>();

		order.add(new MenuItem(MenuItem.itemType.Pizze, "Verdure", 100.00));
		order.add(new MenuItem(MenuItem.itemType.Pizze, "Tonno e Cipolle", 20.0));
		try {
			assertEquals(114, bill.getOrderPrice(order), 0);
		} catch (RestaurantBillException e) {
			e.printStackTrace();
		}
	}

}
