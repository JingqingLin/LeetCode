## 滑动窗口思想
例题中的 `abcabcbb`，窗口 `abc` 满足题目要求，当再进入 `a`，窗口变成了 `abca`，这时候不满足要求。所以要移动窗口。  

如何移动窗口？  

把队列的左边的元素移出 `bc`，再加入后方的 `a`。记录过程中的最大长度。   
时间复杂度：$O(n)$

参考：  
https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-dong-chuang-kou-by-powcai/