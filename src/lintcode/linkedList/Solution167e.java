package lintcode.linkedList;

// 链表求和
/**
 * 你有两个用链表代表的整数，其中每个节点包含一个数字。数字存储按照在原来整数中相反的顺序，
 * 使得第一个数字位于链表的开头。写出一个函数将两个整数相加，用链表形式返回和。
 * 
 * 给出两个链表 3->1->5->null 和 5->9->2->null，返回 8->0->8->null
 * 513+295，即head为个位数
 * 
 */
public class Solution167e {
	
    public ListNode addLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }
            
        ListNode head = new ListNode(0);
        ListNode point = head;
        int carry = 0;	// 进位
        
        while(l1 != null && l2!=null){
            int sum = carry + l1.val + l2.val;
            point.next = new ListNode(sum % 10);	//本位上的数
            carry = sum / 10;	// 进位
            l1 = l1.next;
            l2 = l2.next;
            point = point.next;
        }
        
        while(l1 != null) {
            int sum =  carry + l1.val;
            point.next = new ListNode(sum % 10);
            carry = sum /10;
            l1 = l1.next;
            point = point.next;
        }
        
        while(l2 != null) {
            int sum =  carry + l2.val;
            point.next = new ListNode(sum % 10);
            carry = sum /10;
            l2 = l2.next;
            point = point.next;
        }
        
        if (carry != 0) {
            point.next = new ListNode(carry);
        }
        return head.next;
    }
    
}
