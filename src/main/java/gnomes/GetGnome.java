package gnomes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class GetGnome {
    public static void main(String[] args) {
        ApplicationContext ac = new FileSystemXmlApplicationContext("MySql.xml");
        ValueGnomeTemplate valueGnomeTemplate =(ValueGnomeTemplate)ac.getBean("ValueGnomeTemplate");

//        List<ValueGnome> valueGnomes = valueGnomeTemplate.listGnomes();
//        for(ValueGnome valueGnome : valueGnomes){
//            System.out.print("\ngnome_id: " + valueGnome.getGnome_id());
//            System.out.print(" gnome_name: " + valueGnome.getGnome_name());
//            System.out.print(" gnome_money: " + valueGnome.getGnome_money());
//        }

        ValueGnome valueGnome = valueGnomeTemplate.getGnome("001");
        System.out.println("gnome_name = " + valueGnome.getGnome_name() +
            " | gnome_money = " + valueGnome.getGnome_money());
    }
}
