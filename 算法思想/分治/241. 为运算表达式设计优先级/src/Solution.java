import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // 若遇到运算符，则把表达式按此运算符分为左右两部分，再递归计算左右两部分
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                // 循环从 list 里取是因为左右两部分的表达式可能有多个结果
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                list.add(l + r);
                                break;
                            case '-':
                                list.add(l - r);
                                break;
                            case '*':
                                list.add(l * r);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
        if (list.size() == 0) {
            list.add(Integer.valueOf(input));
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(diffWaysToCompute("2-1-1"));
    }
}
