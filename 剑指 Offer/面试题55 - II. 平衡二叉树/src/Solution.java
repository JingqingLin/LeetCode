public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static int maxDiff;

    public static boolean isBalanced(TreeNode root) {
        maxDiff = Integer.MIN_VALUE;
        DFS(root);
        return maxDiff <= 1;
    }

    private static int DFS(TreeNode root) {
        if (root == null) {
            return 1;
        }
        int leftHeight = DFS(root.left) + 1;
        int rightHeight = DFS(root.right) + 1;
        if (leftHeight > rightHeight) {
            maxDiff = Math.max(maxDiff, leftHeight - rightHeight);
            return leftHeight;
        } else {
            maxDiff = Math.max(maxDiff, rightHeight - leftHeight);
            return rightHeight;
        }
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(3);
        A.right = new TreeNode(2);
        A.left.left = new TreeNode(4);
        A.left.right = new TreeNode(-3);
        A.left.left.left = new TreeNode(6);
        System.out.println(isBalanced(A));
    }
}
