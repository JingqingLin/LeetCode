public class Solution {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        // 初始前缀为第一个字符串
        String result = strs[0];
        for(int i = 1; i < strs.length; i++) {
            // .indexOf(String): the index of the first occurrence of the specified substring
            while(strs[i].indexOf(result) != 0) {
                result = result.substring(0, result.length()-1);
                if(result.length() == 0) {
                    return "";
                }
            }
        }
        return result;
    }
    public static void main(String []args) {
        System.out.println(longestCommonPrefix(new String[]{"flooo", "floor", "floor"}));
    }
}
