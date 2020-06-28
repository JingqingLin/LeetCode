public class Solution {
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
        while (x != father[x]) {
            x = father[x];
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
