package test;


import hello_big.TemplatesBig;
import hello_big.ValuesGnomeBig;
import hello_big.ValuesItemBig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import static org.junit.Assert.*;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TemplatesBigTest {
    TemplatesBig templatesBig = new TemplatesBig();

    @Test
    public void testShowValuesGnome() {
        ApplicationContext ac = new FileSystemXmlApplicationContext("db.xml");
        TemplatesBig templates = (TemplatesBig) ac.getBean("TemplatesBig");

        ValuesGnomeBig vgbEtalon = new ValuesGnomeBig();
        vgbEtalon.setGnome_name("yasha");
        vgbEtalon.setGnome_money(new BigDecimal("1236.12"));
        assertEquals(vgbEtalon, templates.showValuesGnome("003"));
    }

    @Test
    public void testShowValuesItem(){
        ApplicationContext ac = new FileSystemXmlApplicationContext("db.xml");
        TemplatesBig templates = (TemplatesBig) ac.getBean("TemplatesBig");
        List<ValuesItemBig> lviEtalon = new ArrayList<>();
        ValuesItemBig vib = new ValuesItemBig();
        vib.setItem_name("spear");
        vib.setQuantity(1);
        lviEtalon.add(vib);
        List<ValuesItemBig> lvi = templates.showValuesItem("001");
        assertEquals(lviEtalon, lvi);
    }

    @Test
    public void testShowValuesItem003(){
        ApplicationContext ac = new FileSystemXmlApplicationContext("db.xml");
        TemplatesBig templates = (TemplatesBig) ac.getBean("TemplatesBig");
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
}
