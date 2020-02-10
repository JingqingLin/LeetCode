import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> treeNodeList = new ArrayList<>();
        if (n == 0) {
            return treeNodeList;
        }
        return generateTrees(1, n);
    }

    private static List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> treeNodeList = new ArrayList<>();
        if (end - start + 1 == 0) {
            TreeNode root = null;
            treeNodeList.add(root);
            return treeNodeList;
        }
        if (end - start + 1 == 1) {
            treeNodeList.add(new TreeNode(start));
            return treeNodeList;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTreeNodeList = generateTrees(start, i - 1);
            List<TreeNode> rightTreeNodeList = generateTrees(i + 1, end);
            for (TreeNode l : leftTreeNodeList) {
                for (TreeNode r : rightTreeNodeList) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    treeNodeList.add(root);
                }
            }
        }
        return treeNodeList;
    }

    public static void main(String[] args) {
        List<TreeNode> treeNodeList = generateTrees(3);
    }
}
