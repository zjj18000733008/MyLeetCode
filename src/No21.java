import java.util.List;

/**
 * 合并两个有序链表
 * @author JJ
 * @date 2020/7/16 - 17:10
 */
//public class No21 {

//    public static void main(String[] args) {
//        ListNode n1 = new ListNode(1, new ListNode(2, new ListNode(4)));
//        ListNode n2 = new ListNode(1, new ListNode(3, new ListNode(4)));
//        No21 no = new No21();
//        ListNode list = no.mergeTwoLists(n1, n2);
//    }
//
//    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
//        ListNode node1=l1;
//        ListNode node2=l2;
//        ListNode list=null;
//        ListNode temp=null;
//
//        if(node1==null && node2==null){
//            return null;
//        }else if(node1==null && node2!=null){
//            return node2;
//        } else if (node1 != null && node2 == null) {
//            return node1;
//        }
//
//        do{
//
//            if (node1.val <= node2.val) {
//                if(list==null){
//                    list=node1;
//                    temp=list;
//                }else{
//                    temp.next=node1;
//                    temp=temp.next;
//                }
//                node1=node1.next;
//            }else{
//                if(list==null){
//                    list=node2;
//                    temp=list;
//                }else{
//                    temp.next=node2;
//                    temp=temp.next;
//                }
//                node2=node2.next;
//            }
//        }while(node1!=null && node2!=null);
//
//        if(node1!=null){
//            temp.next=node1;
//            node1=node1.next;
//            temp=temp.next;
//        }
//        if(node2!=null){
//            temp.next=node2;
//            node2=node2.next;
//            temp=temp.next;
//        }
//        return list;
//    }
//}

//class ListNode{
//    int val;
//    ListNode next;
//    ListNode(){}
//    ListNode(int val){
//        this.val=val;
//    }
//    ListNode(int val,ListNode next){
//        this.val=val;
//        this.next=next;
//    }
//}
