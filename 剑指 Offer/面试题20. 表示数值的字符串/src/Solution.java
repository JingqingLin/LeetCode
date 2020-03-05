public class Solution {
//  []  ： 字符集合
//  ()  ： 分组
//  ?   ： 重复 0 ~ 1 次
//  +   ： 重复 1 ~ n 次
//  *   ： 重复 0 ~ n 次
//  .   ： 任意字符
//  \\. ： 转义后的 .
//  \\d ： 数字
    public static boolean isNumber(String s) {
        if ("".equals(s.trim())) {
            return false;
        }
        return s.matches("\\s*[+-]?(\\.\\d+|\\d+\\.?\\d*)([eE][+-]?\\d+)?\\s*");
    }
    public static void main(String[] args) {
        System.out.println(isNumber("3."));
    }
}
