import org.junit.Assert;
import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie
 * @Date: 2021/10/18
 */
public class JZO15 {

    public int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        int count=0;
        for(int i =0 ;i<s.length();i++){
            if(s.charAt(i)=='1'){
                count++;
            }
        }
        return count;
    }

    @Test
    public void test(){
        Assert.assertEquals(3, hammingWeight(7));
    }
}
