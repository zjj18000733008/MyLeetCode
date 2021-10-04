/**
 * @author JJ
 * @date 2020/8/22 - 15:17
 */
public class No34 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：43.1 MB, 在所有 Java 提交中击败了43.49% 的用户
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] ans={-1,-1};
        if(nums.length==0) {
            return ans;
        }
        int left=0,right=nums.length-1;
        //向左逼近,取最小下标
        while(left<right) {
            int mid=(left+right)/2;
            if(target<=nums[mid]) {
                right=mid;
            } else {
                left=mid+1;
            }
        }
        if(nums[left]!=target) {
            return ans;
        }
        ans[0]=left;

        left=0;
        right=nums.length;
        //向右逼近,取最大下标
        while(left<right){
            int mid=  (left+right)/2;
            if(target>=nums[mid]) {
                left=mid+1;
            } else {
                right=mid;
            }
        }
        ans[1]=left-1;


        return ans;
    }

    public static void main(String[] args) {
        No34 no = new No34();
        int[] arr={5,7,7,8,8,10};
        int[] ans = no.searchRange(arr, 8);
        for (int i : ans) {
            System.out.println(i);
        }
    }
}
