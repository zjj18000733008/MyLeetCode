import sun.misc.JavaSecurityProtectionDomainAccess;

import javax.sound.midi.Soundbank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

/**
 * 三数之和
 *
 * @author JJ
 * @date 2020/8/15 - 14:50
 */
public class No15 {

    /**
     * 三数之和是外层循环+内部双指针，
     *
     * @param nums
     * @return
     */
    //执行用时：271 ms, 在所有 Java 提交中击败了8.13% 的用户
    //内存消耗：44.7 MB, 在所有 Java 提交中击败了6.32% 的用户
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();//用于去重
        //以第二个到倒数第二个为中心,找左右两边能使三数和为0的数
        for (int i = 1; i < nums.length - 1; i++) {
            int left = 0, right = nums.length - 1;
            while (left < right && left < i && right > i) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[i]);
                    list.add(nums[right]);
                    if (!set.contains(list)) {
                        lists.add(list);
                    }
                    set.add(list);
                    right--;
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        No15 no = new No15();
        //        int[] arr={-1,0,1,2,-1,-4};
        int[] arr = {0, 0, 0, 0};
        List<List<Integer>> lists = no.threeSum(arr);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    /**
     * 使用map
     * 执行用时：250 ms, 在所有 Java 提交中击败了10.24% 的用户
     * 内存消耗：42.8 MB, 在所有 Java 提交中击败了12.05% 的用户
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>();

        if (nums.length < 3) {
            return lists;
        }

        Arrays.sort(nums);

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(String.valueOf(nums[i]), i);
        }

        for (int i = 0; i < nums.length - 2; i++) {

            // 防止结果重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int a = nums[i];
            List<Integer> list = null;
            for (int j = i + 1; j < nums.length - 1; j++) {
                // 防止结果重复
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int b = nums[j];
                list = new ArrayList<>();
                if (map.containsKey(String.valueOf(0 - a - b)) && map.get(String.valueOf(0 - a - b)) > j) {
                    list.add(a);
                    list.add(b);
                    list.add(0 - a - b);
                    lists.add(list);
                }
            }
        }
        return lists;
    }

    /**
     * 三指针: 外面一层for循环,内部双指针
     * 执行用时：25 ms, 在所有 Java 提交中击败了51.87% 的用户
     * 内存消耗：42.6 MB, 在所有 Java 提交中击败了31.67% 的用户
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum3(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>();

        if (nums.length < 3) {
            return lists;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            while (i > 0 && i<nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
            if(i>=nums.length-2){
                return lists;
            }
            int a = nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int count = a + nums[left] + nums[right];
                if (count > 0) {
                    right--;
                    while (right < nums.length - 1 && right>0 && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (count < 0) {
                    left++;
                    while (left > i + 1 && left<nums.length && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(a);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);

                    left++;
                    while (left > i + 1 && left<nums.length && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    right--;
                    while (right < nums.length - 1  && right>0 && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }

        return lists;
    }

    @Test
    public void test() {
        List<List<Integer>> lists = threeSum3(new int[] {-1, 0, 1, 2, -1, -4});
        List<List<Integer>> lists2 = threeSum3(new int[] {0,0,0});
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.printf(integer + " ");
            }
            System.out.println();
        }


    }
}
