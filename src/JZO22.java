import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie
 * @Date: 2021/10/19
 */
public class JZO22 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：36.3 MB, 在所有 Java 提交中击败了52.89% 的用户
     *
     * 定义快慢指针, 快指针先走k步, 然后快慢指针一起走, 当快指针走到头意味着慢指针就在倒数第k位
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head,int k){

        ListNode root=new ListNode(0);
        root.next=head;

        ListNode fast=root;
        ListNode slow=root;

        while (k > 0) {
            fast=fast.next;
            k--;
        }
        while (fast != null) {
            fast=fast.next;
            slow=slow.next;
        }

        return slow;
    }

    @Test
    public void test(){

        ListNode kthFromEnd = getKthFromEnd(ListNodeUtils.arrayToListNode(new int[] {1, 2, 3, 4, 5}), 2);
        System.out.println(kthFromEnd.val);
    }
}
