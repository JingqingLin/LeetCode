public class JosephusProblem {
    public static int lastRemaining(int n, int m) {
        if (n == 1) {
            return 0;
        }
        // p 为下一轮中最后一个结点的编号。最后一个结点：最后被删除的结点
        int p = lastRemaining(n - 1, m);
        return (m % n + p) % n;
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(5, 3));
    }
}
