import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie
 * @Date: 2021/11/2
 */
public class JZO25 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了30.37% 的用户
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode pre = root;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                pre.next = l2;
                l2 = l2.next;
            } else {
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }

        while (l1 != null) {
            pre.next=l1;
            l1=l1.next;
            pre=pre.next;
        }
        while (l2 != null) {
            pre.next=l2;
            l2=l2.next;
            pre=pre.next;
        }
        return root.next;
    }

    @Test
    public void test(){
        ListNode listNode = mergeTwoLists(ListNodeUtils.arrayToListNode(new int[] {1, 2, 4}),
                ListNodeUtils.arrayToListNode(new int[] {1, 3, 4}));

    }
}
