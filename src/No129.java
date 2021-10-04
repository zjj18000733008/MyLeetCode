import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie01
 * @Date: 2021/9/3
 */
public class No129 {

    private List<List<Integer>> lists=new ArrayList<>();

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了7.21% 的用户
     * 内存消耗：35.9 MB, 在所有 Java 提交中击败了60.85% 的用户
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {

        sumNumbers(root, new ArrayList<>());
        int sum=0;
        for (List<Integer> list : lists) {
            StringBuilder sb = new StringBuilder();
            for (Integer i : list) {
                sb.append(i);
            }
            sum+=Integer.valueOf(sb.toString());
        }
        return sum;
    }

    public void sumNumbers(TreeNode root, List<Integer> list){
        if (root == null) {
            return;
        }

        list.add(root.val);
        if (root.left == null && root.right == null) {
            lists.add(new ArrayList<>(list));
        }
        sumNumbers(root.left,list);
        sumNumbers(root.right,list);
        list.remove(list.size()-1);
    }

    @Test
    public void test(){
        Assert.assertEquals(1026,sumNumbers(BinaryTreeUtils.buildTree(new int[]{4,9,0,5,1,-1,-1}, -1)) );
    }
}
