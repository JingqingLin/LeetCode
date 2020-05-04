import java.util.ArrayList;

public class Inorder {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static ArrayList<Integer> list;
    private static boolean result;

    public static boolean isValidBST(TreeNode root) {
        list = new ArrayList<>();
        result = true;
        inOrder(root);
        return result;
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (list.size() > 0) {
            if (list.get(list.size() - 1) >= root.val) {
                result = false;
            }
        }
        list.add(root.val);
        inOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(-1);
        System.out.println(isValidBST(root));
    }
}
