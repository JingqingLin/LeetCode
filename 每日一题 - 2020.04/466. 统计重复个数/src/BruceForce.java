public class BruceForce {
    public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        // i 为 s2 的索引
        int i = 0, num1 = 0, num2 = 0;
        while (num1 < n1) {
            for (char c : c1) {
                if (c == c2[i]) {
                    if (i == c2.length - 1) {
                        i = 0;
                        num2++;
                    } else {
                        i++;
                    }
                }
            }
            num1++;
        }
        return num2 / n2;
    }

    public static void main(String[] args) {
        System.out.println(getMaxRepetitions("abaacdbac", 100, "adcbd", 4));
    }
}
