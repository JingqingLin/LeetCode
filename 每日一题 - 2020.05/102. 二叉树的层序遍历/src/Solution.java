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

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> layerNode = new ArrayList<>();
            while (size-- > 0) {
                TreeNode temp = queue.poll();
                layerNode.add(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            res.add(layerNode);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(-1);
        A.left = new TreeNode(0);
        A.right = new TreeNode(3);
        A.left.left = new TreeNode(-2);
        A.left.left.left = new TreeNode(8);
        A.left.right = new TreeNode(4);
        System.out.println(levelOrder(A));
    }
}
