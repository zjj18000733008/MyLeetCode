import java.util.*;

/**
 * @author JJ
 * @date 2020/8/19 - 22:37
 */
public class No39 {

    List<List<Integer>> lists = new ArrayList<>();

    //执行用时：496 ms, 在所有 Java 提交中击败了5.01% 的用户
    //内存消耗：40.4 MB, 在所有 Java 提交中击败了10.83% 的用户
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        backtrack(list, 0, candidates, target);
        return lists;
    }

    private void backtrack(List<Integer> list, int sum, int[] candidates, int target) {
        if (sum > target) {
            return;
        } else if (sum == target) {
            if (!isDulplicate(list)) {
                lists.add(list);
            }
        } else {
            for (int i = 0; i < candidates.length; i++) {
                List<Integer> list1 = new ArrayList<Integer>(list.size());
                list1.addAll(list);
                list1.add(candidates[i]);
                backtrack(list1, sum + candidates[i], candidates, target);
            }
        }
    }

    private boolean isDulplicate(List<Integer> listi) {
        for (List<Integer> list : lists) {
            int[] arr = new int[200];
            for (Integer i : list) {
                arr[i]++;
            }
            for (Integer i : listi) {
                arr[i]--;
            }
            boolean notAllZero = false;
            for (int i : arr) {
                if (i != 0) {
                    notAllZero = true;
                    break;
                }
            }
            if (!notAllZero) {//表示有重复的
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        No39 no = new No39();
//        int[] arr={2,3,6,7};
//        List<List<Integer>> lists = no.combinationSum(arr, 7);
        int[] arr = {3, 5, 7};
        List<List<Integer>> lists = no.combinationSum(arr, 10);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }


}

class No39_2 {

    List<List<Integer>> lists = new ArrayList<>();

    //执行用时：9 ms
    //内存消耗：40.4 MB
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Arrays.sort(candidates);
        backtrack(new ArrayList<Integer>(), 0, target, candidates, 0);
        return lists;
    }

    private void backtrack(List<Integer> list, int sum, int target, int[] candidates, int start) {
        if (target < 0) return;
        if (sum > target) {
            return;
        } else if (sum == target) {
            lists.add(list);
        } else {
            for (int i = start; i < candidates.length; i++) {
                ArrayList<Integer> list_i = new ArrayList<>(list);
                list_i.add(candidates[i]);
                backtrack(list_i, sum + candidates[i], target, candidates, i);
            }
        }
    }

    public static void main(String[] args) {
        No39_2 no = new No39_2();
        int[] arr = {2, 3, 6, 7};
        List<List<Integer>> lists = no.combinationSum(arr, 7);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

class No39_3 {
    List<List<Integer>> lists = new ArrayList<>();

    //执行用时：4 ms, 在所有 Java 提交中击败了54.09% 的用户
    //内存消耗：40 MB, 在所有 Java 提交中击败了52.83% 的用户
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        Arrays.sort(candidates);
        backtrack(new ArrayList<Integer>(), 0, target, candidates, 0);
        return lists;
    }

    private void backtrack(List<Integer> list, int sum, int target, int[] candidates, int start) {
        if (sum > target) {
            return;
        } else if (sum == target) {
            lists.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < candidates.length; i++) {

                list.add(candidates[i]);
                backtrack(list, sum + candidates[i], target, candidates, i);
                list.remove(list.size() - 1);
            }
        }
    }
}

class No39_4 {

    List<List<Integer>> lists = new ArrayList<>();
    boolean flag = false;

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了99.92% 的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了81.99% 的用户
     * @author JJ
     * @date 2021/3/26 13:33
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        backtrack(new ArrayList<>(), candidates, target, 0, 0);

        return lists;
    }

    public void backtrack(List<Integer> list, int[] candidates, int target, int sum, int start) {
        if (sum > target) {
            flag = true;
            return;
        }
        if (sum == target) {
            flag = true;
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);

            backtrack(list, candidates, target, sum + candidates[i], i);

            list.remove(list.size() - 1);

            if(flag){//如果前面sum已经大于或等于target,就不再遍历了
                flag=false;
                break;
            }
        }
    }

    public static void main(String[] args) {
        No39_4 no = new No39_4();
        int[] arr = {2, 3, 6, 7};
        List<List<Integer>> lists = no.combinationSum(arr, 7);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
