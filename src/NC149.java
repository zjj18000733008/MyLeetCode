import sun.applet.Main;

/**
 * @author JJ
 * @date 2021/3/23 - 19:44
 */
public class NC149 {

    public static void main(String[] args) {
        NC149 nc149 = new NC149();
        System.out.println(nc149.kmp("ababab", "abababab"));
    }
    /**
     * 运行时间：706ms
     * 超过4.04%用Java提交的代码
     * 占用内存：14304KB
     * 超过75.31%用Java提交的代码
     * @author JJ
     * @date 2021/3/23 20:00
     */
    public int kmp(String S, String T) {

        int count = 0;

        int[] next = getNext(S);
        for (int i = 0, j = 0; i < T.length(); i++) {

            while (j > 0 && T.charAt(i) != S.charAt(j)) {
                j = next[j - 1];
            }
            if (T.charAt(i) == S.charAt(j)) {
                j++;
            }
            if (j == S.length()) {
                count++;
                i=next[i-j+1];
                j=0;
//                System.out.println(i);
            }
        }

        return count;
    }

    public int[] getNext(String pattern) {

        int[] next = new int[pattern.length()];

        for (int i = 0, j = 1; i < pattern.length(); i++) {

            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }

            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }

            next[i] = j;

        }
        return next;
    }
}
