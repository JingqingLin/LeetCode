public class HashWithoutCollision {
    public static String longestPrefix(String s) {
        int base = 131;
        long[] hash = new long[100005];
        long[] pLength = new long[100005];
        hash[0] = 0;
        pLength[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            hash[i] = hash[i - 1] * base + s.charAt(i - 1) - 'a';
            pLength[i] = pLength[i - 1] * base;
        }
        for (int i = s.length() - 1; i > 0; i--) {
            long prefixHash = hash[i];
            long suffixHash = hash[s.length()] - hash[s.length() - i] * pLength[i];
            if (prefixHash == suffixHash) {
                return s.substring(0, i);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(longestPrefix("leeTcodeleeT"));
    }
}
