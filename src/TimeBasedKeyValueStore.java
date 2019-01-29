import java.util.HashMap;
import java.util.TreeMap;

/**
 * <a href = "https://leetcode.com/problems/time-based-key-value-store/">Problem here.</a>
 * <p>
 * Created by NubbY
 */
public class TimeBasedKeyValueStore {

    // we can instead of treemap implement binary search in arraylist, kinda same in terms of time difficulty
    private HashMap<String, TreeMap<Integer, String>> store;

    /**
     * Initialize your data structure here.
     */
    public TimeBasedKeyValueStore() {
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (store.containsKey(key)) {
            TreeMap<Integer, String> innerTree = store.get(key);
            innerTree.put(timestamp, value);
        } else {
            TreeMap<Integer, String> innerTree = new TreeMap<>();
            innerTree.put(timestamp, value);
            store.put(key, innerTree);
        }
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> innerTree = store.getOrDefault(key, null);
        if (innerTree == null) {
            return "";
        } else {
            Integer closest = innerTree.floorKey(timestamp);
            if (closest == null) {
                return "";
            } else {
                return innerTree.get(closest);
            }
        }
    }
}
