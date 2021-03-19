/**
 * @author JJ
 * @date 2020/7/30 - 10:46
 */
public class No160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /**
         定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部,
         最后如果相遇则为交点(在第一轮移动中恰好抹除了两链表的长度差)
         两个指针等于移动了相同的距离, 有交点就返回,
         无交点就是各走了两条指针的长度,最后两指针都为null,退出循环
         **/
        if(headA==null || headB==null)return null;
        ListNode pa=headA;
        ListNode pb=headB;
        while(pa!=pb){
            pa=pa==null?headB:pa.next;
            pb=pb==null?headA:pb.next;
        }
        return pa;
    }
}
