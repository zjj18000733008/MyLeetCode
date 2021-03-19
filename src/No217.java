import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author JJ
 * @date 2020/7/31 - 21:42
 */
public class No217 {
    //10ms 25%
//    public boolean containsDuplicate(int[] nums) {
//        HashMap<Integer, Boolean> map = new HashMap<>();
//        for(int i=0;i<nums.length;i++){
//            if(map.get(nums[i])==null ){
//                map.put(nums[i],true);
//            }else{
//                return true;
//            }
//        }
//        return false;
//    }

    //7ms 66%
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> res = new HashSet<Integer>();
        for(int i:nums)
            res.add(i);
        return res.size()<nums.length?true:false;
    }


}
