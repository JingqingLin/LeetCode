public class BetterSolution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static TreeNode commonNode;

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        commonNode = null;
        dfs(root, p, q);
        return commonNode;
    }

    private static boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            commonNode = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(-1);
        A.left = new TreeNode(0);
        A.right = new TreeNode(3);
        A.left.left = new TreeNode(-2);
        A.left.left.left = new TreeNode(8);
        A.left.right = new TreeNode(4);
        System.out.println(lowestCommonAncestor(A, A.left.left.left, A.left.right).val);
    }
}
