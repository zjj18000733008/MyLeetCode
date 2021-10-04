/**
 * @author JJ
 * @date 2020/7/28 - 20:21
 */
public class BiTree {

    public static TreeNode arrToBiTree(int[] arr){
        if(arr.length==0) return null;
        TreeNode root =null;
        for (int i = 0; i < arr.length; i++) {
            TreeNode node = new TreeNode(arr[i]);
            if(i==0){
                root=node;
            }
            fillChild(arr,node,i);
        }
        return root;
    }

    private static void fillChild(int[] arr,TreeNode root,int p){
        if(2*p+1<arr.length){
            TreeNode node = new TreeNode(2 * p + 1);
            root.left=node;
        }
        if(2*p+2<arr.length){
            TreeNode node = new TreeNode(2 * p + 2);
            root.right=node;
        }
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        TreeNode root = arrToBiTree(arr);
    }
}
