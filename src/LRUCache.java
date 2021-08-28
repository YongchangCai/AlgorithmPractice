import java.util.HashMap;
import java.util.LinkedHashMap;

public class LRUCache {

    private LinkedHashMap<Integer, Integer> cache;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public int get(int key) {
        if ( cache.containsKey(key)) {
            int value = cache.remove(key);
            cache.put(key, value);

            return cache.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        } else if ( cache.size() == capacity ) {
            cache.remove(cache.keySet().iterator().next());
        }
        cache.put(key, value);
    }
}
