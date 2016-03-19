package lintcode.tree;

// 等价二叉树
public class Solution480e {

    public boolean isIdentical(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        return (a.val == b.val) && isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
    }
}
