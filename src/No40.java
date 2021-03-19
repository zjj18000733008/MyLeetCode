import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author JJ
 * @date 2020/8/20 - 13:33
 */
public class No40 {

    private List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<Integer>(), 0);
        return lists;
    }

    private void backtrack(int[] candidates, int target, int sum, List<Integer> list, int start) {
        if (sum > target) {
            return;
        } else if (sum == target) {
            lists.add(new ArrayList<Integer>(list));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if(i>start && candidates[i]==candidates[i-1]) continue;;//数组排序后,加上这一步去重,挺重要的一步
                list.add(candidates[i]);
                backtrack(candidates, target, sum + candidates[i], list, i+1);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        No40 no = new No40();
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> lists = no.combinationSum2(arr, 8);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
