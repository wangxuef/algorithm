package lintcode.tree;


public class BST<T extends Comparable<T>> {
    
    private BSTNode<T> mRoot;    // 根结点
    
    public class BSTNode<T extends Comparable<T>>{
        T val;
        BSTNode<T> left;
        BSTNode<T> right;
        BSTNode<T> parent;
        
        public BSTNode(T val, BSTNode<T> parent, BSTNode<T> left, BSTNode<T> right){
            this.val = val;
            this.left = left;
            this.parent = parent;
            this.right = right;
        }
        
        public T getVal(){
            return val;
        }
        
        public String toString(){
            return "val:" + val;
        }
    }
    
    //前序遍历
    public void preOrder(BSTNode<T> root){
        if(root==null)
            return;
        System.out.println(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    //中序遍历
    public void inOrder(BSTNode<T> root){
        if(root==null)
            return;
        preOrder(root.left);
        System.out.println(root.val+" ");
        preOrder(root.right);
    }
    
    //后序遍历
    public void postOrder(BSTNode<T> root){
        if(root==null)
            return;
        preOrder(root.left);
        preOrder(root.right);
        System.out.println(root.val+" ");
    }
    
    // 查找 递归
    public BSTNode<T> searchRec(BSTNode<T> root, T target) {
        if(root==null)
            return null;
        
        int cmp = target.compareTo(root.val);
        if(cmp<0)
            return searchRec(root.left, target);
        else if(cmp>0)
            return searchRec(root.left, target);
        else 
            return root;
    }
    
    // 查找 非递归
    public BSTNode<T> search(BSTNode<T> root, T target){
        if(root==null)
            return null;
        
        while(root!=null){
            int cmp = target.compareTo(root.val);
            if(cmp<0)
                root = root.left;
            else if(cmp>0)
                root = root.right;
            else 
                return root;
        }
        
        return root;
    }
    
    //  查找最小节点
    public BSTNode<T> minimum(BSTNode<T> root){
        if(root==null)
            return null;
        
        while(root.left!=null)
            root = root.left;
        return root;
    }
    
    //  查找最大节点
    public BSTNode<T> maximum(BSTNode<T> root){
        if(root==null)
            return null;
        
        while(root.right!=null)
            root = root.right;
        return root;
    }
    
    // 找结点(x)的后继结点。即，查找二叉树中数据值大于该结点的最小结点
    public BSTNode<T> successor(BSTNode<T> x){
        // 如果x存在右孩子，则"x的后继结点"为 "以其右孩子为根的子树的最小结点"。
        if(x.right!=null)
            return minimum(x.right);
        
        // 如果x没有右孩子。则x有以下两种可能：
        // 1.x是"一个左孩子"，则"x的后继结点"为 "它的父结点"。
        // 2.x是"一个右孩子"，则查找"x的最低的父结点，并且该父结点要具有左孩子"，找到的这个"最低的父结点"就是"x的后继结点"。、
        
        BSTNode<T> y = x.parent;
        while((y!=null) && (x==y.right)){// 第二种可能(x是右孩子)，直到找到x是左孩子
            x = y;
            y = y.parent;
        }
        
        return y;
    }
    
    // 找结点(x)的前驱结点。即，查找二叉树中数据值小于该结点的最大结点
    public BSTNode<T> predecessor(BSTNode<T> x){
        // 如果x存在左孩子，则"x的前驱结点"为 "以其左孩子为根的子树的最大结点"
        if(x.left!=null)
            return maximum(x.left);
        
        // 如果x没有左孩子。则x有以下两种可能：
        // 1.x是"一个右孩子"，则"x的前驱结点"为 "它的父结点"。
        // 2.x是"一个左孩子"，则查找"x的最低的父结点，并且该父结点要具有右孩子"，找到的这个"最低的父结点"就是"x的前驱结点"。
        BSTNode<T> y = x.parent;
        while((y!=null) && (x==y.left)){
            x = y;
            y = y.parent;
        }
        
        return y;
    }
    
    
    
    
    
}
