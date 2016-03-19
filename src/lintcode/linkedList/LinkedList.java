package lintcode.linkedList;

import java.util.Stack;

/**
 * 链表总结
 * @author wxf
 */

public class LinkedList {
    private static class Node {
        int val;

        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println();
    }

    // 节点个数
    public static int getListLength(Node head) {
        if (head == null)
            return 0;

        int len = 0;
        Node cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;

    }

    // 翻转
    public static Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node reHead = null; // 翻转后新链表指针
        Node cur = head;
        while (cur != null) {
            Node preCur = cur; // 保存要翻转的节点
            cur = cur.next; // 处理下一个
            preCur.next = reHead;
            reHead = preCur;
        }
        return reHead;
    }

    // 递归 翻转
    public static Node reverseListRec(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node reHead = reverseListRec(head.next);
        head.next.next = head;
        head.next = null;
        return reHead;
    }

    /**
     * 查找单链表中的倒数第K个结点（k > 0） 最普遍的方法是，先统计单链表中结点的个数，然后再找到第（n-k）个结点。注意链表为空，k为0，k为1，k大于链表中节点个数时的情况
     * 。时间复杂度为O（n）。代码略。 这里主要讲一下另一个思路，这种思路在其他题目中也会有应用。 主要思路就是使用两个指针，先让前面的指针走到正向第k个结点 ,
     * 这样前后两个指针的距离差是k-1，之后前后两个指针一起向前走，前面的指针走到最后一个结点时，后面指针所指结点就是倒数第k个结点
     */
    public static Node reGetKthNode(Node head, int k) {
        if (k == 0 || head == null) {
            return null;
        }

        Node q = head;
        Node p = head;

        while (k > 1 && q != null) { // q正序指向k-1，即第k个节点
            q = q.next;
            k--;
        }

        if (k > 1 && q == null) // k大于节点数
            return null;

        while (q.next != null) { // 前后两个指针一起走，q走到最后一个节点时，p指向倒数第k个
            q = q.next;
            p = p.next;
        }

        return p;
    }

    /**
     * 递归 输出倒数第k个的值
     */
    static int level = 0;

    public static void reGetKthNodeRec(Node head, int k) {
        if (head == null) {
            return;
        }
        if (k == 0) {
            return;
        }

        reGetKthNodeRec(head.next, k);
        level++;
        if (level == k) {
            System.out.println(head.val);
        }
    }

    // 查找单链表的中间结点
    /**
     * 此题可应用于上一题类似的思想。也是设置两个指针，只不过这里是，两个指针同时向前走，前面的指针每次走两步，后面的指针每次走一步，
     * 前面的指针走到最后一个结点时，后面的指针所指结点就是中间结点，即第（n/2+1）个结点。注意链表为空，链表结点个数为1和2的情况。时间复杂度O（n
     */
    public static Node getMiddleNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node q = head;
        Node p = head;

        while (q.next != null) {
            q = q.next;
            p = p.next;
            if (q.next != null) {
                q = q.next;
            }
        }
        return p;
    }

    /**
     * 从尾到头打印单链表 对于这种颠倒顺序的问题，我们应该就会想到栈，后进先出。所以，这一题要么自己使用栈，要么让系统使用栈，也就是递归。注意链表为空的情况 。时间复杂度为O（n）
     */
    public static void reversePrintListStack(Node head) {
        Stack<Node> s = new Stack<Node>();
        Node cur = head;

        while (cur != null) {
            s.push(cur);
            cur = cur.next;
        }

        while (!s.empty()) {
            cur = s.pop();
            System.out.println(cur.val);
        }
    }

    public static void reversePrintListRec(Node head) {
        if (head == null) {
            return;
        }

        reversePrintListRec(head.next);
        System.out.println(head.val);
    }

    /**
     * 已知两个单链表pHead1 和pHead2 各自有序，把它们合并成一个链表依然有序
     * 这个类似归并排序。尤其注意两个链表都为空，和其中一个为空时的情况。只需要O（1）的空间。时间复杂度为O（max(len1, len2)）
     */
    public static Node merageSortedList(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        Node mergeHead = null;
        // 先确定下来mergeHead是在哪里
        if (head1.val < head2.val) {
            mergeHead = head1;
            head1 = head1.next; // 跳过已经合并了的元素
            mergeHead.next = null; // 断开mergeHead和后面的联系
        } else {
            mergeHead = head2;
            head2 = head2.next;
            mergeHead.next = null;
        }

        Node mergeCur = mergeHead;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                mergeCur.next = head1;
                head1 = head1.next;
                mergeCur = mergeCur.next;
                mergeCur.next = null;
            } else {
                mergeCur.next = head2;
                head2 = head2.next;
                mergeCur = mergeCur.next;
                mergeCur.next = null;
            }
        }

        // 合并剩余的元素
        if (head1 != null) {
            mergeCur = head1;
        } else if (head2 != null) {
            mergeCur = head2;
        }

        return mergeHead;
    }

    /**
     * 递归合并两链表（优雅！）
     */
    public static Node mergeSortedListRec(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        Node mergeHead = null;
        if (head1.val < head2.val) {
            mergeHead = head1;
            mergeHead.next = mergeSortedListRec(head1.next, head2);
        } else {
            mergeHead = head2;
            mergeHead.next = mergeSortedListRec(head1, head2.next);
        }
        return mergeHead;

    }

    /**
     * 判断一个单链表中是否有环 这里也是用到两个指针。如果一个链表中有环，也就是说用一个指针去遍历，是永远走不到头的。因此，我们可以用两个指针去遍历，一个指针一次走两步
     * ，一个指针一次走一步，如果有环，两个指针肯定会在环中相遇。时间复杂度为O（n）
     */
    public static boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    // 判断两个单链表是否相交
    /**
     * 如果两个链表相交于某一节点，那么在这个相交节点之后的所有节点都是两个链表所共有的。 也就是说，如果两个链表相交，那么最后一个节点肯定是共有的。
     * 先遍历第一个链表，记住最后一个节点，然后遍历第二个链表， 到最后一个节点时和第一个链表的最后一个节点做比较，如果相同，则相交，
     * 否则不相交。时间复杂度为O(len1+len2)，因为只需要一个额外指针保存最后一个节点地址， 空间复杂度为O(1)
     */
    public static boolean isIntersect(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return false;
        }

        Node tail1 = head1;
        while (tail1.next != null) {
            tail1 = tail1.next;
        }

        Node tail2 = head2;
        while (tail2.next != null) {
            tail2 = tail2.next;
        }

        return tail1 == tail2;
    }

    /**
     * 求两个单链表相交的第一个节点 对第一个链表遍历，计算长度len1，同时保存最后一个节点的地址。
     * 对第二个链表遍历，计算长度len2，同时检查最后一个节点是否和第一个链表的最后一个节点相同，若不相同，不相交，结束。 两个链表均从头节点开始，假设len1大于len2
     * ，那么将第一个链表先遍历len1-len2个节点，此时两个链表当前节点到第一个相交节点的距离就相等了，然后一起向后遍历，直到两个节点的地址相同。 时间复杂度，O(len1+len2)
     */
    public static Node getFirstCommonNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        int len1 = 1;
        Node tail1 = head1;
        while (tail1.next != null) {
            tail1 = tail1.next;
            len1++;
        }

        int len2 = 1;
        Node tail2 = head2;
        while (tail2.next != null) {
            tail2 = tail2.next;
            len2++;
        }

        if (tail1 != tail2) {
            return null;
        }

        Node n1 = head1;
        Node n2 = head2;
        if (len1 > len2) {
            int k = len1 - len2;
            while (k != 0) {
                n1 = n1.next;
                k--;
            }
        } else {
            int k = len2 - len1;
            while (k != 0) {
                n2 = n2.next;
                k--;
            }
        }

        // 一起向后遍历，直到找到交点
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    /**
     * 求进入环中的第一个节点 用快慢指针做（本题用了Crack the Coding Interview的解法，因为更简洁易懂！）
     */

    /**
     * 给出一单链表头指针head和一节点指针toBeDeleted，O(1)时间复杂度删除节点tBeDeleted 对于删除节点，我们普通的思路就是让该节点的前一个节点指向该节点的下一个节点
     * ，这种情况需要遍历找到该节点的前一个节点，时间复杂度为O(n)。对于链表， 链表中的每个节点结构都是一样的，所以我们可以把该节点的下一个节点的数据复制到该节点
     * ，然后删除下一个节点即可。要注意最后一个节点的情况，这个时候只能用常见的方法来操作，先找到前一个节点，但总体的平均时间复杂度还是O(1)
     */
    public static void delete(Node head, Node toDelete) {
        if (toDelete == null) {
            return;
        }

        if (toDelete.next != null) {
            toDelete.val = toDelete.next.val;
            toDelete.next = toDelete.next.next;
        } else {
            if (head == toDelete) {
                head = null;
            } else {
                Node nod = head;
                while (nod.next != toDelete) {
                    nod = nod.next;
                }
                nod.next = null;
            }
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        // printList(n1);
        // System.out.println(getListLength(n1));
        // printList(reverseListRec(n1)); // 测试翻转链表
        // printList(reGetKthNode(n1, 1));
        // reGetKthNodeRec(n1,3);
        // printList(getMiddleNode(n1));
        // reversePrintListStack(n1);
        reversePrintListRec(n1);
    }
}
