package nothing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by deflo_000 on 08-Sep-15.
 */
public class Noth {
    public static void main(String[] args) {
        Huis h1 = new Huis();
        h1.setStringOne("One");
        h1.setStringTwo("Two");

        List<String> data = new ArrayList<>();
        data.add("d2");
        data.add("d3");
        data.add("d4");

        h1.setList(data);

        HashMap<String, Integer> arms = new HashMap<>();
        arms.put("spear", 1);
        arms.put("shell", 5);
        arms.put("sward", 1);

        h1.setDict(arms);



        System.out.println(h1.getStringOne());
        System.out.println(h1.getList());
        System.out.println(h1.getDict());

    }
}
