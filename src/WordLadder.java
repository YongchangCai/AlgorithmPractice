//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import java.util.Queue;
//import java.util.Set;
//
//public class WordLadder {
//    /**
//     * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
//     *
//     * Every adjacent pair of words differs by a single letter.
//     * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
//     * sk == endWord
//     * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest
//     * transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
//     */
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        Map<String, Integer> order = new HashMap<>();
//        Set<String> wordSet = new HashSet<>(wordList);
//        if (!wordSet.contains(endWord)) {
//            return 0;
//        }
//
//        bfs(beginWord, endWord, wordSet, order);
//
//        return order.getOrDefault(endWord, 0);
//
//    }
//
//    private void bfs(String beginWord, String endWord, Set<String> wordSet, Map<String, Integer> order) {
//        Queue<String> queue = new LinkedList<>();
//
//        queue.add(beginWord);
//        order.put(beginWord, 1);
//
//        while (!queue.isEmpty()) {
//            String currentWord = queue.poll();
//            wordSet.remove(currentWord);
//            int currentOrder = order.get(currentWord);
//            for (String word : wordSet) {
//                if (isLadder(currentWord, word)) {
//                    order.putIfAbsent(word, currentOrder+1);
//                    queue.offer(word);
//                }
//            }
//            if (endWord.equals(currentWord)) {
//                break;
//            }
//        }
//    }
//
//    private boolean isLadder(String word, String ladder) {
//        for (int i = 0; i < chs.length; i++) {
//            for (char c = 'a'; c <= 'z'; c++) {
//                char old = chs[i];
//                chs[i] = c;
//                String target = String.valueOf(chs);
//
//                if (endSet.contains(target)) {
//                    return len + 1;
//                }
//
//                if (!visited.contains(target) && wordList.contains(target)) {
//                    temp.add(target);
//                    visited.add(target);
//                }
//                chs[i] = old;
//            }
//        }
//    }
//}
