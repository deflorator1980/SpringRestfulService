package test;

import hello_big.GreetingControllerBig;

import static org.junit.Assert.*;


public class GreetingControllerBigTest {
    GreetingControllerBig greetingControllerBig = new GreetingControllerBig();

    @org.junit.Test
    public void testViewShop() throws Exception {
        assertEquals(greetingControllerBig.viewShop(), greetingControllerBig.getItemsList());
    }
}