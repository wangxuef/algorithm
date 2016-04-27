package lintcode.tree;

//最近公共祖先
public class Solution88m {
	// 递归寻找--
	/**
	 * A 在左，B在右---return root
	 * A 在左，B在左---递归到root的left
	 * A 在右，B在左---return root
	 * A 在右， B在右---递归到root的right
	 * @param root
	 * @param A
	 * @param B
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
		// 如果A在树的左子树
    	if(findNodeRec(root.left, A)){
    		if(findNodeRec(root.right, B)){
    			return root;
    		}else{
    			return lowestCommonAncestor(root.left, A, B);
    		}
    	}else{// 如果A在树的左子树
    		if(findNodeRec(root.left, B)){
    			return root;
    		}else{
    			return lowestCommonAncestor(root.right, A, B);
    		}
    	}
    }
    
    /**
     * 递归判断一个结点是不是在一个树里
     * @param root
     * @param node
     * @return
     */
    private boolean findNodeRec(TreeNode root, TreeNode node){
        if (root == null || node == null) {
            return false;
        }
        if (root == node) {
            return true;
        }
        boolean found = findNodeRec(root.left, node);
        if (!found) {
            found = findNodeRec(root.right, node);
        }
        return found;
    }

}
