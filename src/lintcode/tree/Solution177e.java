package lintcode.tree;

// 把排序数组转换为高度最小的二叉搜索树

// 给一个排序数组（从小到大），将其转换为一棵高度最小的排序二叉树。     
// 这个二叉树 中序遍历即为排序数组
public class Solution177e {

    // 把排序数组转换为二叉搜索树
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null) {
            return null;
        }
        return buildTree(num, 0, num.length - 1);
    }

    // 这样就是高度最小的
    private TreeNode buildTree(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode node = new TreeNode(num[(start + end) / 2]);
        node.left = buildTree(num, start, (start + end) / 2 - 1);
        node.right = buildTree(num, (start + end) / 2 + 1, end);
        return node;
    }

}
