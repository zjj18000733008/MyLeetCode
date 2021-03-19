import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author JJ
 * @date 2020/7/27 - 20:02
 */
public class No107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        //用LinkedList方便头插数据
        LinkedList<List<Integer>> lists = new LinkedList<List<Integer>>();
        if(root==null) return lists;//如果root为空,返回[]
        Queue<TreeNode> queue=new LinkedList();//用来存取某一层的结点
        queue.add(root);
        while(!queue.isEmpty()){//每次循环,从队列中取出所有元素,将其val插入list中;然后将队列元素孩子入队
            ArrayList<Integer> list = new ArrayList<>();//用于存放每一层的结点的值
            int size=queue.size();
            //遍历队列queue中的所有结点
            for (int i = 0; i <size ; i++) {
                TreeNode node = queue.poll();
                //将当前结点的val存入list中
                list.add(node.val);
                //将当前节点的孩子结点存入队列中,以便下一次的循环使用
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            lists.addFirst(list);//头插,以使结果符合题目要求

        }
        return lists;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n1.left=n2;
        n1.right=n3;
        n3.left=n4;
        n3.right=n5;
        No107 no = new No107();
        List<List<Integer>> lists = no.levelOrderBottom(n1);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }



}
