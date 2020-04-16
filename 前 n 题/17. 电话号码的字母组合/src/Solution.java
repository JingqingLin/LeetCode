// 递归

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static List<String> letterCombinations(String digits) {
        HashMap<Character, String> buttonMap = new HashMap<>();
        buttonMap.put('2', "abc");
        buttonMap.put('3', "def");
        buttonMap.put('4', "ghi");
        buttonMap.put('5', "jkl");
        buttonMap.put('6', "mno");
        buttonMap.put('7', "pqrs");
        buttonMap.put('8', "tuv");
        buttonMap.put('9', "wxyz");
        List<String> list = new ArrayList<>();
        if (digits.length() == 0) {
            return list;
        }
        list.add("");
        return addButton(0, digits, list, buttonMap);
    }

    private static List<String> addButton(int index, String subString, List<String> list, HashMap<Character, String> map) {
        List<String> newList = new ArrayList<>();
        String temp;
        // temp 存储传入index（拨号键）对应的字符串
        if (map.get(subString.charAt(index)) != null) {
            temp = map.get(subString.charAt(index));
        } else {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < temp.length(); i++) {
            // 对 List 内的每个字母增加当前拨号键对应的字母
            for (String l : list) {
                String str = l + temp.charAt(i);
                newList.add(str);
            }
        }
        if (index == subString.length() - 1) {
            return newList;
        }
        return addButton(index + 1, subString, newList, map);
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("2"));
    }
}
