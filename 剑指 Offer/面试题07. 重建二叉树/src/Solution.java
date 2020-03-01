import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /** 缓存中序遍历数组每个值对应的索引，方便找到根结点的位置 */
    private static Map<Integer, Integer> indexForInOrders = new HashMap<>();

    public static TreeNode buildTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            indexForInOrders.put(in[i], i);
        }
        return buildTree(pre, 0, pre.length - 1, 0);
    }

    private static TreeNode buildTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        // 根结点在中序数组的位置
        int inIndex = indexForInOrders.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = buildTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = buildTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }

    public static void main(String[] args) {
        buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
//        前序遍历 preorder = [3,9,20,15,7]
//        中序遍历 inorder = [9,3,15,20,7]

        // 1 2
        // 1 2 没有左子树
        // 1 2
        // 2 1 没有右子树
    }
}
