/**
 * @author JJ
 * @date 2020/7/27 - 18:02
 */
public class No88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //如果从前往后查找并插入,则需要将nums1数组元素后移,且几乎每找到一次就要后移
        //但是如果从后往前查找,由于两个数组都是有序的,所以可以逐渐将两个数组中最大的元素找出来并放到数组1的后面
        int p = (m--) + (n--) - 1;
        while (m >= 0 && n >= 0) {//每次循环找到两数组的剩余元素中的最大值,放到数组1的后面
            nums1[p--]=nums1[m]>nums2[n]?nums1[m--]:nums2[n--];
        }
        while(n>=0){
            nums1[p--]=nums2[n--];
        }
    }

    public static void main(String[] args) {
//        int[] nums1={1,2,3,0,0,0};
//        int[] nums2={2,5,6};
//        int[] nums1={0};
//        int[] nums2={2};
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int[] nums2 = {1, 2, 3};

        No88 no = new No88();
        no.merge(nums1, 3, nums2, 3);
        for (int i : nums1) {
            System.out.print(i + " ");
        }
    }
}
