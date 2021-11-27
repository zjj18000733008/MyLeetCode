import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie
 * @Date: 2021/11/2
 */
public class JZO26 {

    private boolean flag = false;

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：40.1 MB, 在所有 Java 提交中击败了58.55% 的用户
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }

        preOrder(A, B);
        return flag;
    }

    private void preOrder(TreeNode A, TreeNode B) {
        if (A == null) {
            return ;
        }
        /*
        先序遍历A树,如果当前A结点值等于B的root值,
        则从这两个结点开始进行子树比较.
        由于是遍历A树,所以用flag标记,只要某次子树比较通过即表示B是A的子结构
         */
        if (A.val == B.val) {
            if(compare(A, B)){
                flag=true;
            }
        }
        preOrder(A.left, B);
        preOrder(A.right, B);

    }

    /**
     * 每次比较当前结点
     * @param A
     * @param B
     * @return
     */
    private boolean compare(TreeNode A, TreeNode B) {
        if (A == null && B != null) {
            return false;
        }
        if (B == null) {
            return true;
        }
        return A.val == B.val && compare(A.left, B.left) && compare(A.right, B.right);
    }

    @Test
    public void test() {
        System.out.println(isSubStructure(BinaryTreeUtils.buildTree(new int[] {3, 4, 5, 1, 2, -1, -1}, -1),
                BinaryTreeUtils.buildTree(new int[] {4, 1, -1}, -1)));
        System.out.println(isSubStructure(
                BinaryTreeUtils.buildTree(new int[] {4, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1}, -1),
                BinaryTreeUtils.buildTree(new int[] {4, 8, 9}, -1)));
        /*
        4
       2   3
      4 5 6 7
     8 9
         */
    }
}
