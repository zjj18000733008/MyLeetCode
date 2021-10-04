import java.util.ArrayList;
import java.util.List;

/**
 * @author JJ
 * @date 2021/3/22 - 16:45
 */
public class NC45 {

    public static void main(String[] args) {
        NC45 nc45 = new NC45();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left=n2;
        n1.right=n3;
        int[][] ans = nc45.threeOrders(n1);
        for (int[] an : ans) {
            for (int i : an) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    /**
     * 运行时间：30ms
     * 超过81.42%用Java提交的代码
     * 占用内存：12076KB
     * 超过64.81%用Java提交的代码
     * @author JJ
     * @date 2021/3/22 17:10
     */
    public int[][] threeOrders(TreeNode root) {

        ArrayList<Integer> preList=new ArrayList();
        ArrayList<Integer> inList=new ArrayList();
        ArrayList<Integer> postList=new ArrayList();

        preOrder(root,preList);
        inOrder(root,inList);
        postOrder(root,postList);
        int[][] ans=new int[3][preList.size()];
        for (int i = 0; i < preList.size(); i++) {
            ans[0][i]=preList.get(i);
        }
        for (int i = 0; i < inList.size(); i++) {
            ans[1][i]=inList.get(i);
        }
        for (int i = 0; i < postList.size(); i++) {
            ans[2][i]=postList.get(i);
        }

        return ans;
    }

    public void preOrder(TreeNode root,ArrayList<Integer> list) {

        if(root==null){
            return;
        }

        list.add(root.val);
        preOrder(root.left,list);
        preOrder(root.right,list);
    }

    public void inOrder(TreeNode root,ArrayList<Integer> list) {
        if(root==null){
            return;
        }
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }

    public void postOrder(TreeNode root,ArrayList<Integer> list) {

        if(root==null){
            return ;
        }

        postOrder(root.left,list);
        postOrder(root.right,list);
        list.add(root.val);
    }
}
