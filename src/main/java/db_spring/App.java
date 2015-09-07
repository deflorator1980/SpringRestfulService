package db_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;


public class App {
    public static void main(String[] args) {
        ApplicationContext ac = new FileSystemXmlApplicationContext("db.xml");
        Templates templates = (Templates)ac.getBean("Templates");

        List<Values> values = templates.showValues();
        for (Values value : values){
            System.out.println("gnome_name: " + value.getGnome_name() +
            " gnome_money: " + value.getGnome_money() + " item_name: " + value.getItem_name()+
            " quatity: " + value.getQuatity());
        }
    }
}
