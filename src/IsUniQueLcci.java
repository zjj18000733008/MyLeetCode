import java.util.HashMap;
import java.util.HashSet;

/**
 * Description:
 *
 * @author zhongjunjie01
 * @Date: 2021/8/16
 */
public class IsUniQueLcci {
    public boolean isUnique(String astr) {

        HashSet<Character> set = new HashSet<>();
        char[] strs = astr.toCharArray();
        for (int i = 0; i < strs.length; i++) {
            if (set.contains(strs[i])) {
                return false;
            }
            set.add(strs[i]);
        }

        return true;
    }
}
