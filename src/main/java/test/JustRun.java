package test;

import hello_big.TemplatesBig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class JustRun {
    public static void main(String[] args) {
//        TemplatesBig tb = new TemplatesBig();
//        System.out.println(tb.showValuesGnome("001"));
//        System.out.println(tb.getClass());
        ApplicationContext ac = new FileSystemXmlApplicationContext("db.xml");
        TemplatesBig templates = (TemplatesBig) ac.getBean("TemplatesBig");
//        System.out.println(templates.getBaughtItem("001"));

    }
}
