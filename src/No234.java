/**
 * @author JJ
 * @date 2020/8/1 - 19:44
 */
public class No234 {

    //执行用时：1 ms, 在所有 Java 提交中击败了99.71% 的用户
    //内存消耗：43.7 MB, 在所有 Java 提交中击败了19.05% 的用户
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;

        //当fast为空时,对应的slow位置即为后一半链表的首位置
        while (fast != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
        }
        //反转后一半链表
        pre.next = reverse(slow);
        ListNode mid = pre.next;
        //比较
        while (mid != null) {
            if (head.val != mid.val) {
                return false;
            }
            head = head.next;
            mid = mid.next;
        }

        return true;
    }

    public ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(2);
        ListNode n6 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        No234 no = new No234();
        boolean palindrome = no.isPalindrome(n1);
        System.out.println(palindrome);
    }

}
