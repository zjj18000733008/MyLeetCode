import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie
 * @Date: 2021/10/19
 */
public class JZO21 {

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了82.35% 的用户
     * 内存消耗：46.4 MB, 在所有 Java 提交中击败了38.43% 的用户
     *
     * 题型抽象: 将数组根据某种特征分为两份, 一份在左一份在右;
     * 可以利用快排的哨兵思想, 左右两个哨兵
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {

        int left=0;
        int right=nums.length-1;

        while (left < right) {
            while (left < right && nums[left] % 2 != 0) {
                left++;
            }

            while (left < right && nums[right] % 2 == 0) {
                right--;
            }

            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
        }

        return nums;
    }

    @Test
    public void test(){
        int[] arr = exchange(new int[] {1, 2, 3, 4});
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
