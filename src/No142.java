import java.util.HashMap;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author JJ
 * @date 2020/8/30 - 23:04
 */
public class No142 {
    /**
     * 快慢指针如果在环的同一点开始走(快指针每次走2步,慢指针每次走1步),
     * 设环的周长为b,走过的圈数为n,那么当快慢指针再次相遇时,相遇位置还是在起点此时走过nb步
     * <p>
     * <p>
     * 1.第一次相遇，slow = nb
     * 2.a+nb = 入口点
     * 3.slow再走a = 入口 = head走到入口 = a
     * 4.由3得出，起始距离入口 = 第一次相遇位置 + a
     * 感觉就是数学公式推导+逻辑结合的一道题
     *
     * @param head
     * @return
     */
    //执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
    //内存消耗：39.7 MB, 在所有 Java 提交中击败了77.25% 的用户
    public ListNode detectCycle(ListNode head) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode fast = preHead, slow = preHead;
        do {
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            slow = slow.next;
        } while (fast != null && fast != slow);
        if (fast == null) {
            return null;
        } else {//fast==slow
            fast = preHead;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        No142 no = new No142();
        ListNode node = no.detectCycle(n1);
        System.out.println(node.val);
    }

    public ListNode detectCycle2(ListNode head) {
        ListNode p1 = head;
        HashSet<ListNode> set = new HashSet<>();

        while (p1 != null) {
            if (set.contains(p1)) {
                return p1;
            }
            set.add(p1);
            p1 = p1.next;
        }
        return null;
    }

    @Test
    public void test() {
        ListNode head = ListNodeUtils.arrayToListNode(new int[] {3, 2, 0, -4});
        head.next.next.next.next=head.next;
        ListNode listNode = detectCycle2(head);
        Assert.assertEquals(2, listNode.val);

    }
}
