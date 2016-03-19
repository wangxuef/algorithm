package lintcode.tree;

import java.util.ArrayList;
import lintcode.tree.TreeNode;

//  二叉树的序列化和反序列化

/**
 * 以将二叉树序列化为一个字符串，并且可以将字符串反序列化为原来的树结构
 */
public class Solution7m {
	
    public String serialize(TreeNode root) {
        // write your code here
        if( root == null)
            return "{}";
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        // 将二叉树的个节点按照从上到下、从左到有的存储在queue中
        for(int i=0;i<queue.size();i++){
            TreeNode q = queue.get(i);
            if(q== null)
                continue;
            queue.add(q.left);
            queue.add(q.right);
        }
        // 去除叶子节点的左右孩子，这个孩子是空值
        while(queue.get(queue.size() - 1) == null){
            queue.remove(queue.size() - 1);
        }
        // 遍历queue把转换成字符串
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(queue.get(0).val);
        for(int i=1;i<queue.size(); i++){
            TreeNode q = queue.get(i);
            if(q!= null){
                sb.append(",");
                sb.append(q.val);
            }else{
                sb.append(",#");
            }
        }
        sb.append("}");
        return sb.toString();
    }
    
    
    public TreeNode deserialize(String data) {
        // write your code here
        if(data == "{}")
            return null;
        // 以逗号分割
        String[] vals = data.substring(1,data.length()-1).split(",");
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        // 根节点 
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        int index = 0;
        boolean isLeftChild = true;
        for (int i = 1; i < vals.length; i++) {
            if (!vals[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                if (isLeftChild) {
                    queue.get(index).left = node;
                } else {
                    queue.get(index).right = node;
                }
                queue.add(node);
            }
            if (!isLeftChild) {
                index++;
            }
            isLeftChild = !isLeftChild;
        }
        return root;
    }
    
}
