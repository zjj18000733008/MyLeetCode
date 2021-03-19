import java.util.Arrays;

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

    public static void main(String[] args) {
        int[] arr={-1,2,1,-4};
        No16 no = new No16();
        int i = no.threeSumClosest(arr, 1);
        System.out.println(i);
    }
}
