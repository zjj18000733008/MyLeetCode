import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author JJ
 * @date 2020/8/20 - 14:18
 */
public class No47 {

    List<List<Integer>> lists=new ArrayList<>();
    HashSet<List<Integer>> set=new HashSet<>();
    //执行用时：32 ms, 在所有 Java 提交中击败了15.47% 的用户
    //内存消耗：40.2 MB, 在所有 Java 提交中击败了91.09% 的用户
    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] visited=new int[nums.length];
        backtrack(new ArrayList<>(),nums,visited,0);
        return lists;
    }

    private void backtrack(List<Integer> list,int[] nums,int[] visited,int count){
        if(count==nums.length){
            if(!set.contains(list)) {
                ArrayList<Integer> list1 = new ArrayList<>(list);
                lists.add(list1);
                set.add(list1);

            }
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(visited[i]==1)continue;
            list.add(nums[i]);
            visited[i]=1;
            backtrack(list,nums,visited,count+1);
            list.remove(list.size()-1);
            visited[i]=0;
        }

    }

    public static void main(String[] args) {
        No47 no = new No47();
        int[] arr={1,1,2};
        List<List<Integer>> lists = no.permuteUnique(arr);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
}
class No47_2{
    //执行用时：2 ms, 在所有 Java 提交中击败了76.43% 的用户
    //内存消耗：40.7 MB, 在所有 Java 提交中击败了12.39% 的用户
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean st[] = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums,st,res,path,0);
        return res;
    }

    private void dfs(int[] nums, boolean[] st, List<List<Integer>> res, List<Integer> path, int u) {
        if(path.size() == nums.length)
        {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0 ; i < nums.length ; i++ )
        {
            if(!st[i])
            {
                if(i > 0 && nums[i - 1] == nums[i] && !st[i-1]) continue;
                path.add(nums[i]);
                st[i] = true;
                dfs(nums,st,res,path,u+1);
                st[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}