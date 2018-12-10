package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;

public class Bill implements RestaurantBill {

	@Override
	public double getOrderPrice(List<MenuItem> itemsOrdered) throws RestaurantBillException {
		
		double price = itemsOrdered.stream()
			.map((item)->item.price())
			.reduce(0.0,Double::sum);
		return price;
	}

}
