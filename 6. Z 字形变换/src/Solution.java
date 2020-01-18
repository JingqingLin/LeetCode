public class Solution {
    public static String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        else {
            StringBuilder []temp = new StringBuilder[numRows];
            for (int i = 0; i < numRows; i++) {
                temp[i] = new StringBuilder();
            }
            int gap = numRows * 2 - 2;
            // j = numrows + 斜线位置的字母个数
            for (int j = 0; j < gap; j++) {
                int count = 0;
                for (int i = 0; i < s.length(); i++) {
                    if (i%gap == j) {
                        // 先插入竖直位置的字母
                        if (j < numRows) {
                            temp[j].insert(i / gap, s.charAt(i));
                        }
                        // 后插入斜线位置的字母
                        else {
                            temp[gap - j].insert(i / gap + 1 + count, s.charAt(i));
                            count++;
                        }
                    }
                }
            }
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < numRows; i++) {
                result.append(temp[i]);
            }
            return String.valueOf(result);
        }
    }
    public static void main(String []args) {
        System.out.println(convert("LEETCODEISHIRING", 3));
    }
}
