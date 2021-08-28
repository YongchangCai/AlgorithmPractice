import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortStringByFrequency {
    /**
     * Given a string s, sort it in decreasing order based on the frequency of characters, and return the sorted string.
     */

    public String frequencySort(String s) {
        Map<Character, Integer> hash = new HashMap<>(26);

        for (int i = 0; i < s.length(); i++) {
            hash.put(s.charAt(i), hash.getOrDefault(s.charAt(i) - '0', 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(hash.size(), Collections.reverseOrder(Comparator.comparing(Map.Entry::getValue)));

        for (Map.Entry<Character, Integer> h : hash.entrySet()) {
            pq.offer(h);
        }

        String result = "";
        while(!pq.isEmpty()) {
            Map.Entry<Character, Integer> newChar = pq.poll();
            result += helper(newChar.getKey(), newChar.getValue());
        }

        return result;

    }

    private String helper(char c, int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += c;
        }

        return result;
    }
}
