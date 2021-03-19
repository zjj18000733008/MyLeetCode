/**
 * @author JJ
 * @date 2020/8/25 - 23:01
 */
public class No80 {

    public int removeDuplicates(int[] nums) {
        int i=0;
        for (int n : nums) {
            if(i<2 || n>nums[i-2]){
                nums[i++]=n;
            }
        }
        return i;
    }
}
