import java.util.ArrayList;
import java.util.List;

/**
 * @author JJ
 * @date 2021/2/9 - 22:18
 */
public class No216 {

    List<List<Integer>> lists=new ArrayList<>();

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：36.1 MB, 在所有 Java 提交中击败了52.66% 的用户
     * @author JJ
     * @date 2021/2/9 22:56
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(n,k,0,1,new ArrayList<>(),0);
        return lists;
    }

    public void backtrack(int n,int k,int count,int start,List<Integer> list,int sum){
        if(count==k){
            if(sum==n) {
                lists.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            list.add(i);
            backtrack(n,k,count+1,i+1,list,sum+i);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        No216 no = new No216();
        List<List<Integer>> lists = no.combinationSum3(3, 9);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
