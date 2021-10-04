import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie01
 * @Date: 2021/9/6
 */
public class NC130 {

    public int candy(int[] arr) {
        // write code here
        int base = 1;
        int pre = -1;
        int total = 0;
        int preMaxIdx=Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
            } else if(pre<arr[i]){
                preMaxIdx=Integer.MAX_VALUE;
                base++;
            }else if(pre>arr[i]){
                preMaxIdx=Math.min(preMaxIdx, i-1);
                if (base==1) {
                    total+=i-preMaxIdx;
                }

            }
            pre=arr[i];
            total += base;
        }

        return total;
    }

    @Test
    public void test(){
        Assert.assertEquals(4, candy(new int[]{1,1,2}));
        Assert.assertEquals(8, candy(new int[]{10,4,10,10,4}));
        Assert.assertEquals(7, candy(new int[]{2,4,3,1}));
    }
}
