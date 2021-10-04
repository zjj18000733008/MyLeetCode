import java.util.ArrayList;
import java.util.List;

/**
 * @author JJ
 * @date 2020/8/20 - 13:58
 */
public class No46 {

    List<List<Integer>> lists=new ArrayList<>();
    //执行用时：1 ms, 在所有 Java 提交中击败了99.74% 的用户
    //内存消耗：39.9 MB, 在所有 Java 提交中击败了77.98% 的用户
    public List<List<Integer>> permute(int[] nums) {
        int[] visited=new int[nums.length];
        backtrack(new ArrayList<Integer>(),nums,0,visited);
        return lists;
    }

    private void backtrack(List<Integer> list,int[] nums,int count,int[] visited){
        if (count == nums.length) {
            lists.add(new ArrayList<>(list));
        }else {
            for (int i = 0; i < nums.length; i++) {
                if(visited[i]==1)continue;
                list.add(nums[i]);
                visited[i]=1;
                backtrack(list, nums, count+1,visited);
                list.remove(list.size() - 1);
                visited[i]=0;
            }
        }
    }

    public static void main(String[] args) {
        No46 no = new No46();
        int[] arr={1,2,3};
        List<List<Integer>> lists = no.permute(arr);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
