import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordLadder2Test {

    private WordLadder2 instance = new WordLadder2();

    @Test
    public void testWordLadder2() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> words = Arrays.asList("hot","dot","dog","lot","log","cog");
        List<List<String>> results = instance.findLadders(beginWord, endWord, words);
    }
}
