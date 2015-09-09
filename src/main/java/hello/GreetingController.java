package hello;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

import db_spring.Templates;
import db_spring.Values;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "%s";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/hui")
    public Greeting hui(@RequestParam(value="hui", defaultValue="Hui") String hui) {
        return new Greeting(1,
                String.format(template, hui));
    }
    @RequestMapping("/hui2")
    public Greeting hui2(@RequestParam(value="hui2", defaultValue="Hui") String hui2) {
        return new Greeting(1,
                String.format(template, hui2));
    }

    @RequestMapping("/view-shop")
    public Retriever viewShow(){
        return new Retriever("view", 12);
    }

    @RequestMapping("/setter")
    public RetrieverSetter setter(){
//        return new RetrieverSetter("hui", 22);
        RetrieverSetter retrieverSetter = new RetrieverSetter();
        retrieverSetter.setItem("nehui");
        retrieverSetter.setPrice(11);
        retrieverSetter.setName("Vova");
        return  retrieverSetter;
    }

    @RequestMapping("/list")
    public RetrieverMap showList(){
        RetrieverMap rl = new RetrieverMap();
        rl.setName("one");
        rl.setMoney("a lot");

        HashMap<String, Integer> arms = new HashMap<>();
        arms.put("spear", 1);
        arms.put("shell", 5);
        arms.put("sward", 1);
        rl.setItemsFull(arms);
        return rl;
    }

    @RequestMapping("db2")
    public Values db2(@RequestParam(value = "gnome_id", defaultValue = "001") String gnome_id){
        ApplicationContext ac = new FileSystemXmlApplicationContext("db.xml");
        Templates templates = (Templates)ac.getBean("Templates");
//        Values value = templates.showGnome(String.format(template, gnome_id));
        Values value = templates.showGnome(gnome_id);
        return value;
    }

}
