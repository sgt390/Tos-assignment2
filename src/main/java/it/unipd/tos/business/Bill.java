package it.unipd.tos.business;

import java.util.Comparator;
import java.util.List;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;

public class Bill implements RestaurantBill {

	@Override
	public double getOrderPrice(List<MenuItem> itemsOrdered) throws RestaurantBillException {

		/*
		 * calcolo somma semplice issue #8
		 */
		double price = itemsOrdered.stream().map((item) -> item.price()).reduce(0.0, Double::sum);

		/*
		 * sconto 10 pizze issue #9
		 */
		if (itemsOrdered.size() > 10) {
			price = price - itemsOrdered.stream().map((item) -> item.price()).min(Comparator.comparing(Double::valueOf))
					.get();
		}

		if (price > 100) {
			price = price * 0.95;
		}

		return price;

	}
}
