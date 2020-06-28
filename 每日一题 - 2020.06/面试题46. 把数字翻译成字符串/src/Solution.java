public class Solution {
    private static int cnt;

    public static int translateNum(int num) {
        String str = String.valueOf(num);
        cnt = 0;
        DFS(str);

        return cnt;
    }

    private static void DFS(String str) {
        if (str.length() == 0) {
            cnt++;
            return;
        }
        int len = str.length();
        char headNum = str.charAt(0);

        if (headNum == '0' || headNum > '2') {
            DFS(str.substring(1, len));
        } else {
            DFS(str.substring(1, len));
            if (str.length() > 1) {
                if (!(headNum == '2' && str.charAt(1) > '5')) {
                    DFS(str.substring(2, len));
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(translateNum(12258));
    }
}
