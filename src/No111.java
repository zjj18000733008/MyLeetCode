/**
 * @author JJ
 * @date 2020/7/28 - 19:53
 */
public class No111 {
    public int minDepth(TreeNode root) {
        if(root==null)return 0;
        // null节点不参与比较
        if (root.left == null && root.right != null) {
            return 1 + minDepth(root.right);
        }
        // null节点不参与比较
        if (root.right == null && root.left != null) {
            return 1 + minDepth(root.left);
        }
        return Math.min(root.left==null?0:minDepth(root.left),root.right==null?0:minDepth(root.right))+1;
    }

    /**
     * 执行用时：5 ms, 在所有 Java 提交中击败了71.52% 的用户
     * 内存消耗：58.9 MB, 在所有 Java 提交中击败了22.06% 的用户
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root){
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }else if (root.left != null && root.right != null) {
            return Math.min(minDepth2(root.left), minDepth2(root.right))+1;
        } else if (root.left != null) {
            return minDepth2(root.left)+1;
        }else{
            return minDepth2(root.right)+1;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode();
        TreeNode n5 = new TreeNode();
        TreeNode n6 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);
        n1.left=n2;
        n1.right=n3;
        n3.left=n6;
        n3.right=n7;
        No111 no = new No111();
        int i = no.minDepth(n1);
        System.out.println(i);
    }
}
