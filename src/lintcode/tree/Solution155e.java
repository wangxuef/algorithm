package lintcode.tree;

import java.util.LinkedList;

// 二叉树的最小深度

//给定一个二叉树，找出其最小深度。二叉树的最小深度为根节点到最近叶子节点的距离。
public class Solution155e {
    
    // 遍历
    public int minDepth2(TreeNode root) {
        if (root == null)
            return 0;

        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> counts = new LinkedList<Integer>();
        nodes.add(root);
        counts.add(1);
        while (!nodes.isEmpty()) {
            TreeNode curr = nodes.poll();
            int count = counts.poll();
            if (curr.left != null) {
                nodes.add(curr.left);
                counts.add(count + 1);
            }
            if (curr.right != null) {
                nodes.add(curr.right);
                counts.add(count + 1);
            }
            if (curr.left == null && curr.right == null)
                return count;
        }
        return 0;
    }

    // 递归
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null)
            return minDepth(root.right) + 1;
        if (root.right == null)
            return minDepth(root.left) + 1;

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

}
