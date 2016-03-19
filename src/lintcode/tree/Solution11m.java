package lintcode.tree;

import java.util.ArrayList;
import lintcode.tree.TreeNode;

//  二叉查找树中搜索区间
/**
 * 给定两个值 k1 和 k2（k1 < k2）和一个二叉查找树的根节点。
 * 找到树中所有值在 k1 到 k2 范围内的节点。
 * 即打印所有x (k1 <= x <= k2) 其中 x 是二叉查找树的中的节点值。返回所有升序的节点值。
 */
public class Solution11m {
    /*
     * 已经是二叉排序树了，中序遍历的结果就是升序的，然后在升序的序列中找到符合条件的部分节点就好了
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> inorder = inorderTraveral(root);
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < inorder.size(); i++) {
            int tmp = inorder.get(i);
            if (k1 <= tmp && tmp <= k2) {
                result.add(tmp);
            }
        }
        return result;
    }

    private ArrayList<Integer> inorderTraveral(TreeNode root) {
        ArrayList<Integer> inorder = new ArrayList<Integer>();
        if (root == null) {
            return inorder;
        }
        inorder.addAll(inorderTraveral(root.left));
        inorder.add(root.val);
        inorder.addAll(inorderTraveral(root.right));
        return inorder;
    }

}
