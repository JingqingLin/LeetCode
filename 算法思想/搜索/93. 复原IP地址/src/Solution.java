import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> restoreIpAddresses(String s) {
        List<String> ipList = new ArrayList<>();
        ipCombination(ipList, new ArrayList<>(), 0, s);
        return ipList;
    }

    /** 可不用 cursorPos 这个参数。直接 s.subString(i + 1) 作为 s 参数 */
    private static void ipCombination(List<String> ipList, List<Integer> dotPos, int cursorPos, String s) {
        if (dotPos.size() == 4) {
            if (s.length() == cursorPos) {
                StringBuilder ip = new StringBuilder();
                ip.append(s, 0, dotPos.get(0));
                ip.append('.');
                ip.append(s, dotPos.get(0), dotPos.get(1));
                ip.append('.');
                ip.append(s, dotPos.get(1), dotPos.get(2));
                ip.append('.');
                ip.append(s, dotPos.get(2), dotPos.get(3));
                ipList.add(String.valueOf(ip));
            }
            return;
        }
        if (s.length() == cursorPos) {
            return;
        }
        for (int i = 1; i <= 3; i++) {
            int nextCursorPos = Math.min(cursorPos + i, s.length());
            String subIp;
            subIp = s.substring(cursorPos, nextCursorPos);
            if (subIp.length() > 1 && subIp.charAt(0) == '0') {
                return;
            }
            if (Integer.parseInt(subIp) <= 255) {
                dotPos.add(nextCursorPos);
                ipCombination(ipList, dotPos, nextCursorPos, s);
                dotPos.remove(dotPos.size() - 1);
            }
            if (nextCursorPos == s.length()) {
                break;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("010010"));
        // "010010"
    }
}
