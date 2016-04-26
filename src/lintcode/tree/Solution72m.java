package lintcode.tree;

import java.util.Arrays;

import lintcode.tree.TreeNode;

//  中序遍历和后序遍历树构造二叉树
public class Solution72m {
	
	/**
	 * 后序遍历的最后一个结点是root结点，
	 * 再从中序遍历中找到这个root结点，则root左边的就是左子树，root右边的就是右子树
	 * @param preorder
	 * @param inorder
	 * @return
	 */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	TreeNode root = null;
    	int[] leftPostorder;
    	int[] rightPostorder;
    	int[] leftInorder;
    	int[] rightInorder;
    	
    	int postorderPos;
    	int inorderPos;
    	
    	if(inorder.length != 0 && postorder.length != 0){
    		root = new TreeNode(postorder[postorder.length-1]);
    		
    		// 中序遍历 分成两个子树
    		inorderPos = findPosition(inorder, postorder[postorder.length-1]);
    		leftInorder = Arrays.copyOfRange(inorder, 0, inorderPos);
    		rightInorder = Arrays.copyOfRange(inorder, inorderPos+1, inorder.length);
    		
    		// 后序遍历分成两个子树
    		postorderPos = leftInorder.length;
    		leftPostorder = Arrays.copyOfRange(postorder, 0, postorderPos);
    		rightPostorder = Arrays.copyOfRange(postorder, postorderPos, postorder.length-1);
    		
    		root.left = buildTree(leftInorder, leftPostorder);
    		root.right = buildTree(rightInorder, rightPostorder);
    	}
    	return root;
    }
    
    private int findPosition(int[] arr, int r){
        for(int i=0;i<=arr.length;i++)
            if(arr[i] == r)
                return i;
        return -1;
    }

}
