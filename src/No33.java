/**
 * @author JJ
 * @date 2020/8/21 - 21:55
 */
public class No33 {

    //执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
    //内存消耗：39.8 MB, 在所有 Java 提交中击败了7.80% 的用户
    //执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
    //内存消耗：39.3 MB, 在所有 Java 提交中击败了85.66% 的用户
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=(right+left)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<nums[right]){//右半边有序
                if(nums[mid]<target && target<=nums[right]){//如果target处于右半边
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }else{//做左半边有序
                if(nums[mid]>target && target>=nums[left]){//如果target处于左半边
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        return 0;
    }

    public static void main(String[] args) {
        No33 no = new No33();
        int[] arr={4,5,6,7,0,1,2};
        int search = no.search(arr, 0);
        System.out.println(search);
    }
}
