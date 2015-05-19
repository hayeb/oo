package assignment12a;

import java.util.ArrayList;

public class TestMain {
    public static final void main(String[] argc) {
        System.out.println("Hello world!");
        ArrayList<String> lijstje = new ArrayList<String>();
        lijstje.add("Dit is een string.");
        lijstje.add("Dit is nog een string.");

        for (String s : lijstje) {
            System.out.print(s);
        }
        int x = 0;
        for (String s : lijstje) {
            x += 1;           
            System.out.println(x);
        }
    }
}
