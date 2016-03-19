package lintcode.tree;

import java.util.ArrayList;
import java.util.Stack;

// Binary Tree Inorder Traversal
// 二叉树的中序遍历

/**
 * 先左，再根，再右
 * 
 */
public class Solution67e {
    /**
     * 中序遍历迭代解法 ，用栈先把根节点的所有左孩子都添加到栈内， 然后输出栈顶元素，再处理栈顶元素的右子树
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeNode curt = root;
        while (curt != null || !stack.empty()) {
            while (curt != null) {
                stack.push(curt); // 先左！！
                curt = curt.left;
            }
            curt = stack.peek();
            stack.pop();
            result.add(curt.val);
            curt = curt.right;
        }
        return result;
    }

    /**
     * 中序遍历递归解法 （1）如果二叉树为空，空操作。 （2）如果二叉树不为空，中序遍历左子树，访问根节点，中序遍历右子树
     */
    public ArrayList<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }

        ArrayList<Integer> left = inorderTraversal2(root.left);
        ArrayList<Integer> right = inorderTraversal2(root.right);

        result.addAll(left);
        result.add(root.val);
        result.addAll(right);
        return result;
    }

}
