import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class SearchSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        int total = products.length;
        List<List<String>> result = new ArrayList<>();
        for (int i =1; i <= searchWord.length(); i++ ) {
            String subString = searchWord.substring(0, i);
            PriorityQueue<String> heap = new PriorityQueue<>(total+1,
                    Comparator.comparing(o -> o.compareTo(subString)));
            new HashMap<>(5);

            for(String product : products) {
                heap.add(product);
                if (heap.size() > total) {
                    heap.poll();
                }
            }

            List<String> searchList = new ArrayList<>();
            searchList.addAll(heap);

            result.add(searchList);
        }

        return result;
    }
}
