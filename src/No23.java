/**
 * @author JJ
 * @date 2021/4/3 - 21:13
 */
public class No23 {

    public static void main(String[] args) {
        ListNode ln1 = ListNodeUtils.arrayToListNode(new int[]{1, 4, 5});
        ListNode ln2 = ListNodeUtils.arrayToListNode(new int[]{1, 3, 4});
        ListNode ln3 = ListNodeUtils.arrayToListNode(new int[]{2, 6});
        ListNode[] lists = new ListNode[3];
        lists[0] = ln1;
        lists[1] = ln2;
        lists[2] = ln3;
        No23 no = new No23();
        ListNode node = no.mergeKLists(lists);
        System.out.println(ListNodeUtils.printList(node));
    }

    /**
     * 执行用时：315 ms, 在所有 Java 提交中击败了6.90% 的用户
     * 内存消耗：40.2 MB, 在所有 Java 提交中击败了54.74% 的用户
     * @author JJ
     * @date 2021/4/3 22:22
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int len = 0;
        if ((len = lists.length) == 0) return null;

//        ListNode[] starts = new ListNode[len];

        boolean flag = false;
        ListNode root = null;
        ListNode node = null;
//        int min=Integer.MAX_VALUE;

        do {
            ListNode min = new ListNode(Integer.MAX_VALUE);
            int index = 0;
            flag = false;
            for (int i = 0; i < len; i++) {
                if (lists[i] != null) {
                    flag = true;
                } else {
                    continue;
                }

                if (lists[i].val < min.val) {
                    index = i;
                    min = lists[i];
                }
            }
            if (lists[index] != null) {
                lists[index] = lists[index].next;
            }
            if(flag){
                if (node != null) {
                    node.next = min;
                    node = node.next;
                } else {
                    root = min;
                    node = min;
                }
            }
            min.next = null;
        } while (flag);

        return root;
    }
}
