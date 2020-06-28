public class Solution2 {
    public static boolean equationsPossible(String[] equations) {
        int[] father = new int[26];
        for (int i = 0; i < 26; i++) {
            father[i] = i;
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                union(equation.charAt(0) - 'a', equation.charAt(3) - 'a', father);
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                if (findFather(equation.charAt(0) - 'a', father) == findFather(equation.charAt(3) - 'a', father)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int findFather(int x, int[] father) {
        // 由于 x 在下面的 while 中会变成根结点，因此先把原先的 x 保存一下
        int oriX = x;
        while (x != father[x]) {
            x = father[x];
        }
        // 下面把路径上的所有结点的 father 都改成根结点
        while (oriX != father[oriX]) {
            int temp = oriX;
            oriX = father[oriX];
            father[temp] = x;
        }

        return x;
    }

    private static void union(int x, int y, int[] father) {
        int faX = findFather(x, father);
        int faY = findFather(y, father);
        if (faX != faY) {
            father[faX] = faY;
        }
    }

    public static void main(String[] args) {
        System.out.println(equationsPossible(new String[]{"c==c", "b==d", "x!=z"}));
    }
}
