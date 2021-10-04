import org.junit.Assert;
import org.junit.Test;

/**
 * @author JJ
 * @date 2021/4/3 - 10:18
 */
public class No04 {

    public static void main(String[] args) {
        No04 no = new No04();
        int[] nums1 = {3};
        int[] nums2 = {2};
        System.out.println(no.findMedianSortedArrays(nums1, nums2));
        //        System.out.println();
        //        DecimalFormat df = new DecimalFormat("0.00000");
        //        System.out.println(df.format((double) 5 / 2));
    }

    public double getMedian(int[] nums, int n, int index) {
        //        DecimalFormat df = new DecimalFormat("0.00000");
        //        if(n%2==0){
        //            return Double.parseDouble(df.format((double)(nums[index]+nums[index-1])/2));
        //        }else{
        //            return Double.parseDouble(df.format((double)nums[index]));
        //        }
        if (n % 2 == 0) {
            return (double) (nums[index] + nums[index - 1]) / 2;
        } else {
            return nums[index];
        }
    }

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了82.51% 的用户
     * 内存消耗：39.3 MB, 在所有 Java 提交中击败了98.50% 的用户
     *
     * @author JJ
     * @date 2021/4/3 11:14
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m == 0) {
            if (n > 1) {
                return getMedian(nums2, n, n / 2);
            } else {
                return nums2[0];
            }
        }

        if (n == 0) {
            if (m > 1) {
                return getMedian(nums1, m, m / 2);
            } else {
                return nums1[0];
            }
        }

        int midIndex = (m + n) / 2;
        int i = 0, j = 0;

        int[] temp = new int[m + n];
        int index = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                temp[index] = nums1[i];
                i++;
            } else {
                temp[index] = nums2[j];
                j++;
            }
            if (index == midIndex) {

                return getMedian(temp, m + n, index);
            }

            index++;
        }
        while (i < m) {
            temp[index] = nums1[i];
            if (index == midIndex) {
                return getMedian(temp, m + n, index);
            }
            index++;
            i++;
        }

        while (j < n) {
            temp[index] = nums2[j];
            if (index == midIndex) {
                return getMedian(temp, m + n, index);
            }
            index++;
            j++;
        }

        return 0.0;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int[] merged = new int[total];

        /*
        抽取为 两数组合并 问题
         */
        //遍历nums1,nums2
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if(nums1[i]<=nums2[j]){
                merged[k]=nums1[i];
                i++;
            }else{
                merged[k]=nums2[j];
                j++;
            }
            k++;
        }
        while(i<nums1.length){
            merged[k]=nums1[i];
            i++;
            k++;
        }
        while(j<nums2.length){
            merged[k]=nums2[j];
            k++;
            j++;
        }

        double median=0;
        /*
         求出中位数,并保留指定小数位
         */
        if (total % 2 == 0) {
            //从merged[]找到第total/2-1, total/2这两个数
            median=(double)(merged[total/2-1]+merged[total/2])/2;
        } else {
            //从merged[]开始找到第total/2个数
            median=merged[total/2];
        }
        return median;
    }

    @Test
    public void test(){
        System.out.println(findMedianSortedArrays(new int[] {1, 3}, new int[] {2}));
        System.out.println(findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4}));
        System.out.println(findMedianSortedArrays(new int[] {0, 0}, new int[] {0, 0}));
        System.out.println(findMedianSortedArrays(new int[] {}, new int[] {1}));
        System.out.println(findMedianSortedArrays(new int[] {2}, new int[] {}));
    }
}
