package hello;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import db_spring.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "%s";
    private static final int princeSword = 5;
    private static int itemPice;
    private static final int princeSpear = 3;
    private static final int princeGrenade = 1;
    private static String gnome_id;
    private final AtomicLong counter = new AtomicLong();

    ApplicationContext ac = new FileSystemXmlApplicationContext("db.xml");
    Templates templates = (Templates) ac.getBean("Templates");

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/")
    public Nil nil(String hello) {
        return new Nil("Hello");
    }

    @RequestMapping("/my-info")
    public ValuesMap showG() {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        gnome_id = userDetails.getUsername();

        ValuesGnome vg = templates.showValuesGnome(gnome_id);

        List<ValuesItem> lvi = templates.showValuesItem(gnome_id);

        ValuesMap vm = new ValuesMap();

        vm.setGnome_name(vg.getGnome_name());
        vm.setGnome_money(vg.getGnome_money());

        HashMap<String, Integer> arms = new HashMap<>();
        for (ValuesItem vi : lvi) {
            arms.put(vi.getItem_name(), vi.getQuantity());
        }
        vm.setItems(arms);
        return vm;
    }

    @RequestMapping("/buy")
    public Buy buy(@RequestParam(value = "item_id") String item_id) {

        Money money = templates.getMoney(gnome_id);

        Buy b = new Buy();

        int currentMoney = money.getRubles();

        switch (item_id) {
            case "01":
                itemPice = 5;
                break;
            case "02":
                itemPice = 2;
                break;
            case "03":
                itemPice = 1;
                break;
        }

        if (itemPice > currentMoney){
            b.setError_code("Not enough money");
            return b;
        }

        List<BaughtItem> lbi = templates.getBaughtItem(gnome_id);

        for (BaughtItem bi : lbi) {
            if (bi.getItem().equals(item_id)) {
                templates.buyItemOld(gnome_id, item_id, itemPice);
                b.setItem_name(item_id);
                b.setError_code("OK");
                return b;
            }
        }
            templates.buyItemNew(gnome_id, item_id, itemPice);
            b.setItem_name(item_id);
            b.setError_code("OK");
        return b;
    }

    @RequestMapping("/sell")
    public Buy sell(@RequestParam(value = "item_id") String item_id) {
        int quantity = 0;
        String item;
        Buy b = new Buy();

        switch (item_id) {
            case "01":
                itemPice = 5;
                break;
            case "02":
                itemPice = 2;
                break;
            case "03":
                itemPice = 1;
                break;
        }

        List<BaughtItem> lbi = templates.getBaughtItem(gnome_id);

        for (BaughtItem bi : lbi) {
            quantity = bi.getQuantity();
            item = bi.getItem();
            if (item.equals(item_id) && (quantity > 1)) {
                templates.sellItemOld(gnome_id, item_id, itemPice);
                b.setItem_name(item_id);
                b.setError_code("OK");
                return b;
            } else if (item.equals(item_id) && quantity == 1) {
                templates.sellItemLast(gnome_id, item_id, itemPice);
                b.setItem_name(item_id);
                b.setError_code("OK");
                return b;
            }
        }
        b.setError_code("You haven't this item");
        return b;
    }

    @RequestMapping("/view-shop")
    public Shop viewShop(){
        return new Shop("sword", 5);
    }


}
