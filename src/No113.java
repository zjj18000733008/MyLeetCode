import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie01
 * @Date: 2021/9/3
 */
public class No113 {

    List lists=new ArrayList();

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.99% 的用户
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了41.62% 的用户
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return lists;
        }

        ArrayList<Integer> list = new ArrayList<>();
        pathSum(root, targetSum, list);

        return lists;
    }

    public void pathSum(TreeNode root, int targetSum, List<Integer> list) {
        if (root == null) {
            return;
        }

        targetSum-=root.val;
        list.add(root.val);

        if (root.left==null && root.right==null && targetSum==0) {
            lists.add(new ArrayList<>(list));
        }

        pathSum(root.left, targetSum,list);
        pathSum(root.right, targetSum,list);

        targetSum+=root.val;
        list.remove(list.size()-1);
        return ;
    }

    @Test
    public void test(){
        TreeNode root = BinaryTreeUtils.buildTree(new int[] {5, 4, 8, 11, -1, 13, 4, 7, 2,-1,-1, -1, -1, 5, 1}, -1);
        List<List<Integer>> lists = pathSum(root, 22);
        lists.forEach(list->{
            list.forEach(i->{
                System.out.print(i+" ");
            });
            System.out.println();
        });
    }
}
