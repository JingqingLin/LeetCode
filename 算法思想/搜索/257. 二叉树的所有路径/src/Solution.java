import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> pathList = new ArrayList<>();
        dfs(pathList, new StringBuilder(), root);
        return pathList;
    }

    private static void dfs(List<String> pathList, StringBuilder path, TreeNode root) {
        if (root != null) {
            path.append(root.val);
            if ((root.left == null) && (root.right == null)) {
                pathList.add(String.valueOf(path));
                return;
            }
            path.append("->");
            // 递归里 StringBuilder 作为参数时，指向相同的内存，而 String 不会这样？
            // 所以下方左子树递归返回后，要使 path 变为递归之前的内容
            int pathLen = path.length();
            dfs(pathList, path, root.left);
            path.delete(pathLen, path.length());

//            下面这种用法也可以，直接 new 在新的内存
//            dfs(pathList, new StringBuilder(path), root.left);
            dfs(pathList, path, root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println(binaryTreePaths(root));
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
