import java.util.HashMap;
import java.util.LinkedHashMap;

public class Solution {
    public static String intToRoman(int num) {
        LinkedHashMap<Integer, String> romanMap = new LinkedHashMap<>();
        romanMap.put(1000,"M");
        romanMap.put(900,"CM");
        romanMap.put(500,"D");
        romanMap.put(400,"CD");
        romanMap.put(100,"C");
        romanMap.put(90,"XC");
        romanMap.put(50,"L");
        romanMap.put(40,"XL");
        romanMap.put(10,"X");
        romanMap.put(9,"IX");
        romanMap.put(5,"V");
        romanMap.put(4,"IV");
        romanMap.put(1,"I");
        String romanNumerals = "";
        for (Integer key : romanMap.keySet()) {
            int count = 0;
            if (num/key != 0) {
                count = num/key;
                num = num % key;
                for (int i = 0; i < count; i++) {
                    romanNumerals += romanMap.get(key);
                }
            }
        }
//        int digits = 1;
//        while (num != 0) {
////            System.out.printf("%d位余数：%d\n", digits, num%10);
//            if (num%10 < 4  && num%10 > 0) {
//                for (int i = 0; i < num%10; i++) {
//                    romanNumerals.insert(0, romanMap.get(digits));
//                }
//            }
//            else if (num%10 == 4) {
//                romanNumerals.insert(0, romanMap.get(5 * digits));
//                romanNumerals.insert(0, romanMap.get(digits));
//            }
//            else if (num%10 == 5) {
//                romanNumerals.insert(0, romanMap.get(5 * digits));
//            }
//            else if (num%10 < 9  && num%10 > 5) {
//                for (int i = 5; i < num%10; i++) {
//                    romanNumerals.insert(0, romanMap.get(digits));
//                }
//                romanNumerals.insert(0, romanMap.get(5 * digits));
//            }
//            else if (num%10 == 9) {
//                romanNumerals.insert(0, romanMap.get(10 * digits));
//                romanNumerals.insert(0, romanMap.get(digits));
//            }
//            num /= 10;
//            digits *= 10;
//        }
        return romanNumerals;
    }
    public static void main(String []args) {
        System.out.println(intToRoman(1994));
    }
}
