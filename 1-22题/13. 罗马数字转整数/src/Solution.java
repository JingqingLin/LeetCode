import java.util.HashMap;

public class Solution {
    public static int romanToInt(String s) {
        HashMap<String, Integer> romanMap = new HashMap<>();
        romanMap.put("I", 1);
        romanMap.put("IV", 4);
        romanMap.put("V", 5);
        romanMap.put("IX", 9);
        romanMap.put("X", 10);
        romanMap.put("XL", 40);
        romanMap.put("L", 50);
        romanMap.put("XC", 90);
        romanMap.put("C", 100);
        romanMap.put("CD", 400);
        romanMap.put("D", 500);
        romanMap.put("CM", 900);
        romanMap.put("M", 1000);
//        StringBuilder romanStr = new StringBuilder(s);
        int result = 0;
//        // 检索两位的罗马数字，并删除
//        for (int i = 0; i < romanStr.length()-1; ) {
//            StringBuilder temp = new StringBuilder();
//            temp.append(romanStr.charAt(i));
//            temp.append(romanStr.charAt(i+1));
//            if (romanMap.get(temp.toString()) != null) {
//                result += romanMap.get(temp.toString());
//                romanStr.delete(i, i+2);
//            }
//            else {
//                i++;
//            }
//            if (i >= romanStr.length()-1) {
//                break;
//            }
//        }
//        // 检索一位的罗马数字
//        for (int i = 0; i < romanStr.length(); i++) {
//            result += romanMap.get(String.valueOf(romanStr.charAt(i)));
//        }

        for (int i = 0; i < s.length(); i++) {
            String temp = "";
            if (i < s.length()-1) {
                temp = s.substring(i, i + 2);
            }
            if (romanMap.get(temp) != null) {
                result += romanMap.get(temp);
                i++;
            }
            else {
                result += romanMap.get(String.valueOf(s.charAt(i)));
            }
        }
        return result;
    }
    public static void main(String []args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
