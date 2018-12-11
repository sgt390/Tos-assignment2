package it.unipd.tos.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class MenuItemTest {

    /*
     * Test costruttore e getters 
     */
    @Test
    public void constructorAndGettersTest() {
        MenuItem item = new MenuItem(MenuItem.itemType.Pizze, "Margherita", 4.0);
        assertEquals(MenuItem.itemType.Pizze, item.type());
        assertEquals(4.0,item.price(),0);
        assertEquals("Margherita",item.name());
    }

}
