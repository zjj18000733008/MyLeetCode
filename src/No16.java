import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author JJ
 * @date 2020/8/17 - 12:52
 */
public class No16 {

    //执行用时：6 ms, 在所有 Java 提交中击败了85.71% 的用户
    //内存消耗：39.2 MB, 在所有 Java 提交中击败了89.25% 的用
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sumCloset=10000;
        for(int i=1;i<nums.length-1;i++){
            int left=0,right=nums.length-1;
            int sum=0;
            while(left<i && right>i){
                sum=nums[i]+nums[left]+nums[right];
                sumCloset=(Math.abs(sumCloset-target)>Math.abs(sum-target))?sum:sumCloset;
                if(sum<target){
                    left++;
                }else if(sum>target){
                    right--;
                }else{
                    return sum;
                }
            }
        }
        return sumCloset;
    }

    /**
     * 执行用时：5 ms, 在所有 Java 提交中击败了93.10% 的用户
     * 内存消耗：38.2 MB, 在所有 Java 提交中击败了35.28% 的用户
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest2(int[] nums, int target) {

        Arrays.sort(nums);
        int closest=nums[0]+nums[1]+nums[nums.length-1];

        for (int i = 0; i < nums.length; i++) {
            int a=nums[i];
            int left=i+1;
            int right=nums.length-1;

            while(left<right){
                int threeSum=a+nums[left]+nums[right];
                closest=Math.abs(target-closest)>Math.abs(target-threeSum)?threeSum:closest;
                if(threeSum-target<0){
                    left++;
                }else if(threeSum-target>0){
                    right--;
                }else{
                    return threeSum;
                }
            }

        }
        return closest;
    }

    @Test
    public void test(){
        Assert.assertEquals(threeSumClosest2(new int[]{-1,2,1,-4}, 1), 2);
    }

    public static void main(String[] args) {
        int[] arr={-1,2,1,-4};
        No16 no = new No16();
        int i = no.threeSumClosest(arr, 1);
        System.out.println(i);
    }
}
