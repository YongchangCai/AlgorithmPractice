import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned.
 * It is guaranteed there is at least one word that is not banned, and that the answer is unique.
 *
 * The words in paragraph are case-insensitive and the answer should be returned in lowercase.
 */
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split("\\W+");
        HashSet<String> banSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> counter = new HashMap<>();

        for (String word : words) {
            if (!banSet.contains(word)) {
                counter.put(word, counter.getOrDefault(word,0) + 1);
            }
        }

        return Collections.max(counter.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
