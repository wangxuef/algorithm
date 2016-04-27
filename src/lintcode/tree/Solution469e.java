package lintcode.tree;

import java.util.ArrayList;
import java.util.List;

// 二叉树的所有路径
public class Solution469e {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        String path = "";
        paths(result, root, path);
        return result;
    }
    
    private void paths(List<String> result, TreeNode root, String path){
        if(root == null){
            return;
        }
        
        if(root.left == null && root.right == null){
            if(path == ""){
                path += root.val;
            }else{
                path = path + "->" + root.val;
            }
            result.add(path);
            return;
        }
        
        if(path == ""){
            path += root.val;
        }else{
            path = path + "->" + root.val;
        }
        
        paths(result, root.left, path);
        paths(result, root.right, path);
    }
    
}
