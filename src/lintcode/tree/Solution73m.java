package lintcode.tree;

import java.util.Arrays;

import lintcode.tree.TreeNode;

//  前序遍历和中序遍历树构造二叉树
public class Solution73m {
	
    /**
     * 前序遍历的第一个结点是root结点，
     * 再从中序遍历中找到这个root结点，则root左边的就是左子树，root右边的就是右子树
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = null;
        int[] leftPreorder;
        int[] rightPreorder;
        int[] leftInorder;
        int[] rightInorder;

        int preorderPos;
        int inorderPos;

        if (preorder.length != 0 && inorder.length != 0) {
            root = new TreeNode(preorder[0]);

            // 中序遍历 分成两个子树
            inorderPos = findPosition(inorder, 0, inorder.length - 1, preorder[0]);
            leftInorder = Arrays.copyOfRange(inorder, 0, inorderPos);
            rightInorder = Arrays.copyOfRange(inorder, inorderPos + 1, inorder.length);

            // 前序遍历分成两个子树
            preorderPos = leftInorder.length;
            leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + preorderPos);
            rightPreorder = Arrays.copyOfRange(preorder, 1 + preorderPos, preorder.length);

            root.left = buildTree(leftPreorder, leftInorder);
            root.right = buildTree(rightPreorder, rightInorder);
        }
        return root;
    }
    
    private int findPosition(int[] inorder, int istart, int iend, int r) {
        for (int i = istart; i <= iend; i++)
            if (inorder[i] == r)
                return i;
        return -1;
    }

}
