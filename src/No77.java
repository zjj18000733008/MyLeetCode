import java.util.ArrayList;
import java.util.List;

/**
 * @author JJ
 * @date 2020/8/21 - 21:23
 */
public class No77 {

    List<List<Integer>> lists=new ArrayList<>();
    //执行用时：33 ms, 在所有 Java 提交中击败了22.80% 的用户
    //内存消耗：40.9 MB, 在所有 Java 提交中击败了82.80% 的用户
    //执行用时：23 ms, 在所有 Java 提交中击败了53.59% 的用户
    //内存消耗：41.2 MB, 在所有 Java 提交中击败了40.19% 的用户
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n,k,0,new ArrayList<Integer>(),1);
        return lists;
    }

    private void backtrack(int n,int k,int count,List<Integer> list,int start){

        if(count==k){
            lists.add(new ArrayList<Integer>(list));
        }else {

            for (int i = start; i <= n; i++) {
                list.add(i);
                backtrack(n, k, count + 1, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        No77 no = new No77();
        List<List<Integer>> lists = no.combine(1, 1);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
