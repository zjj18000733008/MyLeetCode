import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author JJ
 * @date 2020/9/6 - 18:48
 */
public class No95 {

    List<TreeNode> list = new ArrayList<>();

    public List<TreeNode> generateTrees(int n) {
        int[] visited = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            TreeNode node = new TreeNode(i);
            visited[i] = 1;
            backtrack(visited, n, 1, node, node);
            visited[i] = 0;
        }
        return list;
    }

    private void backtrack(int[] visited, int n, int count, TreeNode root, TreeNode parent) {
        if (count == 1) {
            root = new TreeNode(root.val);
            parent = root;
        }
        if (count == n) {
            list.add(root);
            return;
        }

        for (int i = 1; i <= n; i++) {
            TreeNode node = null;
            if (visited[i] == 1) {
                continue;
            }
            node = new TreeNode(i);
            visited[i] = 1;

            if (i > parent.val) {
                parent.right = node;
            } else {
                parent.left = node;
            }
            backtrack(visited, n, count + 1, root, node);
            TreeNode par = new TreeNode(parent.val);
            parent = par;
            visited[i] = 0;

        }
    }

    public static void main(String[] args) {
        No95 no = new No95();
        List<TreeNode> treeNodes = no.generateTrees(3);
    }
}

class No95_2 {

    List<TreeNode> lists = new ArrayList<>();
//    HashSet<List<Integer>> set = new HashSet();

    public List<TreeNode> generateTrees(int n) {
        int[] visited = new int[n + 1];
        backtrack(visited, n, 0,null);
        return null;
    }

    private void backtrack(int[] visited, int n, int count,TreeNode origin) {
        if (count == n) {

        }

        for (int i = 1; i <= n; i++) {
            if (visited[i] == 1) continue;
            TreeNode root=null;

            if (count == 0) {
                root=new TreeNode(i);
            }else{
            }

        }
    }
}
