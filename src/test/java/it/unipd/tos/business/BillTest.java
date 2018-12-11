package it.unipd.tos.business;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import it.unipd.tos.business.Bill;
import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;

public class BillTest {

	/*
	 * issue #8 . ordine semplice (senza offerte)
	 */
	@Test
	public void sum_smallOrderPrice() throws RestaurantBillException {
		Bill bill = new Bill();

		ArrayList<MenuItem> order = new ArrayList<MenuItem>();

		order.add(new MenuItem(MenuItem.itemType.Pizze, "Verdure", 6.50));
		order.add(new MenuItem(MenuItem.itemType.Pizze, "Tonno e Cipolle", 6.00));
		order.add(new MenuItem(MenuItem.itemType.Pizze, "Ananas", 1.50));
		order.add(new MenuItem(MenuItem.itemType.Primi, "Risotto ai funghi", 7.50));

			assertEquals(21.50, bill.getOrderPrice(order), 0);
	}

	/*
	 * issue #9 . ordine con 10+ ordinazioni
	 */
	@Test
	public void sum_more10ItemsPrices() throws RestaurantBillException {
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
		
		assertEquals(51.00, bill.getOrderPrice(order), 0);
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	/*
	 * issue #10 . ordine 100+ euro
	 */
	@Test
	public void sum_moreThen100euroOrderSalePrice() throws RestaurantBillException {
		Bill bill = new Bill();

		ArrayList<MenuItem> order = new ArrayList<MenuItem>();

		order.add(new MenuItem(MenuItem.itemType.Pizze, "Verdure", 100.00));
		order.add(new MenuItem(MenuItem.itemType.Pizze, "Tonno e Cipolle", 20.0));
		
		assertEquals(114, bill.getOrderPrice(order), 0);
	}
	
	/*
	 * issue #10 . ordine con 20+ ordinazioni. Deve ritornare una eccezione
	 */
	@Test
	public void sum_moreThen20ItemsError() throws RestaurantBillException {
		thrown.expect(RestaurantBillException.class);
		Bill bill = new Bill();

		ArrayList<MenuItem> order = new ArrayList<MenuItem>();
		for(int i=0; i<=26; ++i) {
			order.add(new MenuItem(MenuItem.itemType.Pizze, "Ananas", 1.50));
		}
			bill.getOrderPrice(order);
		
	}

}
