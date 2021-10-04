import org.junit.Assert;
import org.junit.Test;

/**
 * 移除元素 26,27有异曲同工之妙
 * @author JJ
 * @date 2020/7/16 - 18:48
 */
public class No27 {

    public static void main(String[] args) {
        No27 no = new No27();
        System.out.println(no.removeElement(new int[]{3,2,2,3},3));
        System.out.println(no.removeElement(new int[]{0,1,2,2,3,0,4,2},2));
    }

    public int removeElement(int[] nums,int val){
        int lastValidIndex=-1;
        for(int i=0;i<nums.length;i++){
            if (nums[i] != val) {
                nums[lastValidIndex+1]=nums[i];
                lastValidIndex++;
            }
        }
        return lastValidIndex+1;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：37 MB, 在所有 Java 提交中击败了51.31% 的用户
     * @param nums
     * @param val
     * @return
     */
    public int removeElement2(int[] nums,int val){

        int left=-1;
        int count=0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=val){
                left++;
                nums[left]=nums[i];
                count++;
            }
        }

        return count;
    }

    @Test
    public void test(){
        Assert.assertEquals(5, removeElement2(new int[]{0,1,2,2,0,0,4,2}, 2));;
    }
}
