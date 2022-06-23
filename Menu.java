package budget;

import java.util.LinkedHashMap;
import java.util.Map;

abstract class Menu {

    abstract void initialize();

    void showMenuTitle(String title) {
        System.out.println(title);
    }

    void show(Map<Integer, String> menuEntries) {
        for (Map.Entry<Integer, String> entry: menuEntries.entrySet()) {
            System.out.printf("%d) %s\n", entry.getKey(), entry.getValue());
        }
    }

    boolean exists(Map<Integer, String> menuEntries, int number) {
        return menuEntries.containsKey(number);
    }
}
