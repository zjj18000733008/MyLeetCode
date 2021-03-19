import javax.sound.midi.MidiChannel;

/**
 * 对半边有序的数组进行二分查找
 * @author JJ
 * @date 2020/8/28 - 10:02
 */
public class No81 {

    //执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
    //内存消耗：39.5 MB, 在所有 Java 提交中击败了73.30% 的用
    public boolean search(int[] nums, int target) {
        if(nums.length==0)return false;
        int left=0,right=nums.length-1;

        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target)return true;
            if(nums[mid]==nums[left]){//由于有重复值,所以有时候不好判断哪边有序,这是不如考虑放弃掉前面那个重复的元素
                left++;
                continue;
            }
            if(nums[left]<nums[mid]){//左半边有序
                if(nums[left]<=target && target<nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{//右半边有序
                if(nums[right]>=target && target>nums[mid]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        No81 no = new No81();
//        int[] arr={2,5,6,0,0,1,2};
        int[] arr={1,1,1,0,1};
        boolean search = no.search(arr, 3);
        System.out.println(search);
    }
}
