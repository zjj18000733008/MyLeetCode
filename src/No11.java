/**
 * @author JJ
 * @date 2020/8/13 - 10:40
 */
public class No11 {
    /**
     * 第一遍
     * 执行用时：3 ms, 在所有 Java 提交中击败了92.55% 的用户
     * 内存消耗：40.1 MB, 在所有 Java 提交中击败了52.22% 的用户
     * 第二遍
     * 执行用时：2 ms, 在所有 Java 提交中击败了99.12% 的用户
     * 内存消耗：40.5 MB, 在所有 Java 提交中击败了5.21% 的用户
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int capacity = 0;
        while (left < right) {
            capacity = Math.max(
                    Math.min(height[left], height[right]) * (right - left)
                    , capacity
            );
            if (height[left] < height[right]) {//如果左边更低
                int base = height[left];//将之前的数记录下来
                left++;
                //左指针向后找比之前高的数
                while (left < right && height[left] < base) {
                    left++;
                }
            } else if (height[left] > height[right]) {//如果右边更低
                int base = height[right];//将之前的数记录下来
                right--;
                //右指针向前找比之前高的数
                while (left < right && height[right] < base) {
                    right--;
                }
            }else{//如果左边和右边一样高
                int base=height[left];
                left++;
                //左边向后找比之前高的数
                while (left < right && height[left] < base) {
                    left++;
                }
                right--;
                //右边向前找比之前高的数
                while (left < right && height[right] < base) {
                    right--;
                }
            }
        }
        return capacity;
    }

    public static void main(String[] args) {
        No11 no = new No11();
//        int[] arr={1,8,6,2,5,4,8,3,7};
        int[] arr={2,3,4,5,18,17,6};
        int i = no.maxArea(arr);
        System.out.println(i);
    }
}
