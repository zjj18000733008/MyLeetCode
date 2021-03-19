import java.util.*;

/**
 * @author JJ
 * @date 2020/8/17 - 14:27
 */
public class No18 {

    /**
     * 三数之和是外层循环+内部双指针，四数就是外部两层循环+内部双指针；
     * @param nums
     * @param target
     * @return
     */
    //执行用时：11 ms, 在所有 Java 提交中击败了62.55% 的用户
    //内存消耗：39.9 MB, 在所有 Java 提交中击败了84.96% 的用户
    public List<List<Integer>> fourSum(int[] nums, int target) {

        ArrayList<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return lists;
        }
        HashSet<List<Integer>> set = new HashSet<>();//用于去重
        Arrays.sort(nums);
        int minValue = nums[0] + nums[1] + nums[2] + nums[3];
        int maxValue = nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] + nums[nums.length - 4];

        if (minValue > target || maxValue < target) {
            return lists;
        }

        for (int i = 1; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int left = 0, right = nums.length - 1;

                while (left < i && right > j) {

                    int sum = nums[left] + nums[i] + nums[j] + nums[right];
                    if (sum == target) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[left]);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[right]);
                        if(!set.contains(list)){
                            lists.add(list);
                        }
                        set.add(list);
                        right--;
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }

                }

            }
        }
        return lists;
    }

    public static void main(String[] args) {
        No18 no = new No18();
        int[] arr = {-1, -2, 0, 0, 1, 2};
        List<List<Integer>> lists = no.fourSum(arr, 0);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
}
