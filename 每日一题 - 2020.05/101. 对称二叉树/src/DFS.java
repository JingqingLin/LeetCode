public class DFS {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return DFS(root.left, root.right);
    }

    private static boolean DFS(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        // 比较 p 的左子树与 q 的右子树是否对称，p 的右子树与 q 的左子树是否对称
        return DFS(p.left, q.right) && DFS(p.right, q.left);
    }

    public static void main(String[] args) {

    }
}
