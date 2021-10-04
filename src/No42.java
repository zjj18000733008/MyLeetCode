import org.junit.Assert;
import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie01
 * @Date: 2021/9/9
 */
public class No42 {

    /**
     * 执行用时：150 ms, 在所有 Java 提交中击败了5.01% 的用户
     * 内存消耗：38.1 MB, 在所有 Java 提交中击败了57.21% 的用户
     * @param height
     * @return
     */
    public int trap(int[] height) {

        int ans=0;

        for (int i = 1; i < height.length-1; i++) {
            int left=i-1;
            int leftMaxHeight=0;
            int right=i+1;
            int rightMaxHeight=0;

            while (left >= 0) {
                leftMaxHeight=Math.max(leftMaxHeight, height[left]);
                left--;
            }
            if(leftMaxHeight<=height[i]){
                continue;
            }

            while(right<height.length){
                rightMaxHeight=Math.max(rightMaxHeight, height[right]);
                right++;
            }
            if(rightMaxHeight<=height[i]){
                continue;
            }

            ans+=Math.min(leftMaxHeight, rightMaxHeight)-height[i];

        }

        return ans;
    }

    @Test
    public void test(){
        int trap = trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        Assert.assertEquals(6, trap);
    }
}
