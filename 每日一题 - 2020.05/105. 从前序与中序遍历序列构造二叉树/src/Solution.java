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

    private static Map<Integer, Integer> inorderMap;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        int len = preorder.length;
        for (int i = 0; i < len; i++) {
            inorderMap.put(inorder[i], i);
        }
        TreeNode root;
        root = build(preorder, 0, len - 1, 0);
        return root;
    }

    private static TreeNode build(int[] preorder, int preL, int preR, int inL) {
        if (preL > preR) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preL]);
        int rootPos = inorderMap.get(preorder[preL]);
        int leftLen = rootPos - inL;
        root.left = build(preorder, preL + 1, preL + leftLen, inL);
        root.right = build(preorder, preL + leftLen + 1, preR, rootPos + 1);
        return root;
    }

    public static void main(String[] args) {
        buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
}
