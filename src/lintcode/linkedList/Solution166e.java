package lintcode.linkedList;

// 链表倒数第n个节点
/**
 * 找到单链表倒数第n个节点，保证链表中节点的最少数量为n。
 * 
 */
public class Solution166e {
	
    public ListNode nthToLast(ListNode head, int n) {
    	ListNode p1 = head;
    	ListNode p2 = head;
    	
    	while(n>0){
    		p1 = p1.next;
    		n--;
    	}
    	
    	while(p1!=null){
    		p1 = p1.next;
    		p2 = p2.next;
    	}
    	
    	return p2;
    }
}
