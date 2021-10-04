import java.awt.font.NumericShaper;
import java.io.PipedInputStream;

import org.junit.Assert;
import org.junit.Test;

/**
 * 删除排序数组中的重复项 26,27有异曲同工之妙
 * @author JJ
 * @date 2020/7/16 - 17:44
 */
public class No26 {

    public static void main(String[] args) {
        No26 no = new No26();
        int[] arr={0,0,1,1,1,2,2,3,3,4};
//        int[] arr={1,2};
        int i = no.removeDuplicates(arr);
        System.out.println(i);
    }

    /**
     * 整体思路:
     * 将当前数组分割成三部分
     *  已分配好的部分 空位(可被覆盖的空间) 未被分配的部分
     *       lastValidIndex  i
     *  这三部分用这两个变量分割
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums){

        if(nums.length==0){
            return 0;
        }

        int lastValidIndex=0;//记录已确定好的数组的最后一个元素的下标
        //从下标1开始遍历数组
        for(int i=1;i<nums.length;i++){
            //将当前元素和已分配好的数组的最后一个元素比较,如果不同
            if(nums[lastValidIndex]!=nums[i]){
                //将当前元素加入已分配好的数组后面
                nums[lastValidIndex+1]=nums[i];
                //同时扩大已分配好的数组的大小(修改已分配好的数组最后一个元素的下标)
                lastValidIndex++;
            }
        }
        return lastValidIndex+1;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了89.43% 的用户
     * 内存消耗：39.4 MB, 在所有 Java 提交中击败了97.81% 的用户
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums){
        if(nums.length==0){
            return 0;
        }
        //决定元素可以放在哪个位置
        int left=0;
        //找到应该移动的元素
        int right=0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[i-1]){
                continue;
            }else{
                nums[left+1]=nums[i];
                left++;
            }
        }
        return left+1;
    }

    @Test
    public void test(){
        Assert.assertEquals(5, removeDuplicates2(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}
