import sun.print.SunMinMaxPage;

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
class No40_2{

    List<List<Integer>> lists=new ArrayList<>();
    boolean flag=false;

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了99.96% 的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了79.75% 的用户
     * @author JJ
     * @date 2021/3/26 13:44
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(new ArrayList<>(),candidates,target,0,0);
        return lists;
    }

    public void backtrack(List<Integer> list,int[] candidates,int target,int sum,int start){
        if(sum>target){
            flag=true;
            return;
        }

        if(sum==target){
            flag=true;
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <candidates.length ; i++) {
            if(i>start && candidates[i]==candidates[i-1])continue;
            list.add(candidates[i]);
            backtrack(list,candidates,target,sum+candidates[i],i+1);
            list.remove(list.size()-1);
            if(flag){
                flag=false;
                break;
            }
        }
    }
}