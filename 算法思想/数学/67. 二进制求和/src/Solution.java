public class Solution {
    public static String addBinary(String a, String b) {
        int l1 = a.length();
        int l2 = b.length();
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (l1 > 0 || l2 > 0) {
            int tempA = l1 <= 0 ? 0 : a.charAt(l1 - 1) - '0';
            int tempB = l2 <= 0 ? 0 : b.charAt(l2 - 1) - '0';
            int c = tempA + tempB + carry;
            if (c >= 2) {
                c = c % 2;
                carry = 1;
            } else {
                carry = 0;
            }
            sb.insert(0, c);
            l1--;
            l2--;
        }
        if (carry == 1) {
            sb.insert(0, 1);
        }
        return String.valueOf(sb);
        // return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }

    public static void main(String[] args) {
        System.out.println(addBinary("0", "1"));
    }
}
