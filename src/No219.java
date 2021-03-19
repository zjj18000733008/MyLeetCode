import java.util.HashMap;

/**
 * @author JJ
 * @date 2020/7/31 - 22:03
 */
public class No219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n= nums.length;
        if(k<=0 || n==0)return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int t=nums[i];
            if(map.get(t)!=null && i-map.get(t)<=k) return true;
            map.put(t,i);
        }
        return false;
    }
    //9ms 91%
//        public boolean containsNearbyDuplicate(int[] nums, int k) {
//            int n = nums.length;
//            if(k == 0) return false;
//            if(n <= 0) return false;
//            HashMap<Integer, Integer> map = new HashMap<>();
//            for(int i=0;i<n;i++){
//                if(map.get(nums[i]) != null && (i - map.get(nums[i])) <= k) return true;
//                map.put(nums[i], i);
//            }
//            return false;
//        }
}
