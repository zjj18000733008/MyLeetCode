import org.junit.Assert;
import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie
 * @Date: 2021/10/13
 */
public class JZO11 {


    public int minArray(int[] numbers){

        int min=Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (i == 0) {
                min=numbers[i];
                continue;
            }
            if (numbers[i] > min) {
                continue;
            }
            min=numbers[i];
        }
        return min;
    }

    @Test
    public void test(){
        Assert.assertEquals(1, minArray(new int[]{3,4,5,1,2}));
    }
}
