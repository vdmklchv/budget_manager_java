package budget;

import java.util.Collections;
import java.util.List;

public class SortByTypeStrategy implements SortingStrategy {

    List<Entry> entries;

    public SortByTypeStrategy(List<Entry> entries) {
        this.entries = entries;
    }
    @Override
    public List<Entry> getSortedList() {
        if (entries.size() == 0) {
            return null;
        }

        Collections.sort(entries, (a, b) -> {
            if (a.getPrice() < b.getPrice()) {
                return 1;
            } else if (a.getPrice() == b.getPrice()) {
                return 0;
            } else {
                return -1;
            }
        });
        return entries;
    }
}
