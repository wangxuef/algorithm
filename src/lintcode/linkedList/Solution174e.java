package lintcode.linkedList;

// 删除链表中倒数第n个节点
// 返回链表的头节点	链表中的节点个数大于等于n
/**
 * 给出链表1->2->3->4->5->null和 n = 2. 删除倒数第二个节点之后，这个链表将变成1->2->3->5->null.
 * 
 */
public class Solution174e {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode preDelete = dummy;
        for (int i = 0; i < n; i++) { // 节点数小于n时return null
            if (head == null) {
                return null;
            }
            head = head.next;
        }

        while (head != null) {
            head = head.next;
            preDelete = preDelete.next;
        }

        preDelete.next = preDelete.next.next;
        return dummy.next;
    }

}
