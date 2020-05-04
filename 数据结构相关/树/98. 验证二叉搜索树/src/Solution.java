public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        return recursion(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean recursion(TreeNode node, Long lower, Long upper) {
        if (node == null) {
            return true;
        }

        if (node.val <= lower || node.val >= upper) {
            return false;
        }

        if (!recursion(node.right, (long) node.val, upper) || !recursion(node.left, lower, (long) node.val)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(-1);
        System.out.println(isValidBST(root));
        // [10,5,15,null,null,6,20]
    }
}
