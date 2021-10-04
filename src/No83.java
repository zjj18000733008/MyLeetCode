import org.junit.Test;

import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * @author JJ
 * @date 2020/7/27 - 17:47
 */
public class No83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        int cr = head.val;
        ListNode node = head;
        while (node.next != null) {
            if (node.next.val == cr) {
                node.next = node.next.next;
            } else {
                cr = node.next.val;
                node = node.next;
            }
        }
        return head;
    }

    /**
     * @author JJ
     * @date 2020/11/17 17:34
     */
    public ListNode deleteDuplicates_2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode root = new ListNode(0);
        ListNode preNode = head;
        ListNode curNode = head.next;
        int x = head.val;
        root.next = head;

        while (curNode != null) {
            if (curNode.val == x) {
                preNode.next = curNode.next;
                curNode = curNode.next;
            } else {
                x = curNode.val;
                preNode = curNode;
                curNode = curNode.next;
            }
        }
        return root.next;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：37.8 MB, 在所有 Java 提交中击败了89.85% 的用户
     *
     * @author JJ
     * @date 2020/11/17 18:08
     */
    public ListNode deleteDuplicates_3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preNode = head;
        ListNode curNode = head.next;
        int x = head.val;

        while (curNode != null) {
            if (curNode.val == x) {
                curNode = curNode.next;
                preNode.next = curNode;
            } else {
                curNode = curNode.next;
                preNode = preNode.next;
                x = preNode.val;
            }
        }
        return head;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：37.9 MB, 在所有 Java 提交中击败了45.75% 的用户
     * @param head
     * @return
     */
    public ListNode deleteDuplicates4(ListNode head) {

        ListNode root = new ListNode(0);
        root.next = head;

        if (head == null || head.next == null) {
            return head;
        }

        ListNode p1 = head;
        ListNode p2 = head.next;

        while (p2 != null) {
            if (p1.val == p2.val) {
                p1.next = p2.next;
                p2 = p2.next;
            } else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }



        return root.next;
    }

    @Test
    public void test() {
        deleteDuplicates4(ListNodeUtils.arrayToListNode(new int[]{1,1,2,3,3}));
    }

    public static void main(String[] args) {
        No83 no = new No83();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        no.deleteDuplicates(n1);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}