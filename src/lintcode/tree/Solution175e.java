package lintcode.tree;

import java.util.Stack;

// 翻转二叉树
public class Solution175e {

    // 递归
    public void invertBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;

        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
    }

    // 非递归
    public void invertBinaryTree2(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            TreeNode tmp = cur.right;
            cur.right = cur.left;
            cur.left = tmp;

            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

}
