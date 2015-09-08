package hello;

import java.util.List;
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

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/hui")
    public Greeting hui(@RequestParam(value="hui", defaultValue="Hui") String hui) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, hui));
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
    @RequestMapping("/db1")
    public RetrieverSetter db1(){
        String result;
        ApplicationContext ac = new FileSystemXmlApplicationContext("db.xml");
        Templates templates = (Templates)ac.getBean("Templates");

        Values value = templates.showGnome("001");
        result = "\n\ngnome_name: " + value.getGnome_name() +
                " gnome_money: " + value.getGnome_money() + " item_name: " + value.getItem_name()+
                " quatity: " + value.getQuatity();

        RetrieverSetter retrieverSetter = new RetrieverSetter();
        retrieverSetter.setItem("nehui");
        retrieverSetter.setPrice(11);
        retrieverSetter.setName(result);
        return  retrieverSetter;
    }

    @RequestMapping("db2")
    public Values db2(){
        ApplicationContext ac = new FileSystemXmlApplicationContext("db.xml");
        Templates templates = (Templates)ac.getBean("Templates");
        Values value = templates.showGnome("001");
        return value;
    }

}
