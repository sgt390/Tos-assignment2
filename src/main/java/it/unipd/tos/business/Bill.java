////////////////////////////////////////////////////////////////////
// Stefano Zanatta 1142897
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import java.util.Comparator;
import java.util.List;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;

public class Bill implements RestaurantBill {

    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered) 
            throws RestaurantBillException {

        /*
         * errore 20+ pizze
         */
        if (itemsOrdered.size() > 20) {
            throw new RestaurantBillException();
        }
        /*
         * calcolo somma semplice. issue #8
         */
        double price = itemsOrdered.stream()
                .map((item) -> item.price())
                .reduce(0.0, Double::sum);

        /*
         * sconto 10+ pizze. issue #9
         */
        if (itemsOrdered.size() > 10) {
            price = price - itemsOrdered.stream()
                    .map((item) -> item.price())
                    .min(Comparator.comparing(Double::valueOf))
                    .get();
        }

        /*
         * sconto 100+ euro. issue #10
         */
        if (price > 100) {
            price = price * 0.95;
        }

        return price;

    }
}
