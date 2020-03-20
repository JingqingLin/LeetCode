public class Solution {
    public static String toHex(int num) {
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.insert(0, map[num & 0xf]);
            num = num >>> 4;
        }
        return String.valueOf(sb);
    }

    public static void main(String[] args) {
        System.out.println(toHex(-2));
    }
}
