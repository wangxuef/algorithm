package lintcode.linkedList;

// 链表插入排序
/**
 * 用插入排序对链表排序
 * 
 */
public class Solution173e {
	
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        // 这个dummy的作用是，把head开头的链表一个个的插入到dummy开头的链表里

        while (head != null) {
            ListNode node = dummy;
            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }
            ListNode temp = head.next;
            head.next = node.next;	//插入
            node.next = head;
            head = temp;	// 跳到下一个
        }
        return dummy.next;
    }
    
}
