import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author JJ
 * @date 2020/8/29 - 21:09
 */
public class No106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        int len = postorder.length;
        TreeNode parent = new TreeNode(postorder[len - 1]);
        if(len==1)return parent;
        for (int i = 0; i < postorder.length; i++) {
            if (postorder[len - 1] == inorder[i]) {
                parent.left = buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
                parent.right = buildTree(Arrays.copyOfRange(inorder, i + 1, len), Arrays.copyOfRange(postorder, i, len - 1));
            }
        }
        return parent;
    }
}
class No106_2{

    int post_ix;
    int[] inorder;
    int[] postorder;
    Map<Integer,Integer> map=new HashMap<>();

    //执行用时：3 ms, 在所有 Java 提交中击败了72.86% 的用户
    //内存消耗：40.1 MB, 在所有 Java 提交中击败了49.77% 的用户
    public TreeNode buildTree(int[] inorder,int[] postorder){
        this.inorder=inorder;
        this.postorder=postorder;
        this.post_ix=postorder.length-1;
        int index=0;
        for (int i : inorder) {
            map.put(i,index++);
        }

        return helper(0,postorder.length-1);
    }

    public TreeNode helper(int left ,int right){
        if(left > right )return null;
        TreeNode parent = new TreeNode(postorder[post_ix]);
        Integer index = map.get(postorder[post_ix]);
        post_ix--;
        //必须是先右再左
        parent.right=helper(index+1,right);
        parent.left=helper(left,index-1);
        return parent;
    }

}