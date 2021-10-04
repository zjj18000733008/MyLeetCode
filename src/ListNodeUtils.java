/**
 * @author JJ
 * @date 2021/4/3 - 21:39
 */
public class ListNodeUtils {

    public static ListNode arrayToListNode(int[] arr){
        if(arr.length==0){
            return null;
        }
        ListNode preNode=new ListNode(arr[0]);
        ListNode root=preNode;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            preNode.next=node;
            preNode=node;
        }
        return root;
    }

    public static String printList(ListNode node){
        StringBuilder sb = new StringBuilder();
        ListNode tempNode=node;
        if(node==null){
            return "";
        }

        while(tempNode!=null){
            sb.append(tempNode.val+"->");
            tempNode=tempNode.next;
        }
        return sb.substring(0,sb.length()-2);
    }
}
