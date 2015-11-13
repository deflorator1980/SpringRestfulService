import hello_big.*;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;


public class GreetingControllerBigTest {
    GreetingControllerBig greetingControllerBig = new GreetingControllerBig();

//    @org.junit.Test
    public void testViewShop() throws Exception {
        List<ShopBig> getItemList = greetingControllerBig.getItemsList();

        assertEquals(greetingControllerBig.viewShop(), getItemList);// constructor

        List<ShopBig> listEtalon = new ArrayList<>();
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
    }

//    @Test
    public void testNil() {
        NilBig nilEtalon = new NilBig("Hello");
        assertEquals(nilEtalon, greetingControllerBig.nil(""));
    }

    @Test
    public void testMyInfoVova() {
        ValuesMapBig vmEtalon = new ValuesMapBig();
        vmEtalon.setGnome_name("vova");
        vmEtalon.setGnome_money(new BigDecimal("6.00"));
        HashMap<String, Integer> armsEtalon = new HashMap<>();
        armsEtalon.put("spear", 1);
        vmEtalon.setItems(armsEtalon);
        assertEquals(vmEtalon, greetingControllerBig.myInfo());
    }

//    @Test
    public void testMyInfoDasha() {
        ValuesMapBig vmEtalon = new ValuesMapBig();
        vmEtalon.setGnome_name("dasha");
        vmEtalon.setGnome_money(new BigDecimal("324242345325274.23"));
        HashMap<String, Integer> armsEtalon = new HashMap<>();
        armsEtalon.put("sword", 5);
        vmEtalon.setItems(armsEtalon);
        assertEquals(vmEtalon, greetingControllerBig.myInfo());
    }

//    @Test
    public void testMyInfoYasha() {
        ValuesMapBig vmEtalon = new ValuesMapBig();
        vmEtalon.setGnome_name("yasha");
        vmEtalon.setGnome_money(new BigDecimal("1236.12"));
        HashMap<String, Integer> armsEtalon = new HashMap<>();
        armsEtalon.put("sword", 4);
        armsEtalon.put("grenade", 3);
        vmEtalon.setItems(armsEtalon);
        assertEquals(vmEtalon, greetingControllerBig.myInfo());
    }

//    @Test
    public void testBuy() throws ParserConfigurationException, SAXException, IOException {
        BuyBig testBb = new BuyBig();
        testBb.setError_code("OK");
        testBb.setItem_name("02");
        assertEquals(testBb, greetingControllerBig.buy());
    }

//    @Test
    public void testBuyNoMoney() throws ParserConfigurationException, SAXException, IOException {
        BuyBig testBb = new BuyBig();
        testBb.setError_code("Not enough money");
        testBb.setItem_name(null);
        System.out.println(greetingControllerBig.buy());
        assertEquals(testBb, greetingControllerBig.buy());
    }

//    @Test
    public void testSell() throws ParserConfigurationException, SAXException, IOException {
        BuyBig testBb = new BuyBig();
        testBb.setError_code("OK");
        testBb.setItem_name("01");
        assertEquals(testBb, greetingControllerBig.sell());
    }

    @Test
    public void testSellNoItem() throws ParserConfigurationException, SAXException, IOException {
        BuyBig testBb = new BuyBig();
        testBb.setError_code("You haven't this item");
        testBb.setItem_name(null);
        assertEquals(testBb, greetingControllerBig.sell());
    }



}