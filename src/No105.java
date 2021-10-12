import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author JJ
 * @date 2020/8/29 - 13:07
 */
public class No105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        TreeNode parent = new TreeNode(preorder[0]);
        if (preorder.length == 1) return parent;
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                TreeNode left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                TreeNode right = buildTree(Arrays.copyOfRange(preorder, 1 + i, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
                parent.left = left;
                parent.right = right;
            }
        }
        return parent;
    }

    public static void main(String[] args) {
        No105 no = new No105();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = no.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

    /**
     * 执行用时：15 ms, 在所有 Java 提交中击败了5.65% 的用户
     * 内存消耗：87.3 MB, 在所有 Java 提交中击败了5.03% 的用户
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {

        if (preorder == null || preorder.length==0) {
            return null;
        }

        TreeNode parent = new TreeNode(preorder[0]);

        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i]==preorder[0]){
                //找到左子节点
                TreeNode left =
                        buildTree2(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                //找到右子节点
                TreeNode right = buildTree2(Arrays.copyOfRange(preorder, i + 1, preorder.length),
                        Arrays.copyOfRange(inorder, i + 1,
                                inorder.length));
                parent.left=left;
                parent.right=right;
            }
        }

        return parent;
    }

}

class No105_2 {
    /**
     * 执行用时：10 ms, 在所有 Java 提交中击败了13.44% 的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了65.35% 的用户
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        return func(preorder, 0, preorder.length , inorder, 0, inorder.length );
    }

    private TreeNode func(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
        if(pend-pstart==0)return null;
        TreeNode parent = new TreeNode(preorder[pstart]);
        if (pend-pstart == 1) return parent;
        for (int i = istart; i < iend; i++) {
            if (preorder[pstart] == inorder[i]) {
                TreeNode left = func(preorder, pstart+1, i -istart+pstart+1, inorder, istart, i);
                TreeNode right = func(preorder, i -istart+pstart+1, pend, inorder, i + 1, iend);
                parent.left = left;
                parent.right = right;
            }
        }
        return parent;
    }

    public static void main(String[] args) {
        No105 no = new No105();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = no.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }
}

class No105_3{
    int pre_ix;
    int[] inorder;
    int[] preorder;
    Map<Integer,Integer> map=new HashMap<>();

    //执行用时：2 ms, 在所有 Java 提交中击败了98.09% 的用户
    //内存消耗：39.9 MB, 在所有 Java 提交中击败了81.14% 的用户
    public TreeNode buildTree(int[] preorder,int[] inorder){
        this.inorder=inorder;
        this.preorder=preorder;
        this.pre_ix=0;
        int index=0;
        for (int i : inorder) {
            map.put(i,index++);
        }

        return helper(0,preorder.length-1);
    }

    public TreeNode helper(int left ,int right){
        if(left > right )return null;
        TreeNode parent = new TreeNode(preorder[pre_ix]);
        Integer index = map.get(preorder[pre_ix]);
        pre_ix++;
        //必须是先左在右
        parent.left=helper(left,index-1);
        parent.right=helper(index+1,right);
        return parent;
    }
}
