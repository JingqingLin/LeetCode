import java.util.HashMap;

public class Solution {
    public static String intToRoman(int num) {
        HashMap<Integer, Character> romanMap = new HashMap<>();
        romanMap.put(1,'I');
        romanMap.put(5,'V');
        romanMap.put(10,'X');
        romanMap.put(50,'L');
        romanMap.put(100,'C');
        romanMap.put(500,'D');
        romanMap.put(1000,'M');
        StringBuilder romanNumerals = new StringBuilder();
        int digits = 1;
        while (num != 0) {
//            System.out.printf("%d位余数：%d\n", digits, num%10);
            if (num%10 < 4  && num%10 > 0) {
                for (int i = 0; i < num%10; i++) {
                    romanNumerals.insert(0, romanMap.get(digits));
                }
            }
            else if (num%10 == 4) {
                romanNumerals.insert(0, romanMap.get(5 * digits));
                romanNumerals.insert(0, romanMap.get(digits));
            }
            else if (num%10 == 5) {
                romanNumerals.insert(0, romanMap.get(5 * digits));
            }
            else if (num%10 < 9  && num%10 > 5) {
                for (int i = 5; i < num%10; i++) {
                    romanNumerals.insert(0, romanMap.get(digits));
                }
                romanNumerals.insert(0, romanMap.get(5 * digits));
            }
            else if (num%10 == 9) {
                romanNumerals.insert(0, romanMap.get(10 * digits));
                romanNumerals.insert(0, romanMap.get(digits));
            }
            num /= 10;
            digits *= 10;
        }
        return romanNumerals.toString();
    }
    public static void main(String []args) {
        System.out.println(intToRoman(900));
    }
}
