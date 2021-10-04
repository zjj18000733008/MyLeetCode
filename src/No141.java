import jdk.nashorn.internal.runtime.linker.LinkerCallSite;

/**
 * 给定一个链表，判断链表中是否有环。
 *
 * @author JJ
 * @date 2020/7/30 - 10:25
 */
public class No141 {

    public boolean hasCycle(ListNode head) {
        /*
        java双指针 fast一次走两个，slow走一个，当两个相遇则有环
         */
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：39.5 MB, 在所有 Java 提交中击败了52.70% 的用户
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {

        if (head == null || head.next==null) {
            return false;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
