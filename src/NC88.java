/**
 * @author JJ
 * @date 2021/3/22 - 20:04
 */
public class NC88 {

    public static void main(String[] args) {
        NC88 nc88 = new NC88();
//        int[] a={1,3,5,2,2};
        int[] a = {1332802, 1177178, 1514891, 871248, 753214, 123866, 1615405, 328656, 1540395, 968891, 1884022, 252932, 1034406, 1455178, 821713, 486232, 860175, 1896237, 852300, 566715, 1285209, 1845742, 883142, 259266, 520911, 1844960, 218188, 1528217, 332380, 261485, 1111670, 16920, 1249664, 1199799, 1959818, 1546744, 1904944, 51047, 1176397, 190970, 48715, 349690, 673887, 1648782, 1010556, 1165786, 937247, 986578, 798663};
        nc88.findKth(a, 49, 24);
    }

    /**
     * 运行时间：37ms
     * 超过19.69%用Java提交的代码
     * 占用内存：11224KB
     * 超过4.09%用Java提交的代码
     * @author JJ
     * @date 2021/3/22 20:27
     */
    public int findKth(int[] a, int n, int K) {

        quickSort(a, 0, n - 1);
//        int count=0;
//        for (int i : a) {
//            System.out.printf("%d%10s\n",count++, i);
//        }
        return a[n-K];
    }

    public void quickSort(int[] a, int left, int right) {

        if (left > right) {
            return;
        }

        int i = left, j = right;
        int base = a[left];
        while (i < j) {

            while (i < j && a[j] >= base) {
                j--;
            }

            while (i < j && a[i] <= base) {
                i++;
            }


            int t = a[i];
            a[i] = a[j];
            a[j] = t;


        }

        a[left] = a[i];
        a[i] = base;
        quickSort(a, left, i - 1);
        quickSort(a, i + 1, right);
    }
}
