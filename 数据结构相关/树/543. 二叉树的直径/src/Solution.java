public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static int maxPath;

    /** 某个结点，左子树和右子树的深度相加最大 */
    public static int diameterOfBinaryTree(TreeNode root) {
        maxPath = 0;
        DFS(root);
        return maxPath;
    }

    private static int DFS(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = 1 + DFS(root.left);
        int rightHeight = 1 + DFS(root.right);
        maxPath = Math.max(maxPath, leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(4);
        System.out.println(diameterOfBinaryTree(root));
    }
}
