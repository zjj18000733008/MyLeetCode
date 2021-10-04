import sun.reflect.generics.tree.Tree;

/**
 * @author JJ
 * @date 2020/7/28 - 18:55
 */
public class No108 {
//    public TreeNode sortedArrayToBST(int[] nums){
//        if(nums.length==0) return null;
//        return buildTree(nums,0,nums.length);
//    }
    public TreeNode sortedArrayToBST(int[] nums){
        if(nums.length==0) return null;
        int mid=nums.length/2;
        TreeNode node = new TreeNode(nums[mid]);
        TreeNode left=null;
        TreeNode right=null;
        if(mid-1>=0){
            left=new TreeNode(nums[mid-1]);
            node.left=left;
        }
        if(mid+1<nums.length){
            right=new TreeNode(nums[mid+1]);
            node.right=right;
        }

        for(int i=mid-2;i>=0;i--){
            left.left=new TreeNode(nums[i]);
            left=left.left;
        }
        for(int i=mid+2;i<nums.length;i++){
            right.right=new TreeNode(nums[i]);
            right=right.right;
        }
        return node;
    }

    public TreeNode buildTree(int[] nums,int left,int right){
        if(left>right) return null;
        int mid=(left+right)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left=buildTree(nums,left,mid-1);
        node.right=buildTree(nums,mid+1,right);
        return node;
    }

    public static void main(String[] args) {
//        int[] arr={-10,-3,0,5,9};
        int[] arr={1,3};
        No108 no = new No108();
        TreeNode root = no.sortedArrayToBST(arr);
    }

    public TreeNode sortedArrayToBST2(int[] nums) {

        int mid=(nums.length - 1) / 2;
        TreeNode parent = new TreeNode(mid);

        for (int i = 0; i < nums.length; i++) {
            if (i == mid) {
                continue;
            }
            if (nums[i] < parent.val) {

            }
        }

        return null;
    }

}
