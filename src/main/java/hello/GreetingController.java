package hello;

import java.util.HashMap;
import java.util.List;

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
import java.io.IOException;
import java.util.*;
@RestController
public class GreetingController {

    private int itemPice;

    private String gnome_id;

    ApplicationContext ac = new FileSystemXmlApplicationContext("db.xml");
    Templates templates = (Templates) ac.getBean("Templates");

    private   Node weapons;
    private   Document doc;
    private   int idNext;
    private   String filepath = "items.xml";

    List<Shop> shopList;

    public GreetingController(){
        try {
            shopList = getItemsList();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/")
    public Nil nil(String hello) {
        return new Nil("Hello");
    }

    @RequestMapping("/my-info")
    public ValuesMap myInfo() {

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

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        gnome_id = userDetails.getUsername();

        Money money = templates.getMoney(gnome_id);

        Buy b = new Buy();

        int currentMoney = money.getRubles();

        for(Shop sp : shopList) {
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

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        gnome_id = userDetails.getUsername();

        int quantity;
        String item;
        Buy b = new Buy();

        for(Shop sp : shopList) {
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

        return shopList;
    }

    public List<Shop> getItemsList() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        List<Shop> itemsList = new ArrayList<>();
        doc = docBuilder.parse(filepath);
        weapons = doc.getElementsByTagName("weapons").item(0);

        Shop shop;

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
