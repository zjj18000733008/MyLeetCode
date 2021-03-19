import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author JJ
 * @date 2020/8/28 - 10:37
 */
public class No90 {

    HashSet<List<Integer>> set = new HashSet<>();
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            backtrack(nums, new ArrayList<>(), i, 0, 0);
        }
        return lists;
    }

    private void backtrack(int[] nums, List<Integer> list, int n, int count, int start) {
        if (count == n) {
            ArrayList<Integer> list_1 = new ArrayList<>(list);
            if (!set.contains(list_1)) {
                set.add(list_1);
                lists.add(list_1);
            }
            return;
        }

        for (int i = start; i < nums.length ; i++) {
            list.add(nums[i]);
            backtrack(nums, list, n, count + 1, i + 1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        No90 no = new No90();
        int[] arr = {1, 2, 2};
        List<List<Integer>> lists = no.subsetsWithDup(arr);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

class No90_2{

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            backtrack(nums, new ArrayList<>(), i, 0, 0);
        }
        return lists;
    }

    private void backtrack(int[] nums, List<Integer> list, int n, int count, int start) {
        if (count == n) {
            lists.add(new ArrayList<>(list));
        }

        for (int i = start; i < nums.length ; i++) {
            if(i>start && nums[i]==nums[i-1]) continue;
            list.add(nums[i]);
            backtrack(nums, list, n, count + 1, i + 1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        No90 no = new No90();
        int[] arr = {1, 2, 2};
        List<List<Integer>> lists = no.subsetsWithDup(arr);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

}

class No90_3{

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        return null;
    }
}
