package lintcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 二叉树的层次遍历
// 返回结果为           ArrayList<ArrayList<Integer>>

public class Solution69m {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        if(root==null){
            return result;
        }
        
        int currentLevelNodes = 1;
        int nextLevelNodes = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            ArrayList<Integer> rst = new ArrayList<>();
            
            while(currentLevelNodes != 0){
                TreeNode cur = queue.remove();
                currentLevelNodes--;
                rst.add(cur.val);
                
                if(cur.left != null){
                    queue.add(cur.left);
                    nextLevelNodes++;
                }
                
                if(cur.right != null){
                    queue.add(cur.right);
                    nextLevelNodes++;
                }
            }
            if(currentLevelNodes == 0){
                currentLevelNodes = nextLevelNodes;
                nextLevelNodes = 0;
                result.add(rst);
            }
        }
        return result;
    }
    
}
