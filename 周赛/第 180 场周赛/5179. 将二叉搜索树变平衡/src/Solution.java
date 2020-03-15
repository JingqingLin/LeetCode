import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static List<Integer> treeList;

    public static TreeNode balanceBST(TreeNode root) {
        treeList = new ArrayList<>();
        traverse(root);
        int nodeNum = treeList.size();
        int[] treeArray = new int[nodeNum];
        int i = 0;
        for (Integer node : treeList) {
            treeArray[i++] = node;
        }
        return buildBST(treeArray, 0, nodeNum - 1);
    }

    private static TreeNode buildBST(int[] treeArray, int l, int r) {
        if (l > r) {
            return null;
        }
        int m = l + (r - l) / 2;
        TreeNode root = new TreeNode(treeArray[m]);
        root.left = buildBST(treeArray, l, m - 1);
        root.right = buildBST(treeArray, m + 1, r);
        return root;
    }

    private static void traverse(TreeNode root) {
        if (root.left != null) {
            traverse(root.left);
        }
        treeList.add(root.val);
        if (root.right != null) {
            traverse(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(0);
        TreeNode newRoot = balanceBST(root);
        System.out.println(newRoot.left.right.val);
    }
}
