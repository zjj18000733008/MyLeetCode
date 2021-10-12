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

    public int jump(int[] nums, int start, int n) {
        n++;
        if (start >= nums.length - 1) {
            return n;
        }

        int maxCanJumpStep = 0;
        int idx = -1;
        for (int i = start + 1; i <= nums[start] + start; i++) {
            if (nums[i] > maxCanJumpStep) {
                maxCanJumpStep = nums[i];
                idx = i;
            }
        }
        return jump(nums, idx + maxCanJumpStep, n);
    }

    @Test
    public void test() {
        Assert.assertEquals(2, jump(new int[] {2, 3, 1, 1, 4}));
        Assert.assertEquals(2, jump(new int[] {2, 3, 0, 1, 4}));
    }

    public int jump2(int[] nums) {

        if (nums.length == 0 || nums.length == 1) {
            return 0;
        }
        //        if (nums[0] >= nums.length - 1) {
        //            return 1;
        //        }

        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            ans++;
            int canJumpStepMax = nums[i];
            if (canJumpStepMax >= nums.length - 1 - i) {
                break;
            }
            int max = 0;
            int start = i;
            for (int j = i + 1; j < nums.length && j <= start + canJumpStepMax; j++) {
                if (nums[j] >= max) {
                    max = nums[j];
                    i = j - 1;
                }
            }

        }

        return ans;
    }

    @Test
    public void jump2Test() {
        //        Assert.assertEquals(2, jump2(new int[] {2, 3, 1, 1, 4}));
        //        Assert.assertEquals(2, jump2(new int[] {2, 3, 0, 1, 4}));
        Assert.assertEquals(1, jump2(new int[] {3, 2, 1}));
        Assert.assertEquals(3, jump2(new int[] {3, 4, 3, 2, 5, 4, 3}));
        Assert.assertEquals(3, jump2(new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0}));
    }

    public int jump3(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int reach = 0;
        int nextreach = nums[0];
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            nextreach = Math.max(i + nums[i], nextreach);
            if (nextreach >= nums.length - 1) {
                return (step + 1);
            }
            if (i == reach) {
                step++;
                reach = nextreach;
            }
        }
        return step;
    }

    @Test
    public void jump3Test() {
        Assert.assertEquals(2, jump3(new int[] {2, 3, 1, 1, 4}));
        Assert.assertEquals(2, jump3(new int[] {2, 3, 0, 1, 4}));
        Assert.assertEquals(1, jump3(new int[] {3, 2, 1}));
        Assert.assertEquals(3, jump3(new int[] {3, 4, 3, 2, 5, 4, 3}));
        Assert.assertEquals(3, jump3(new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0}));
    }
}
