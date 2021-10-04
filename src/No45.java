import org.junit.Assert;
import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie01
 * @Date: 2021/9/7
 */
public class No45 {


    public int jump(int[] nums) {
        if (nums[0] == 0 || nums.length == 1) {
            return 0;
        }
        return jump(nums, 0, 0);
    }

    public int jump(int[] nums , int start,int n){
        n++;
        if(start>=nums.length-1){
            return n;
        }

        int maxCanJumpStep=0;
        int idx=-1;
        for (int i = start+1; i <= nums[start]+start ; i++) {
            if (nums[i] > maxCanJumpStep) {
                maxCanJumpStep=nums[i];
                idx=i;
            }
        }
        return jump(nums, idx+maxCanJumpStep, n);
    }

    @Test
    public void test(){
        Assert.assertEquals(2, jump(new int[]{2,3,1,1,4}));
        Assert.assertEquals(2, jump(new int[]{2,3,0,1,4}));
    }
}
