package lintcode.linkedList;


// 翻转链表
public class Solution35e {
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    // 从头到尾遍历原链表，每遍历一个节点，将其摘下放在新链表的最前段， O(n)
    public ListNode reverse(ListNode head) {
        
        ListNode prev = null;
        ListNode cur = head;
        
        while (cur != null) {
            ListNode temp = cur; // 保存当前要处理的节点
            cur = cur.next;     // 跳到下一个节点
            temp.next = prev;
            prev = temp;
        }
        return prev;
    }
    
    // 递归
    public ListNode reverse2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode reHead = reverse2(head.next);
        head.next.next = head;
        head.next = null;
        return reHead;
    }

}
