 # [面试题04](https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/). 二维数组中的查找
 从右上角开始找，若 `target` 小于此数 `col - 1`，大于则 `row + 1`  
<img src="https://cdn.jsdelivr.net/gh/JingqingLin/ImageHosting/img/35a8c711-0dc0-4613-95f3-be96c6c6e104.gif" width=50%/>

# 面试题06
也是链表反转问题

# ⭐[面试题07. 重建二叉树](https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/)
> 思路很清晰，代码不熟（下次再写一遍）  
> 要记录子树在先序和中序数组中的范围

    前序遍历 preorder = [3,9,20,15,7]
    中序遍历 inorder = [9,3,15,20,7]    
        3
       / \
      9  20
        /  \
       15   7

<img src="https://cdn.jsdelivr.net/gh/JingqingLin/ImageHosting/img/60c4a44c-7829-4242-b3a1-26c3b513aaf0.gif" width="430px"/>

# 面试题09. 用两个栈实现队列
> 摘自力扣：  
> 使用java的同学请注意，如果你使用Stack的方式来做这道题，会造成速度较慢； 这个原因的话是因为Stack继承了Vector接口，而Vector底层是AbstractList，是一个数组，那么就要考虑空间扩容的问题了。 可以使用LinkedList来做Stack的容器，因为LinkedList实现了Deque接口，所以Stack能做的事LinkedList都能做，其本身结构是个链表，扩容消耗少。 但是我的意思不是像100%代码那样直接使用一个List当做队列，那确实是快=，但是不符题意。 贴上代码，这样的优化之后，效率提高了40%，超过97%。