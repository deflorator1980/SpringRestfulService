package test;

import hello_big.GreetingControllerBig;
import hello_big.NilBig;
import hello_big.ShopBig;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class GreetingControllerBigTest {
    GreetingControllerBig greetingControllerBig = new GreetingControllerBig();

    @org.junit.Test
    public void testViewShop() throws Exception {
        List<ShopBig> getItemList = greetingControllerBig.getItemsList();
// constructor
        assertEquals(greetingControllerBig.viewShop(), getItemList);
        List<ShopBig> listEtalon = new ArrayList<>();
//  view-shop
        ShopBig shopBigEtalon = new ShopBig();
        shopBigEtalon.setId("01");
        shopBigEtalon.setName("sword");
        shopBigEtalon.setPrice(new BigDecimal("10"));

        listEtalon.add(shopBigEtalon);

        shopBigEtalon = new ShopBig();

        shopBigEtalon.setId("02");
        shopBigEtalon.setName("spear");
        shopBigEtalon.setPrice(new BigDecimal("4"));

        listEtalon.add(shopBigEtalon);

        shopBigEtalon = new ShopBig();

        shopBigEtalon.setId("03");
        shopBigEtalon.setName("grenade");
        shopBigEtalon.setPrice(new BigDecimal("2"));

        listEtalon.add(shopBigEtalon);

        assertEquals(listEtalon, getItemList);

// nill
        NilBig nilEtalon = new NilBig("Hello");
        assertEquals(nilEtalon, greetingControllerBig.nil(""));

    }
}