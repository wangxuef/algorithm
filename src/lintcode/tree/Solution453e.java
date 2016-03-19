package lintcode.tree;

// 将二叉树拆成链表

/**
 * 将一棵二叉树按照前序遍历拆解成为一个假链表。 所谓的假链表是说，用二叉树的 right 指针，来表示链表中的 next 指针。
 */
public class Solution453e {
    
    TreeNode lastNode = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        if (lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }

        lastNode = root;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }

}
