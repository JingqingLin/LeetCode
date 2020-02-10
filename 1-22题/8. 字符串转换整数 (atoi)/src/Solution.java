public class Solution {
    public static int myAtoi(String str) {
        // false -> true 开始转换
        // true -> false 停止转换
        boolean flagPre;
        boolean flag = false;
        boolean isMinus = false;
        long result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (' ' == str.charAt(i)) {
                flagPre = flag;
                flag = false;
            } else {
                flagPre = flag;
                flag = true;
            }

            if ((flagPre == false && flag == true) || flagPre & flag == true) {
                if ((flagPre == false && flag == true)) {
                    if ('-' == str.charAt(i)) {
                        isMinus = true;
                        continue;
                    } else if ('+' == str.charAt(i)) {
                        continue;
                    }
                }

                // 遇到其他字符，break 并输出之前的整数
                if (str.charAt(i) - '0' > 9 || str.charAt(i) - '0' < 0) {
                    break;
                }

                result = result * 10 + str.charAt(i) - '0';
                if (result > 2147483647) {
                    if (isMinus) {
                        return -2147483648;
                    } else {
                        return 2147483647;
                    }
                }
            }

            if (flagPre == true && flag == false) {
                break;
            }
        }
        if (isMinus) {
            result = -result;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi(" -987a.3"));
    }
}
