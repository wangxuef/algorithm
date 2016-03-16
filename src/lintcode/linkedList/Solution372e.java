package lintcode.linkedList;

// 在O(1)时间复杂度删除链表节点
/**
 * 给定一个单链表中的表头和一个等待被删除的节点(非表头或表尾)。 请在在O(1)时间复杂度删除该链表节点。并在删除该节点后，返回表头。
 * 
 * 链表中的每个节点结构都是一样的，所以我们可以把该节点的下一个节点的数据复制到该节点 ，然后删除下一个节点即可。
 * 
 */

public class Solution372e {
    public void deleteNode(ListNode node) {
        // write your code here
        node.val = node.next.val;
        node.next = node.next.next;
    }
    
}
