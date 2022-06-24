package budget;

import java.util.Collections;
import java.util.List;

public class SortAllStrategy implements SortingStrategy {

    List<Entry> inputList;

    public SortAllStrategy(List<Entry> inputList) {
        this.inputList = inputList;
    }
    @Override
    public List<Entry> getSortedList() {
        if (inputList.size() == 0) {
            return null;
        }
        Collections.sort(inputList, (a, b) -> {
            if (a.getPrice() < b.getPrice()) {
                return 1;
            } else if (a.getPrice() == b.getPrice()) {
                return 0;
            } else {
                return -1;
            }
        });
        return inputList;
    }
}
