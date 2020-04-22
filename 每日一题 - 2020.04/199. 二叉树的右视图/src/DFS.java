import java.util.ArrayList;
import java.util.List;

public class DFS {
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        DFS(list, root, 0);
        return list;
    }

    private static void DFS (List<Integer> list, TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (list.size() == level) {
            list.add(node.val);
        }
        DFS(list, node.right, level + 1);
        DFS(list, node.left, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(4);
        System.out.println(rightSideView(root));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
