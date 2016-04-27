package lintcode.tree;

import java.util.ArrayList;
import java.util.Stack;

import lintcode.tree.TreeNode;

// 二叉树的锯齿形层次遍历
/**
 * 给出一棵二叉树，返回其节点值的锯齿形层次遍历
 * （先从左往右，下一层再从右往左，层与层之间交替进行） 
 */
public class Solution71m {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if(root == null){
            return result;
        }
        
        // 出栈顺序是从左到右
        Stack<TreeNode> leftstack = new Stack<TreeNode>();
        leftstack.push(root);
        
        // 出栈顺序是从右到左
        Stack<TreeNode> rightstack = new Stack<TreeNode>();
        
        boolean left = true;
        
        while(!leftstack.empty() || !rightstack.empty()){
            ArrayList<Integer> list = new ArrayList<Integer>();
            
            if(left){
                int size = leftstack.size();
                for(int i=0; i<size; i++){
                    TreeNode node = leftstack.pop();
                    list.add(node.val);
                    if(node.left!=null){
                        rightstack.push(node.left);
                    }
                    if(node.right!=null){
                        rightstack.push(node.right);
                    }
                }
            }else{
                int size = rightstack.size();
                for(int i=0;i<size;i++){
                    TreeNode node = rightstack.pop();
                    list.add(node.val);
                    if(node.right!=null){
                        leftstack.push(node.right);
                    }
                    if(node.left!=null){
                        leftstack.push(node.left);
                    }
                }
            }
            
            left=!left;
            result.add(list);
        }
        return result;
    }  
}
