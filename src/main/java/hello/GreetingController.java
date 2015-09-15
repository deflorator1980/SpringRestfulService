package hello;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import db_spring.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "%s";
    private final AtomicLong counter = new AtomicLong();

    ApplicationContext ac = new FileSystemXmlApplicationContext("db.xml");
    Templates templates = (Templates)ac.getBean("Templates");

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/")
    public Nil nil(String hello){
        return new Nil("Hello");
    }

    @RequestMapping("/buy")
    public Buy buy(@RequestParam(value="item_id")String item_id){
        templates.buyItemNew("001", item_id);
        Buy b = new Buy();
        b.setItem_name(item_id);
        return b;
    }

    @RequestMapping("/my-info")
    public ValuesMap showG(@RequestParam(value = "gnome_id", defaultValue = "002")String gnome_id){
//        ApplicationContext ac = new FileSystemXmlApplicationContext("db.xml");
//        Templates templates = (Templates)ac.getBean("Templates");

        ValuesGnome vg = templates.showValuesGnome(gnome_id);

        List<ValuesItem> lvi = templates.showValuesItem(gnome_id);

        ValuesMap vm = new ValuesMap();

        vm.setGnome_name(vg.getGnome_name());
        vm.setGnome_money(vg.getGnome_money());

        HashMap<String, Integer> arms = new HashMap<>();
        for (ValuesItem vi : lvi){
            arms.put(vi.getItem_name(), vi.getQuantity());
        }
        vm.setItems(arms);
        return vm;
    }





}
