import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder2 {
    /**
     * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of
     * words beginWord -> s1 -> s2 -> ... -> sk such that:
     * <p>
     * Every adjacent pair of words differs by a single letter.
     * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
     * sk == endWord
     * Given two words, beginWord and endWord, and a dictionary wordList,
     * return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists.
     * Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Map<String, Set<String>> neighbors = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();

        bfs(beginWord, endWord, wordSet, neighbors, distance);

        System.out.println(neighbors.toString());
        System.out.println(distance.toString());
        List<List<String>> result = new ArrayList<>();
        dfs(beginWord, endWord, neighbors, distance, result, new ArrayList<>());

        return result;
    }

    private void bfs(String beginWord, String endWord, Set<String> wordSet, Map<String, Set<String>> neighbors, Map<String, Integer> distance) {
        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);
        distance.put(beginWord, 0);
        boolean reachEnd = false;

        while(!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                String currentWord = queue.poll();
                int order = distance.get(currentWord);
                Set<String> neighbor = new HashSet<>();
                wordSet.remove(currentWord);
                for (String word : wordSet) {
                    if (isLadderWord(currentWord, word)) {
                        neighbor.add(word);
                        distance.putIfAbsent(word, order + 1);
                        if (endWord.equals(currentWord)) {
                            reachEnd = true;
                        } else {
                            queue.add(word);
                        }
                    }
                }
                distance.putIfAbsent(currentWord, order);
                neighbors.putIfAbsent(currentWord, neighbor);
                order++;
                if (reachEnd) {
                    break;
                }
            }
        }
    }

    private boolean isLadderWord(String word, String ladder) {
        if (word == null || ladder == null || word.length() != ladder.length()) {
            return false;
        }
        int diffCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != ladder.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount == 1;
    }

    private void dfs(String currentWord, String endWord, Map<String, Set<String>> neighbors, Map<String, Integer> distance,
                     List<List<String>> result, List<String> currentList) {
        currentList.add(currentWord);
        if (endWord.equals(currentWord)) {

            result.add(new ArrayList<>(currentList));
        } else {
            for (String next : neighbors.get(currentWord)) {
                if (distance.get(next) == distance.get(currentWord) + 1) {
                    dfs(next, endWord, neighbors, distance, result, currentList);
                }
            }
        }
        currentList.remove(currentList.size() - 1);
    }
}
