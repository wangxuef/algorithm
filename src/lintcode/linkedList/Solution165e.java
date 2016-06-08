package lintcode.linkedList;

// 合并两个排序链表
/**
 * 给出 1->3->8->11->15->null，2->null， 返回 1->2->3->8->11->15->null。
 * 
 */
public class Solution165e {

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode lastNode = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                lastNode.next = l1;
                l1 = l1.next;
            } else {
                lastNode.next = l2;
                l2 = l2.next;
            }
            
            lastNode = lastNode.next;
        }

        if (l1 != null) {
            lastNode.next = l1;
        } else {
            lastNode.next = l2;
        }

        return dummy.next;
    }
    
    // 递归实现
    public ListNode mergeTwoLists(ListNode list1,ListNode list2) {
        if(list1==null)
            return list2;
        if(list2==null){
            return list1;
        }
        
        ListNode mergeHead = null;
        if(list1.val < list2.val){
            mergeHead = list1;
            mergeHead.next = mergeTwoLists(list1.next, list2);
        }else{
            mergeHead = list2;
            mergeHead.next = mergeTwoLists(list1, list2.next);
        }
        return mergeHead;
    }

}
