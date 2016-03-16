package lintcode.linkedList;

// 链表划分
/**
 * 给定一个单链表和数值x，划分链表使得所有小于x的节点排在大于等于x的节点之前。 保留两部分内链表节点原有的相对顺序。
 * 
 * 给定链表 1->4->3->2->5->2->null，并且 x=3 返回 1->2->2->4->3->5->null
 * 
 */
public class Solution96e {

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode left = leftDummy, right = rightDummy;
        // 两个指针，left保存小于x的节点，right保存大于x的节点，最后left.next=rightDummy.next
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = head;
            } else {
                right.next = head;
                right = head;
            }
            head = head.next;
        }

        right.next = null;
        left.next = rightDummy.next;
        return leftDummy.next;
    }

}
