import java.util.ArrayList;
import java.util.List;

/**
 * @author JJ
 * @date 2020/8/4 - 14:44
 */
public class No257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> s3=new ArrayList<>();
        if(root==null) return s3;
        if(root.left==null && root.right==null){
            s3.add(Integer.toString(root.val));
        }
        List<String> s1 = binaryTreePaths(root.left);
        List<String> s2 = binaryTreePaths(root.right);
        if(s1!=null){
            for(int i=0;i<s1.size();i++){
                s3.add(root.val+"->"+s1.get(i));
            }
        }
        if(s2!=null){
            for(int i=0;i<s2.size();i++){
                s3.add(root.val+"->"+s2.get(i));
            }
        }
        return s3;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(5);
        n1.left=n2;
        n1.right=n3;
        n2.right=n4;
        No257 no = new No257();
        List<String> strings = no.binaryTreePaths(n1);
        for (String string : strings) {
            System.out.println(string);
        }
    }

}
