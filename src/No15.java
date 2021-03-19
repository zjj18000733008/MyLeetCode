import sun.misc.JavaSecurityProtectionDomainAccess;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 三数之和
 * @author JJ
 * @date 2020/8/15 - 14:50
 */
public class No15 {

    /**
     * 三数之和是外层循环+内部双指针，
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
        for(int i=1;i<nums.length-1;i++){
            int left=0,right=nums.length-1;
            while (left<right && left<i && right>i){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum==0){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[i]);
                    list.add(nums[right]);
                    if(!set.contains(list)){
                        lists.add(list);
                    }
                    set.add(list);
                    right--;
                    left++;
                }else if(sum>0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return lists;
    }
    public static void main(String[] args) {
        No15 no = new No15();
//        int[] arr={-1,0,1,2,-1,-4};
        int[] arr={0,0,0,0};
        List<List<Integer>> lists = no.threeSum(arr);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
}
