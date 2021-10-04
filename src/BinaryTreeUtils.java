import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie01
 * @Date: 2021/8/17
 */
public class BinaryTreeUtils {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        TreeNode parent = new TreeNode(preorder[0]);

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                //找到左子节点
                TreeNode left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                //找到右子节点
                TreeNode right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length),
                        Arrays.copyOfRange(inorder, i + 1, inorder.length));
                parent.left = left;
                parent.right = right;
            }
        }

        return parent;
    }

    /**
     *
     * @param arr
     * @param identifier
     * @return
     */
    public static TreeNode buildTree(int[] arr, int identifier) {

        //        for (int i = 0; i < arr.length; i++) {
        //
        //        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        queue.add(root);
        int idx = 0;

        while (!queue.isEmpty() && idx != arr.length - 1) {

            for (int i = 0; i < queue.size(); i++) {
                if (idx == arr.length - 1) {
                    break;
                }
                idx += 1;
                TreeNode left = null;
                if (arr[idx] != identifier) {
                    left = new TreeNode(arr[idx]);
                }
                idx += 1;
                TreeNode right = null;
                if (arr[idx] != identifier) {
                    right = new TreeNode(arr[idx]);
                }
                TreeNode parent = queue.pop();
                if (parent != null) {
                    parent.left = left;
                    parent.right = right;
                }
                queue.add(left);
                queue.add(right);
            }

        }

        return root;
    }

    @Test
    public void test() {
        TreeNode treeNode = buildTree(new int[] {1, 2, 5, 3, 4, -1, 6}, -1);
        TreeNode treeNode1 = buildTree(new int[] {1, -1, 2, -1, -1, 4, 3}, -1);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left != null && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        } else if (root.left != null) {
            return minDepth(root.left) + 1;
        } else {
            return minDepth(root.right) + 1;
        }
    }

}
