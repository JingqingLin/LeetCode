public class Solution {
    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
    static class Trie {
        private static class TrieNode {
            private boolean isEnd;
            public TrieNode[] children;

            public TrieNode() {
                children = new TrieNode[26];
                isEnd = false;
            }

            public void setEnd() {
                isEnd = true;
            }

            public boolean getEnd() {
                return isEnd;
            }
        }

        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode cur = root;
            char[] chars = word.toCharArray();
            for (char c : chars) {
                int pos = c - 'a';
                if (cur.children[pos] == null) {
                    cur.children[pos] = new TrieNode();
                }
                cur = cur.children[pos];
            }
            cur.setEnd();
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode cur = root;
            char[] chars = word.toCharArray();
            for (char c : chars) {
                int pos = c - 'a';
                if (cur.children[pos] == null) {
                    return false;
                }
                cur = cur.children[pos];
            }
            return cur.getEnd();
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode cur = root;
            char[] chars = prefix.toCharArray();
            for (char c : chars) {
                int pos = c - 'a';
                if (cur.children[pos] == null) {
                    return false;
                }
                cur = cur.children[pos];
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("apple");
        System.out.println(obj.search("apple"));
        System.out.println(obj.search("app"));
        System.out.println(obj.startsWith("app"));
        obj.insert("app");
        System.out.println(obj.search("app"));
    }
}
