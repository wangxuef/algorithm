package lintcode.tree;

// 在二叉查找树中插入节点
public class Solution85e {

    /**
     * 递归
     * @param root
     * @param node
     * @return
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if (root == null) {
            return node;
        }
        if (root.val >= node.val) {
            root.left = insertNode(root.left, node);
        }
        if (root.val < node.val) {
            root.right = insertNode(root.right, node);
        }
        return root;
    }

    /**
     * 非递归。根据二叉查找树的结构
     * @param root
     * @param node
     * @return
     */
    public TreeNode insertNode2(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }

        TreeNode cur = root;
        TreeNode last = null;

        while (cur != null) {
            last = cur;
            if (cur.val > node.val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }

        }

        if (last != null) {
            if (last.val > node.val) {
                last.left = node;
            } else {
                last.right = node;
            }
        }
        return root;
    }

}
