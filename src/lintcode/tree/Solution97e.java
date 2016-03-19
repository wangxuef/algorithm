package lintcode.tree;

import java.util.LinkedList;
import java.util.Queue;

//  二叉树的最大深度
public class Solution97e {
    // 递归
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // 非递归 层层遍历
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int level = 0;
        int currentLevelNode = 1;
        int nextLevelNode = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            currentLevelNode--;
            if (node.left != null) {
                queue.add(node.left);
                nextLevelNode++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLevelNode++;
            }

            if (currentLevelNode == 0) {
                level++;
                currentLevelNode = nextLevelNode;
                nextLevelNode = 0;
            }
        }
        return level;
    }

}
