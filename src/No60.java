import java.util.ArrayList;
import java.util.List;

/**
 * @author JJ
 * @date 2020/8/21 - 19:43
 */
public class No60 {

    private List<String> lists = new ArrayList<>();
    private boolean foundk = false;
    private int index = 0;
    private int k;

    //执行用时：1218 ms, 在所有 Java 提交中击败了8.12% 的用户
    //内存消耗：87.9 MB, 在所有 Java 提交中击败了5.07% 的用户
    public String getPermutation(int n, int k) {
        this.k = k;
        int[] visited = new int[n + 1];
        backtrack(new StringBuilder(), n, 0, visited);
        return lists.get(k - 1);
    }

    private void backtrack(StringBuilder sb, int n, int count, int[] visited) {
        if (count == n) {
            lists.add(sb.toString());
            index++;            ////
            if (k == index) {       //找到第k个数就不在往后找了,用于防止提交超时
                foundk = true;    //
            }                   ////
        } else if (!foundk) {//找到第k个数就不在往后找了,用于防止提交超时
            for (int i = 1; i <= n; i++) {
                if (visited[i] == 1) continue;
                sb.append(i);
                visited[i] = 1;
                backtrack(sb, n, count + 1, visited);
                visited[i] = 0;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        No60 no = new No60();
//        String permutation = no.getPermutation(9, 25996);
        String permutation = no.getPermutation(3, 3);
        System.out.println(permutation);
    }
}

class No60_2 {

    List<String> list = new ArrayList<>();
    private boolean foundk = false;
    private int index = 0;
    private int key;
//    执行用时：1694 ms, 在所有 Java 提交中击败了5.05% 的用户
//    内存消耗：97.1 MB, 在所有 Java 提交中击败了5.07% 的用户
    public String getPermutation(int n, int k) {
        int[] arr = {1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        int[] visited = new int[n + 1];
        if (n == 1) {
            return "1";
        }
//        int start=k/arr[n-2]+1;
        int start = k % arr[n - 2] == 0 ? k / arr[n - 2] : k / arr[n - 2] + 1;
        backtrack(new StringBuilder(), visited, 0, n, start);
        key = k % arr[n - 2] == 0 ? arr[n - 2] - 1 : k % arr[n - 2] - 1;
        return list.get(key);
    }

    private void backtrack(StringBuilder sb, int[] visited, int count, int n, int start) {
        if (count == n) {
            list.add(sb.toString());
            index++;
            if (key == index) {
                foundk = true;
            }
        } else if (!foundk) {
            for (int i = start; i <= n; i++) {
                if (visited[i] == 1) continue;
                sb.append(i);
                visited[i] = 1;
                backtrack(sb, visited, count + 1, n, 1);
                visited[i] = 0;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
//        int n=1;
//        int sum=0;
//        for (int i = 1; i <=9; i++) {
//            n*=i;
//            sum+=n;
//            System.out.println(n);
//            System.out.println("sum: "+sum);
//        }
        No60_2 no = new No60_2();
//        String permutation = no.getPermutation(3, 3);
        String permutation = no.getPermutation(2, 2);
//        String permutation = no.getPermutation(4, 9);
        System.out.println(permutation);
    }
}
