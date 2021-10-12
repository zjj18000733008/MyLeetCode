import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie
 * @Date: 2021/10/12
 */
public class JZO03 {

    private Set<Integer> set=new HashSet<>();

    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了77.85% 的用户
     * 内存消耗：45.8 MB, 在所有 Java 提交中击败了92.97% 的用户
     * @param nums
     * @return
     */
    public int findRepeatNumber2(int[] nums){
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (temp[nums[i]]==1) {
                return nums[i];
            }
            temp[nums[i]]=1;
        }
        return -1;
    }

    @Test
    public void test(){
        System.out.println(findRepeatNumber(new int[] {2, 3, 1, 0, 2, 5, 3}));
    }

    @Test
    public void test2(){
        System.out.println(findRepeatNumber2(new int[] {2, 3, 1, 0, 2, 5, 3}));
    }
}
