package it.unipd.tos.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import it.unipd.tos.business.Bill;
import it.unipd.tos.business.exception.RestaurantBillException;

public class MenuItemTest {

	/*
	 * issue #8 . Controlla un ordine semplice (senza offerte) 
	 */
	@Test
	public void sum_smallOrderPrice() {
		Bill bill = new Bill();

		ArrayList<MenuItem> order = new ArrayList<MenuItem>();
		
		order.add( new MenuItem(MenuItem.itemType.Pizze,"Verdure", 6.50));
		order.add( new MenuItem(MenuItem.itemType.Pizze,"Tonno e Cipolle", 6.00));
		order.add( new MenuItem(MenuItem.itemType.Pizze,"Ananas", 1.50));
		order.add( new MenuItem(MenuItem.itemType.Primi,"Risotto ai funghi", 7.50));
		
		try {
			assertEquals(bill.getOrderPrice(order),21.50,0);
		} catch (RestaurantBillException e) {
			e.printStackTrace();
		}
		
	}

}
