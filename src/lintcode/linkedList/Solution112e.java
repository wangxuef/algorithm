package lintcode.linkedList;

// 删除排序链表中的重复元素
/**
 * 删除所有重复的元素每个元素只留下一个
 * 给出1->1->2->3->3->null，返回 1->2->3->null
 * 
 */
public class Solution112e {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }

}
