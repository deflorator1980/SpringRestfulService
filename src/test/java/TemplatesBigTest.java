import hello_big.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import static org.junit.Assert.*;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TemplatesBigTest {
    TemplatesBig templatesBig = new TemplatesBig();
    ApplicationContext ac = new FileSystemXmlApplicationContext("db.xml");
    TemplatesBig templates = (TemplatesBig) ac.getBean("TemplatesBig");

//    @Test
    public void testShowValuesGnome() {
        ValuesGnomeBig vgbEtalon = new ValuesGnomeBig();
        vgbEtalon.setGnome_name("yasha");
        vgbEtalon.setGnome_money(new BigDecimal("1236.12"));
        assertEquals(vgbEtalon, templates.showValuesGnome("003"));
    }

//    @Test
    public void testShowValuesItem(){
        List<ValuesItemBig> lviEtalon = new ArrayList<>();
        ValuesItemBig vib = new ValuesItemBig();
        vib.setItem_name("spear");
        vib.setQuantity(1);
        lviEtalon.add(vib);
        List<ValuesItemBig> lvi = templates.showValuesItem("001");
        assertEquals(lviEtalon, lvi);
    }

//    @Test
    public void testShowValuesItem003(){
        List<ValuesItemBig> lviEtalon = new ArrayList<>();
        ValuesItemBig vib1 = new ValuesItemBig();
        ValuesItemBig vib2 = new ValuesItemBig();
        vib1.setItem_name("sword");
        vib1.setQuantity(4);
        vib2.setItem_name("grenade");
        vib2.setQuantity(3);
        lviEtalon.add(vib1);
        lviEtalon.add(vib2);
        List<ValuesItemBig> lvi = templates.showValuesItem("003");
        assertEquals(lviEtalon, lvi);
    }

//    @Test
    public void testGetMoney(){
        MoneyBig mbEtalon = new MoneyBig();
        mbEtalon.setRubles(new BigDecimal("1236.12"));
        assertEquals(mbEtalon, templates.getMoney("003"));
    }

//    @Test
    public void testGetBaughtItem() {
        List<BaughtItemBig> testLbi = new ArrayList<>();
        BaughtItemBig testBi =  new BaughtItemBig();
        testBi.setItem("03");
        testBi.setQuantity(3);
        BaughtItemBig testBi2 =  new BaughtItemBig();
        testBi2.setItem("01");
        testBi2.setQuantity(4);
        testLbi.add(testBi2);
        testLbi.add(testBi);
        assertEquals(testLbi, templates.getBaughtItem("003"));
    }

//    @Test
    public void testBuyItemNew() {
        templates.buyItemNew("002", "02", new BigDecimal("4"));
        MoneyBig testM = new MoneyBig();
        testM.setRubles(new BigDecimal("324242345325270.23"));
        assertEquals(testM, templates.getMoney("002"));

        List<BaughtItemBig> testLbi = new ArrayList<>();
        BaughtItemBig testBi = new BaughtItemBig();
        BaughtItemBig testBi2 = new BaughtItemBig();
        testBi.setItem("01");
        testBi.setQuantity(5);
        testBi2.setItem("02");
        testBi2.setQuantity(1);
        testLbi.add(testBi);
        testLbi.add(testBi2);
        assertEquals(testLbi, templates.getBaughtItem("002"));
    }

//    @Test
    public void testBuyItemOld() {
        templates.buyItemOld("003", "03", new BigDecimal("1"));
        MoneyBig testM = new MoneyBig();
        testM.setRubles(new BigDecimal("1235.12"));
        assertEquals(testM, templates.getMoney("003"));

        List<BaughtItemBig> testLbi = new ArrayList<>();
        BaughtItemBig testBi = new BaughtItemBig();
        BaughtItemBig testBi2 = new BaughtItemBig();
        testBi.setItem("03");
        testBi.setQuantity(4);
        testBi2.setItem("01");
        testBi2.setQuantity(4);
        testLbi.add(testBi2);
        testLbi.add(testBi);
        assertEquals(testLbi, templates.getBaughtItem("003"));
    }

//    @Test
    public void testSellItemLast() {
        templates.sellItemLast("001", "02", new BigDecimal("4"));
        MoneyBig testM = new MoneyBig();
        testM.setRubles(new BigDecimal("14.00"));
        assertEquals(testM, templates.getMoney("001"));

        assertEquals(new ArrayList(), templates.getBaughtItem("001"));
    }

    @Test
    public void testSellItemOld() {
        templates.sellItemOld("002", "01", new BigDecimal("10.00"));
        MoneyBig testM = new MoneyBig();
        testM.setRubles(new BigDecimal("324242345325284.23"));
        assertEquals(testM, templates.getMoney("002"));

        List<BaughtItemBig> testLbi = new ArrayList<>();
        BaughtItemBig testBi = new BaughtItemBig();
        testBi.setItem("01");
        testBi.setQuantity(4);
        testLbi.add(testBi);
        assertEquals(testLbi, templates.getBaughtItem("002"));
    }
}
