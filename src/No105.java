import sun.reflect.generics.tree.Tree;

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

//    private void func(int[] preorder,int[] inorder,int start ,int end,TreeNode root){
//        if()
//    }
}

class No105_2 {
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

    //???????????????2 ms, ????????? Java ??????????????????98.09% ?????????
    //???????????????39.9 MB, ????????? Java ??????????????????81.14% ?????????
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
        //?????????????????????
        parent.left=helper(left,index-1);
        parent.right=helper(index+1,right);
        return parent;
    }
}
