import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    static class LFUCache {

        Map<Integer, Node> cache;
        Queue<Node> queue;
        int capacity;
        int size;
        int globalTime = 0;

        public LFUCache(int capacity) {
            cache = new HashMap<>(capacity);
            if (capacity > 0) {
                queue = new PriorityQueue<>(capacity);
            }
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) {
                return -1;
            }
            node.frequency++;
            node.globalTime = globalTime++;
            queue.remove(node);
            queue.offer(node);
            return node.value;

        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            Node node = cache.get(key);
            if (node != null) {
                node.value = value;
                node.frequency++;
                node.globalTime = globalTime++;
                queue.remove(node);
                queue.offer(node);
            } else {
                if (size == capacity) {
                    cache.remove(queue.peek().key);
                    queue.poll();
                    size--;
                }
                Node newNode = new Node(key, value, globalTime++);
                cache.put(key, newNode);
                queue.offer(newNode);
                size++;
            }
        }
    }

    /**
     * 一个类实现了 Comparable 接口，就意味着“该类支持排序”
     */
    private static class Node implements Comparable<Node> {
        int key;
        int value;
        int frequency;
        int globalTime;

        public Node() {
        }

        public Node(int key, int value, int globalTime) {
            this.key = key;
            this.value = value;
            frequency = 1;
            this.globalTime = globalTime;
        }

        @Override
        public int compareTo(Node node) {
            int diff = frequency - node.frequency;
            return diff != 0 ? diff : globalTime - node.globalTime;
        }
    }

    public static void main(String[] args) {
        LFUCache obj = new LFUCache(2);
    }
}
