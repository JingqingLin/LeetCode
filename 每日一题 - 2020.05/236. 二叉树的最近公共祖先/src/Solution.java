import java.util.HashSet;

public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static TreeNode p, q, commonNode;
    private static HashSet<TreeNode> nodeSet;

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Solution.p = p;
        Solution.q = q;
        nodeSet = new HashSet<>();
        commonNode = root;
        isOnPath(root);
        return commonNode;
    }

    private static boolean isOnPath(TreeNode node) {
        if (node == null) {
            return false;
        }
        boolean isOnPath = false;
        if (node == p || node == q) {
            if (nodeSet.contains(node)) {
                commonNode = node;
                return false;
            } else {
                nodeSet.add(node);
                isOnPath = true;
            }
        }
        boolean leftPath = isOnPath(node.left);
        if (leftPath) {
            if (nodeSet.contains(node)) {
                commonNode = node;
                return false;
            } else {
                nodeSet.add(node);
                isOnPath = true;
            }
        }
        boolean rightPath = isOnPath(node.right);
        if (rightPath) {
            if (nodeSet.contains(node)) {
                commonNode = node;
                return false;
            } else {
                nodeSet.add(node);
                return true;
            }
        }
        return isOnPath;
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
