import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 回溯算法
 *
 * @author JJ
 * @date 2020/8/19 - 15:22
 */
public class No22 {

    private List<String> list = new ArrayList<>();

    //执行用时：1 ms, 在所有 Java 提交中击败了96.78% 的用户
    //内存消耗：39.8 MB, 在所有 Java 提交中击败了73.98% 的用户
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            list.add("");
            return list;
        }
        TreeNode<String> root = new TreeNode<String>("");
        TreeNode<String> left = new TreeNode<String>("(");
        root.lchild = left;
        dfs(left, 1, 0, n);

        return list;
    }

    private void dfs(TreeNode<String> culNode, int left, int right, int n) {
        if (left < right) {//剪枝
            culNode = null;
            return;
        }
        if (right == n) {
            list.add(culNode.data);
            return;
        }
        if (left < n) {
            TreeNode<String> leftnode = new TreeNode<String>(culNode.data + "(");
            int l = left + 1;
            dfs(leftnode, l, right, n);
        }
        if (right < n) {
            TreeNode<String> rightnode = new TreeNode<String>(culNode.data + ")");
            int r = right + 1;
            dfs(rightnode, left, r, n);
        }

    }

    private class TreeNode<T> {
        T data;
        TreeNode<T> lchild;
        TreeNode<T> rchild;

        TreeNode(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        No22 no = new No22();
        List<String> list = no.generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }
    }
}

class No22_2 {

    private List<String> list = new ArrayList<String>();
    //执行用时：1 ms, 在所有 Java 提交中击败了96.78% 的用户
    //内存消耗：39.9 MB, 在所有 Java 提交中击败了49.32% 的用户
    public List<String> generateParenthesis(int n) {

        if (n == 0) {
            list.add("");
            return list;
        }
        backtrack("(", 1, 0, n);
        return list;
    }

    private void backtrack(String ans, int left, int right, int n) {
        if (left < right) {
            return;
        }
        if (right == n) {
            list.add(ans);
        }

        if (left < n) {
            backtrack(ans + "(", left + 1, right, n);
        }
        if (right < n) {
            backtrack(ans + ")", left, right + 1, n);
        }
    }

    public static void main(String[] args) {
        No22_2 no = new No22_2();
        List<String> list = no.generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }

    }
}

