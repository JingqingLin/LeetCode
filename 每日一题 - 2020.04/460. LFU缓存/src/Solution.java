import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution {
    static class LFUCache {
        private int capacity;
        private HashMap<Integer, Integer> cache;
        private HashMap<Integer, Integer> visitCount;
        private PriorityQueue<Integer> pq;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            cache = new HashMap<>();
            visitCount = new HashMap<>();
            pq = new PriorityQueue<>((o1, o2) -> visitCount.get(o1) - visitCount.get(o2));
        }

        public int get(int key) {
            return 1;
        }

        public void put(int key, int value) {
            cache.put(key, value);
        }
    }

    public static void main(String[] args) {
        LFUCache obj = new LFUCache(2);
    }
}
