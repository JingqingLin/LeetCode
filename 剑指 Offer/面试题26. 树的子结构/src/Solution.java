public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return isSubStructureWithRoot(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private static boolean isSubStructureWithRoot(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (A.val != B.val) {
            return false;
        }
        return isSubStructureWithRoot(A.left, B.left) && isSubStructureWithRoot(A.right, B.right);
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(3);
        A.right = new TreeNode(2);
        A.left.left = new TreeNode(4);
        A.left.right = new TreeNode(-3);
        TreeNode B = new TreeNode(3);
        B.left = new TreeNode(4);
        System.out.println(isSubStructure(A, B));
        //[2,3,2,1]
        //[3,null,2,2]
    }
}
