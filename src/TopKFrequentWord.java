import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a non-empty list of words, return the k most frequent elements.
 *
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency,
 * then the word with the lower alphabetical order comes first.
 */
public class TopKFrequentWord {

    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> wordMap = new HashMap<>(words.length);
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(k + 1,
                (o1, o2) -> o1.getValue() == o2.getValue() ? o1.getKey().compareTo(o2.getKey()) : o1.getValue() - o2.getValue()
        );
        for (String word : words) {
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word)+1);
            } else {
                wordMap.put(word, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            pq.add(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> result = new LinkedList<>();

        while(!pq.isEmpty()) {
            result.add(0, pq.poll().getKey());
        }
        return result;

    }
}
