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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.*;

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

    public  Node weapons;
    public  Document doc;
    public  int idNext;
    public  String filepath = "items.xml";

    List<Shop> itemsList = new ArrayList<>();

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
    public Buy buy(@RequestParam(value = "item_id") String item_id) throws IOException, SAXException, ParserConfigurationException {

        Money money = templates.getMoney(gnome_id);

        Buy b = new Buy();

        int currentMoney = money.getRubles();

        List<Shop> shop = viewShop();

        for(Shop sp : shop) {
            if (sp.getId().equals(item_id)) {
                itemPice = sp.getPrice();
            }
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
    public Buy sell(@RequestParam(value = "item_id") String item_id) throws IOException, SAXException, ParserConfigurationException {
        int quantity = 0;
        String item;
        Buy b = new Buy();

        List<Shop> shop = viewShop();

        for(Shop sp : shop) {
            if (sp.getId().equals(item_id)) {
                itemPice = sp.getPrice();
            }
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
    public List<Shop> viewShop() throws ParserConfigurationException, IOException, SAXException {
//        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
//        doc = docBuilder.parse(filepath);
//        weapons = doc.getElementsByTagName("weapons").item(0);
//
//        List<Shop> everyThing = new ArrayList<>();
//
//        Shop shop = null;
//
//        NodeList list = weapons.getChildNodes();
//        int lenght = list.getLength();
//        for (int i = 0; i < lenght; i++) {
//            Node node = list.item(i);
//            if ("weapon".equals(node.getNodeName())) {
//                shop = new Shop();
//                shop.setId(node.getAttributes().getNamedItem("id").getTextContent());
//                shop.setName(((Element)node).getElementsByTagName("name").item(0).getTextContent());
//                shop.setPrice(Integer.parseInt(((Element) node).getElementsByTagName("price").item(0).getTextContent()));
//                everyThing.add(shop);
//            }
//        }
//        if(itemsList != null){
//            return itemsList;
//        }
//        return getItemsList();
        if (itemsList.isEmpty()){
            return getItemsList();
        }
        return itemsList;
    }

    public List<Shop> getItemsList() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        doc = docBuilder.parse(filepath);
        weapons = doc.getElementsByTagName("weapons").item(0);

        Shop shop = null;

        NodeList list = weapons.getChildNodes();
        int lenght = list.getLength();
        for (int i = 0; i < lenght; i++) {
            Node node = list.item(i);
            if ("weapon".equals(node.getNodeName())) {
                shop = new Shop();
                shop.setId(node.getAttributes().getNamedItem("id").getTextContent());
                shop.setName(((Element)node).getElementsByTagName("name").item(0).getTextContent());
                shop.setPrice(Integer.parseInt(((Element) node).getElementsByTagName("price").item(0).getTextContent()));
                itemsList.add(shop);
            }
        }
        return itemsList;
    }
}


