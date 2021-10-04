import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * @author JJ
 * @date 2021/3/22 - 17:14
 */
public class NC14 {

    ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
    Stack<TreeNode> stack1=new Stack();//存奇数
    Stack<TreeNode> stack2=new Stack();//存偶数
    int count=1;//记录当前是第几层

//    public static void main(String[] args) {
//        NC14 nc14 = new NC14();
//        TreeNode n1 = new TreeNode(3);
//        TreeNode n2 = new TreeNode(9);
//        TreeNode n3 = new TreeNode(20);
//        TreeNode n4 = new TreeNode(15);
//        TreeNode n5 = new TreeNode(7);
//        n1.left=n2;
//        n1.right=n3;
//        n2.left=n4;
//        n2.right=n5;
//        ArrayList<ArrayList<Integer>> lists = nc14.zigzagLevelOrder(n1);
//        for (ArrayList<Integer> list : lists) {
//            for (Integer i : list) {
//                System.out.print(i+" ");
//            }
//            System.out.println();
//        }
//    }

    /**
     * 运行时间：45ms
     * 超过32.74%用Java提交的代码
     * 占用内存：10896KB
     * 超过54.07%用Java提交的代码
     * @author JJ
     * @date 2021/3/22 19:55
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {

        if(root==null){
            return lists;
        }

        stack1.add(root);
        zigzagLevelOrder();

        return lists;
    }
    public void zigzagLevelOrder () {

        if(stack1.size()==0 && stack2.size()==0){
            return;
        }

        ArrayList<Integer> list = new ArrayList<>();
        if(count%2==1){//奇数行
            while(stack1.size()!=0){//取出奇数层的stack中的所有元素
                TreeNode node = stack1.pop();
                //先左后右
                if(node.left!=null){
                    stack2.push(node.left);
                }
                if(node.right!=null){
                    stack2.push(node.right);
                }

                list.add(node.val);
            }

        }else{
            while(stack2.size()!=0){
                TreeNode node = stack2.pop();
                //先右后左
                if(node.right!=null){
                    stack1.push(node.right);
                }
                if(node.left!=null){
                    stack1.push(node.left);
                }

                list.add(node.val);
            }
        }
        lists.add(list);
        count++;
        zigzagLevelOrder();
    }

}
