public class Greedy {
    public static int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int remainder = n % 3;
        int quotient = n / 3;
        switch (remainder) {
            case 0:
                return (int) Math.pow(3, quotient);
            case 1:
                return (int) Math.pow(3, quotient - 1) * 4;
            case 2:
                return (int) Math.pow(3, quotient) * 2;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(8));
    }
}
