package budget;

import java.util.List;

public class Sorter {
    SortingStrategy strategy;

    public Sorter(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    List<Entry> getSortedList() {
        return strategy.getSortedList();
    }

}
