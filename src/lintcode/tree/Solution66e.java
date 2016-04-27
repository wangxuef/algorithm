package lintcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Binary Tree Preorder Traversal
// 二叉树的前序遍历
/*
 * 根--左--右
 * 
 */
public class Solution66e {

    // 遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> preorder = new ArrayList<Integer>();

        if (root == null) {
            return preorder;
        }

        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            preorder.add(node.val);
            if (node.right != null) { // 先压入右孩子，再压入左孩子
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return preorder;
    }

    // 递归
    public ArrayList<Integer> preorderTraversal1(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        traverse(root, result);
        return result;
    }

    // 把root为根的 preorder 加入result里面
    private void traverse(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }
    
    // 递归
    public ArrayList<Integer> preorderTraversal2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // null or leaf
        if (root == null) {
            return result;
        }

        // Divide
        ArrayList<Integer> left = preorderTraversal2(root.left);
        ArrayList<Integer> right = preorderTraversal2(root.right);

        // Conquer
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        return result;
    }

}
