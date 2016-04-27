package lintcode.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * TODO: 一定要能熟练地写出所有问题的递归和非递归做法！
 * 
 * 1. 求二叉树中的节点个数: getNodeNumRec（递归），getNodeNum（迭代） 
 * 2. 求二叉树的深度: getDepthRec（递归），getDepth 
 * 3. 前序遍历，中序遍历，后序遍历: preorderTraversalRec, preorderTraversal, inorderTraversalRec, 
 * postorderTraversalRec (https://en.wikipedia.org/wiki/Tree_traversal#Pre-order_2)
 * 4.分层遍历二叉树（按层次从上往下，从左往右）: levelTraversal, levelTraversalRec（递归解法！） 
 * 5. 将二叉查找树变为有序的双向链表:
 * convertBST2DLLRec, convertBST2DLL 
 * 6. 求二叉树第K层的节点个数：getNodeNumKthLevelRec, getNodeNumKthLevel 
 * 7. 求二叉树中叶子节点的个数：getNodeNumLeafRec, getNodeNumLeaf 
 * 8. 判断两棵二叉树是否相同的树：isSameRec, isSame 
 * 9. 判断二叉树是不是平衡二叉树：isAVLRec 
 * 10. 求二叉树的镜像（破坏和不破坏原来的树两种情况）：mirrorRec, mirrorCopyRec 10.1判断两个树是否互相镜像：isMirrorRec 
 * 11. 求二叉树中两个节点的最低公共祖先节点：getLastCommonParent, getLastCommonParentRec, getLastCommonParentRec2 
 * 12. 求二叉树中节点的最大距离：getMaxDistanceRec 
 * 13. 由前序遍历序列和中序遍历序列重建二叉树：rebuildBinaryTreeRec 
 * 14. 判断二叉树是不是完全二叉树：isCompleteBinaryTree, isCompleteBinaryTreeRec
 */
public class BinaryTree {
    
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);

        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.right = r6;
    }

    /**
     * 求二叉树中的节点个数递归解法： O(n) 
     * （1）如果二叉树为空，节点个数为0 
     * （2）如果二叉树不为空，二叉树节点个数 = 左子树节点个数 + 右子树节点个数 + 1
     */
    public static int getNodeNumRec(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return getNodeNumRec(root.left) + getNodeNumRec(root.right) + 1;
        }
    }
    
    // 非递归
    public static int getNodeNum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node.left != null) {
                queue.add(node.left);
                count++;
            }
            if (node.right != null) {
                queue.add(node.right);
                count++;
            }
        }
        return count;
    }

    /**
     * 求二叉树的深度（高度） 递归解法： O(n) 
     * （1）如果二叉树为空，二叉树的深度为0 
     * （2）如果二叉树不为空，二叉树的深度 = max(左子树深度， 右子树深度) + 1
     */
    public static int getDepthRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepthRec(root.left);
        int right = getDepthRec(root.right);
        return Math.max(left, right) + 1;
    }

    public static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int level = 0;
        int currentLevelNode = 1;
        int nextLevelNode = 0;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            currentLevelNode--;
            if (node.left != null) {
                nextLevelNode++;
                queue.add(node.left);
            }
            if (node.right != null) {
                nextLevelNode++;
                queue.add(node.right);
            }

            if (currentLevelNode == 0) {
                level++;
                currentLevelNode = nextLevelNode;
                nextLevelNode = 0;
            }
        }
        return level;
    }

    /**
     * 前序遍历递归解法： 
     * （1）如果二叉树为空，空操作 
     * （2）如果二叉树不为空，访问根节点，前序遍历左子树，前序遍历右子树
     */
    public static void preorderTraversalRec(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preorderTraversalRec(root.left);
        preorderTraversalRec(root.right);
    }
    
    // 迭代
    public static void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            System.out.println(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 中序遍历递归解法 
     * （1）如果二叉树为空，空操作。 
     * （2）如果二叉树不为空，中序遍历左子树，访问根节点，中序遍历右子树
     */
    public static void inorderTraversalRec(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalRec(root.left);
        System.out.println(root.val);
        inorderTraversalRec(root.right);
    }
    
    // 迭代
    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty()) {
                break;
            }

            // 因为此时已经没有左孩子了，所以输出栈顶元素
            cur = stack.pop();
            System.out.println(cur.val);
            cur = cur.right;
        }
    }

    /**
     * 后序遍历递归解法 
     * （1）如果二叉树为空，空操作 
     * （2）如果二叉树不为空，后序遍历左子树，后序遍历右子树，访问根节点
     */
    public static void postorderTraversalRec(TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.println(root.val);
    }
    
    // 迭代
    public static void postorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> s = new Stack<TreeNode>(); // 第一个stack用于添加node和它的左右孩子
        Stack<TreeNode> output = new Stack<TreeNode>();// 第二个stack用于翻转第一个stack输出
        s.push(root);
        while (!s.isEmpty()) { // 确保所有元素都被翻转转移到第二个stack
            TreeNode cur = s.pop(); // 把栈顶元素添加到第二个stack
            output.push(cur);

            if (cur.left != null) { // 把栈顶元素的左孩子和右孩子分别添加入第一个stack
                s.push(cur.left);
            }
            if (cur.right != null) {
                s.push(cur.right);
            }
        }

        while (!output.isEmpty()) { // 遍历输出第二个stack，即为后序遍历
            System.out.print(output.pop().val + " ");
        }
    }

    /**
     * 分层遍历二叉树（递归） 很少有人会用递归去做level traversal 基本思想是用一个大的ArrayList，里面包含了每一层的ArrayList。
     * 大的ArrayList的size和level有关系
     * 
     * 这是我目前见到的最好的递归解法！
     * http://discuss.leetcode.com/questions/49/binary-tree-level-order-traversal#answer-container-
     * 2543
     */
    public static void levelTraversalRec(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        dfs(root, 0, ret);
        System.out.println(ret);
    }
    private static void dfs(TreeNode root, int level, ArrayList<ArrayList<Integer>> ret) {
        if (root == null) {
            return;
        }
        // 添加一个新的ArrayList表示新的一层
        if (level >= ret.size()) {
            ret.add(new ArrayList<Integer>());
        }
        ret.get(level).add(root.val); // 把节点添加到表示那一层的ArrayList里
        dfs(root.left, level + 1, ret); // 递归处理下一层的左子树和右子树
        dfs(root.right, level + 1, ret);
    }

    /**
     * 分层遍历二叉树（按层次从上往下，从左往右）迭代 相当于广度优先搜索，使用队列实现。
     * 队列初始化，将根节点压入队列。当队列不为空，进行如下操作：
     * 弹出一个节点，访问，若左子节点或右子节点不为空，将其压入队列
     */
    public static void levelTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.push(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.removeFirst();
            System.out.print(cur.val + " ");
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    
    
    /**
     * 二叉排序树（Binary Sort Tree）又称二叉查找树（Binary Search Tree），亦称二叉搜索树。
     * 
     * （1）若左子树不空，则左子树上所有结点的值均小于它的根结点的值； 
     * （2）若右子树不空，则右子树上所有结点的值均大于它的根结点的值； 
     * （3）左、右子树也分别为二叉排序树；
     * （4）没有键值相等的节点。
     */

    /**
     * 将二叉查找树变为有序的双向链表 要求不能创建新节点，只调整指针。 
     * 递归完，root会在链表的中间位置，因此要手动 把root移到链表头或链表尾
     */
    public static TreeNode convertBST2DLLRec(TreeNode root) {
        root = convertBST2DLLSubRec(root);
        while (root.left != null) {
            root = root.left; //把root移到链表头
        }
        return root;
    }
    private static TreeNode convertBST2DLLSubRec(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        TreeNode tmp = null;
        if (root.left != null) { // 处理左子树
            tmp = convertBST2DLLSubRec(root.left);
            while (tmp.right != null) { // 寻找最右节点
                tmp = tmp.right;
            }
            tmp.right = root; // 把左子树处理后结果和root连接
            root.left = tmp;
        }
        if (root.right != null) { // 处理右子树
            tmp = convertBST2DLLSubRec(root.right);
            while (tmp.left != null) { // 寻找最左节点
                tmp = tmp.left;
            }
            tmp.left = root; // 把右子树处理后结果和root连接
            root.right = tmp;
        }
        return root;
    }

    /**
     * 将二叉查找树变为有序的双向链表 迭代解法 类似inorder traversal的做法
     */
    public static TreeNode convertBST2DLL(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root; // 指向当前处理节点
        TreeNode old = null; // 指向前一个处理的节点
        TreeNode head = null; // 链表头

        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            if (stack.isEmpty()) {
                break;
            }

            cur = stack.pop();

            if (old != null) {
                old.right = cur;
            }
            if (head == null) {
                head = cur;
            }
            old = cur; // 更新old
            cur = cur.right;
        }
        return head;
    }

    
    /**
     * 求二叉树第K层的节点个数 递归解法： 
     * （1）如果二叉树为空或者k<1返回0 
     * （2）如果二叉树不为空并且k==1，返回1 
     * （3）如果二叉树不为空且k>1，返回root左子树中k-1层的节点个数与root右子树k-1层节点个数之和
     * 
     *  求以root为根的k层节点数目 == 
     *  求以root左孩子为根的k-1层（因为少了root那一层）节点数目  + 以root右孩子为根的k-1层（因为少了root那一层）节点数目
     *  
     *  所以遇到树，先把它拆成左子树和右子树，把问题降解
     */
    public static int getNodeNumKthLevelRec(TreeNode root, int k) {
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        int numLeft = getNodeNumKthLevelRec(root.left, k - 1);
        int numRight = getNodeNumKthLevelRec(root.right, k - 1);
        return numLeft + numRight;
    }

    /**
     * 求二叉树第K层的节点个数 迭代解法： 同getDepth的迭代解法
     */
    public static int getNodeNumKthLevel(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int i = 0;
        int currentLevelNodes = 1;
        int nextLevelNodes = 0;

        queue.add(root);
        while (!queue.isEmpty() && i < k) {
            TreeNode cur = queue.remove();
            currentLevelNodes--;
            if (cur.left != null) {
                queue.add(cur.left);
                nextLevelNodes++;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextLevelNodes++;
            }

            if (currentLevelNodes == 0) { // 说明已经遍历完当前层的所有节点
                currentLevelNodes = nextLevelNodes;
                nextLevelNodes = 0;
                i++;
            }
        }
        return currentLevelNodes;
    }

    
    /**
     * 求二叉树中叶子节点的个数（递归）
     */
    public static int getNodeNumLeafRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getNodeNumLeafRec(root.left) + getNodeNumLeafRec(root.right);
    }

    /**
     * 求二叉树中叶子节点的个数（迭代） 还是基于Level order traversal
     */
    public static int getNodeNumLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leafNodes = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
            if (cur.left == null && cur.right == null) {
                leafNodes++;
            }
        }
        return leafNodes;
    }

    
    /**
     * 判断两棵二叉树是否相同的树。 递归解法： 
     * （1）如果两棵二叉树都为空，返回真 
     * （2）如果两棵二叉树一棵为空，另一棵不为空，返回假
     * （3）如果两棵二叉树都不为空，如果对应的左子树和右子树都同构返回真，其他返回假
     */
    public static boolean isSameRec(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        } else if (r1 == null || r2 == null) {
            return false;
        }
        boolean leftRes = isSameRec(r1.left, r2.left);
        boolean rightRes = isSameRec(r1.right, r2.right);
        return leftRes && rightRes;
    }

    /**
     * 判断两棵二叉树是否相同的树（迭代） 遍历一遍即可，这里用preorder
     */
    public static boolean isSame(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        } else if (r1 == null || r2 == null) {
            return false;
        }

        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();

        s1.push(r1);
        s2.push(r2);

        while (!s1.isEmpty() && !s2.isEmpty()) {
            TreeNode node1 = s1.pop();
            TreeNode node2 = s2.pop();
            if (node2 == null && node1 == null) {
                continue;
            } else if (node1 != null && node2 != null && node1.val == node2.val) {
                s1.push(node1.right);
                s1.push(node1.left);
                s2.push(node2.right);
                s2.push(node2.left);
            } else {
                return false;
            }
        }
        return true;
    }

    
    /**
     * 判断二叉树是不是平衡二叉树 递归解法： 
     * （1）如果二叉树为空，返回真 
     * （2）如果二叉树不为空，如果左子树和右子树都是AVL树并且左子树和右子树高度相差不大于1，返回真，其他返回假
     */
    public static boolean isAVLRec(TreeNode root) {
        if (root == null) {
            return true;
        }

        // 如果左子树和右子树高度相差大于1，则非平衡二叉树, getDepthRec()是前面实现过的求树高度的方法
        if (Math.abs(getDepthRec(root.left) - getDepthRec(root.right)) > 1) {
            return false;
        }

        return isAVLRec(root.left) && isAVLRec(root.right);
    }

    
    /**
     * 求二叉树的镜像 递归解法： 
     * （1）如果二叉树为空，返回空 
     * （2）如果二叉树不为空，求左子树和右子树的镜像，然后交换左子树和右子树
     */
    // 1. 破坏原来的树，把原来的树改成其镜像
    public static TreeNode mirrorRec(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = mirrorRec(root.left);
        TreeNode right = mirrorRec(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    // 2. 不能破坏原来的树，返回一个新的镜像树
    public static TreeNode mirrorCopyRec(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode newNode = new TreeNode(root.val);
        newNode.left = mirrorCopyRec(root.right);
        newNode.right = mirrorCopyRec(root.left);
        return newNode;
    }

    // 3. 判断两个树是否互相镜像
    public static boolean isMirrorRec(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        }
        if (r1 == null || r2 == null) {
            return false;
        }

        if (r1.val != r2.val) {
            return false;
        }

        return isMirrorRec(r1.left, r2.right) && isMirrorRec(r1.right, r2.left);
    }

    /**
     * 求二叉树的镜像 非递归解法：
     * 
     */
    // 1. 破坏原来的树，把原来的树改成其镜像
    public static void mirror(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();

            TreeNode temp = cur.left;
            cur.right = cur.left;
            cur.left = temp;

            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    // 2. 不能破坏原来的树，返回一个新的镜像树
    public static TreeNode mirrorCopy(TreeNode root) {
        if (root == null) {
            return root;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> newStack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode newRoot = new TreeNode(root.val);
        newStack.push(newRoot);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            TreeNode newCur = newStack.pop();

            if (cur.right != null) {
                stack.push(cur.right);
                newCur.left = new TreeNode(cur.right.val);
                newStack.push(newCur.left);
            }
            if (cur.left != null) {
                stack.push(cur.left);
                newCur.right = new TreeNode(cur.left.val);
                newStack.push(newCur.right);
            }
        }
        return newRoot;
    }

    
    /**
     * 求二叉树中两个节点的最低公共祖先节点 递归解法： 
     * （1）如果两个节点分别在根节点的左子树和右子树，则返回根节点
     * （2）如果两个节点都在左子树，则递归处理左子树；如果两个节点都在右子树，则递归处理右子树
     */
    public static TreeNode getLastCommonParentRec(TreeNode root, TreeNode n1, TreeNode n2) {
        if (findNodeRec(root.left, n1)) { // 如果n1在树的左子树
            if (findNodeRec(root.right, n2)) { // 如果n2在树的右子树
                return root; // 返回根节点
            } else { // 如果n2也在树的左子树
                return getLastCommonParentRec(root.left, n1, n2);
            }
        } else { // 如果n1在树的右子树
            if (findNodeRec(root.left, n2)) { // 如果n2在左子树
                return root;
            } else { // 如果n2在右子树
                return getLastCommonParentRec(root.right, n1, n2);
            }
        }
    }

    // 帮助方法，递归判断一个点是否在树里
    private static boolean findNodeRec(TreeNode root, TreeNode node) {
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

    // 求二叉树中两个节点的最低公共祖先节点 （更加简洁版的递归）
    public static TreeNode getLastCommonParentRec2(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null) {
            return null;
        }

        if (root.equals(n1) || root.equals(n2)) {
            return root;
        }

        TreeNode commonLeft = getLastCommonParentRec2(root.left, n1, n2);
        TreeNode commonRight = getLastCommonParentRec2(root.right, n1, n2);

        if (commonLeft != null && commonRight != null) {
            return root;
        }

        if (commonLeft != null) {
            return commonLeft;
        }

        return commonRight;
    }

    /**
     * 求二叉树中两个节点的最低公共祖先节点 非递归解法： 
     * 先求从根节点到两个节点的路径，然后再比较对应路径的节点就行，最后一个相同的节点也就是他们在二叉树中的最低公共祖先节点
     */
    public static TreeNode getLastCommonParent(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null || n1 == null || n2 == null) {
            return null;
        }

        ArrayList<TreeNode> path1 = new ArrayList<TreeNode>();
        boolean res1 = getNodePath(root, n1, path1);
        ArrayList<TreeNode> path2 = new ArrayList<TreeNode>();
        boolean res2 = getNodePath(root, n1, path2);

        if (!res1 || !res2) {
            return null;
        }

        TreeNode last = null;
        Iterator<TreeNode> ite1 = path1.iterator();
        Iterator<TreeNode> ite2 = path2.iterator();

        while (ite1.hasNext() && ite2.hasNext()) {
            TreeNode tmp1 = ite1.next();
            TreeNode tmp2 = ite2.next();
            if (tmp1 == tmp2) {
                last = tmp1;
            } else {
                break;
            }
        }
        return last;
    }

    // 帮助方法 把从根节点到node路径上所有的点都添加到path中
    private static boolean getNodePath(TreeNode root, TreeNode node, ArrayList<TreeNode> path) {
        if (root == null) {
            return false;
        }

        path.add(root); // 把这个节点加到路径中
        if (root == node) {
            return true;
        }

        boolean found = false;
        found = getNodePath(root.left, node, path); // 先在左子树中找
        if (found == false) { // 如果没找到，再在右子树找
            found = getNodePath(root.right, node, path);
        }
        if (!found) { // 如果实在没找到证明这个节点不在路径中，说明刚才添加进去的不是路径上的节点，删掉！
            path.remove(root);
        }

        return found;
    }

    /**
     * 求二叉树中节点的最大距离 即二叉树中相距最远的两个节点之间的距离。 (distance / diameter) 递归解法：
     * （1）如果二叉树为空，返回0，同时记录左子树和右子树的深度，都为0 
     * （2）如果二叉树不为空，最大距离:
     *       要么是左子树中的最大距离，
     *       要么是右子树中的最大距离，
     *       要么是左子树节点中到根节点的最大距离+右子树节点中到根节点的最大距离， 同时记录左子树和右子树节点中到根节点的最大距离。
     * 
     * http://www.cnblogs.com/miloyip/archive/2010/02/25/1673114.html
     * 计算一个二叉树的最大距离有两个情况: 
     * 情况A: 路径经过左子树的最深节点，通过根节点，再到右子树的最深节点。 
     * 情况B: 路径不穿过根节点，而是左子树或右子树的最大距离路径，取其大者。
     * 只需要计算这两个情况的路径距离，并取其大者，就是该二叉树的最大距离
     */

    /**
     * 13. 由前序遍历序列和中序遍历序列重建二叉树（递归） 感觉这篇是讲的最为清晰的:
     * http://crackinterviewtoday.wordpress.com/2010/03/15/rebuild-a-binary-tree-from-inorder-and-
     * preorder-traversals/ 文中还提到一种避免开额外空间的方法，等下次补上
     */
    // 好牛逼！！！
    public static TreeNode rebuildBinaryTreeRec(List<Integer> preOrder, List<Integer> inOrder) {
        TreeNode root = null;
        List<Integer> leftPreOrder;
        List<Integer> rightPreOrder;
        List<Integer> leftInOrder;
        List<Integer> rightInOrder;
        int inorderPos;
        int preorderPos;

        if (preOrder.size() != 0 && inOrder.size() != 0) {
            root = new TreeNode(preOrder.get(0));

            inorderPos = inOrder.indexOf(preOrder.get(0)); // inorder序列的分割点
            leftInOrder = inOrder.subList(0, inorderPos);
            rightInOrder = inOrder.subList(inorderPos + 1, inOrder.size());

            preorderPos = leftInOrder.size();
            leftPreOrder = preOrder.subList(1, preorderPos + 1);
            rightPreOrder = preOrder.subList(preorderPos + 1, preOrder.size());
            
            // 前序遍历和中序遍历分别被分成两个子树，再对这两个子树分别递归重建
            // 递归    前序遍历子树+中序遍历子树
            root.left = rebuildBinaryTreeRec(leftPreOrder, leftInOrder);
            // 递归   
            root.right = rebuildBinaryTreeRec(rightPreOrder, rightInOrder);
        }
        return root;
    }

    /**
     * 14. 判断二叉树是不是完全二叉树（迭代） 。
     * 若设二叉树的深度为h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数， 第 h
     * 层所有的结点都连续集中在最左边，这就是完全二叉树。
     * 有如下算法，按层次（从上到下，从左到右）遍历二叉树，当遇到一个节点的左子树为空时，
     * 则该节点右子树必须为空，且后面遍历的节点左右子树都必须为空，否则不是完全二叉树。
     * 
     */
    public static boolean isCompleteBinaryTree(TreeNode root) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        boolean mustHaveNoChild = false;
        boolean result = true;

        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            if (mustHaveNoChild) { // 已经出现了有空子树的节点了，后面出现的必须为叶节点（左右子树都为空）
                if (cur.left != null || cur.right != null) {
                    result = false;
                    break;
                }
            } else {
                if (cur.left != null && cur.right != null) { // 如果左子树和右子树都非空，则继续遍历
                    queue.add(cur.left);
                    queue.add(cur.right);
                } else if (cur.left != null && cur.right == null) {// 如果左子树非空但右子树为空，说明已经出现空节点，之后必须都为空子树
                    mustHaveNoChild = true;
                    queue.add(cur.left);
                } else if (cur.left == null && cur.right != null) {// 如果左子树为空但右子树非空，说明这棵树已经不是完全二叉完全树！
                    result = false;
                    break;
                } else { // 如果左右子树都为空，则后面的必须也都为空子树
                    mustHaveNoChild = true;
                }
            }
        }
        return result;
    }

    /**
     * 14. 判断二叉树是不是完全二叉树（递归）
     * http://stackoverflow.com/questions/1442674/how-to-determine-whether-a-binary-tree-is-complete
     * 
     */
    public static boolean isCompleteBinaryTreeRec(TreeNode root) {
        return true;
    }
}
