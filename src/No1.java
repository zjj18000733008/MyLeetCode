import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie01
 * @Date: 2021/7/24
 */
public class No1 {
    /**
     * 使用map
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

    @Test
    public void test(){
        int[] ints = {3, 2,4};
        int[] result = twoSum(ints, 6);
        Assert.assertEquals(result[0],1);
        Assert.assertEquals(result[1],2);
    }
}
