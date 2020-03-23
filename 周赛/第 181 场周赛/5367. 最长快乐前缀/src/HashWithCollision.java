public class HashWithCollision {
    public static String longestPrefix(String s) {
        int len = s.length();
        int hashcode = hash(s);
        int prefixHash = hashcode, suffixHash = hashcode;
        int l = 0, r = len - 1;
        while (r >= 0) {
            prefixHash -= s.charAt(r) - 'A';
            suffixHash -= s.charAt(l) - 'A';
            if (suffixHash == prefixHash && s.substring(0, r).equals(s.substring(l + 1))) {
                return s.substring(0, r);
            }
            r--;
            l++;
        }
        return "";
    }

    private static int hash(String s) {
        int hashcode = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            hashcode += c - 'A';
        }
        return hashcode;
    }

    public static void main(String[] args) {
        System.out.println(longestPrefix("ababab"));
    }
}
