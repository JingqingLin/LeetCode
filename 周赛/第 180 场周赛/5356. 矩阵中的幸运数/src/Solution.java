import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int minCol = findMin(matrix, i);
            if (i == findMax(matrix, minCol)) {
                list.add(matrix[i][minCol]);
            }
        }
        return list;
    }

    private static int findMax(int[][] matrix, int j) {
        int max = Integer.MIN_VALUE;
        int row = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][j] > max) {
                max = matrix[i][j];
                row = i;
            }
        }
        return row;
    }

    private static int findMin(int[][] matrix, int i) {
        int min = Integer.MAX_VALUE;
        int col = 0;
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[i][j] < min) {
                min = matrix[i][j];
                col = j;
            }
        }
        return col;
    }

    public static void main(String[] args) {
        System.out.println(luckyNumbers(new int[][]{{3,7,8},{9,11,13},{15,16,17}}));
    }
}
