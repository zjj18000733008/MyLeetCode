/**
 * @author JJ
 * @date 2020/8/30 - 10:37
 */
public class No61 {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode fast = preHead, slow = preHead;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = preHead.next;
        preHead.next = slow.next;
        slow.next = null;
        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        No61 no = new No61();
        ListNode node = no.rotateRight(n1, 2);
    }
}

class No61_2 {//超时

    public ListNode rotateRight(ListNode head, int k) {
        ListNode node = null;
        if (head == null) return null;
        if (k == 0 || head.next == null) return head;
        for (int i = 0; i < k; i++) {
            node = ratateRight(head);
            head = node;
        }
        return node;
    }

    public ListNode ratateRight(ListNode head) {
        int k = 1;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode fast = preHead, slow = preHead;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = preHead.next;
        preHead.next = slow.next;
        slow.next = null;
        return preHead.next;
    }

    public static void main(String[] args) {
        No61_2 no = new No61_2();
//        ListNode n1 = new ListNode(0);
//        ListNode n2 = new ListNode(1);
//        ListNode n3 = new ListNode(2);
//        n1.next=n2;
//        n2.next=n3;
//        ListNode node = no.rotateRight(n1,4);
        ListNode n1 = new ListNode(1);
        ListNode node = no.rotateRight(n1, 1);
    }
}

class No61_3 {
    //执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
    //内存消耗：39.3 MB, 在所有 Java 提交中击败了75.87% 的用户
    public ListNode rotateRight(ListNode head, int k) {
        ListNode preHead = new ListNode(0);//在head前创建一个头结点
        preHead.next = head;
        ListNode fast = preHead, slow = preHead;
        if (head == null) return null;
        k = k % lenth(head);//k可能会超出链表的长度所以需要对其求模
        while (k > 0) {//快指针先走
            fast = fast.next;
            k--;
        }
        while (fast.next != null) {//快慢指针一起走
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = preHead.next;
        preHead.next = slow.next;
        slow.next = null;
        return preHead.next;
    }

    private int lenth(ListNode head) {//求链表的长度
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        No61 no = new No61();
        ListNode node = no.rotateRight(n1, 2);
    }
}