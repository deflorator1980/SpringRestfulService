package test;


import hello_big.TemplatesBig;
import hello_big.ValuesGnomeBig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import static org.junit.Assert.*;


import java.math.BigDecimal;

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
}
