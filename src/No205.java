import java.util.HashMap;

/**
 * @author JJ
 * @date 2020/7/31 - 20:41
 */
public class No205 {

    //9ms 75%
    public boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            Character character = map.get(s.charAt(i));
            if(character==null){
                if(!map.containsValue(t.charAt(i))) {
                    map.put(s.charAt(i), t.charAt(i));
                }else{
                    return false;
                }
            }else{
                if(character!=t.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }
    //解法二 5ms 90%
//    public boolean isIsomorphic(String s, String t) {
//        // 字符总数是256
//        int[] preIndexOfS = new int[256];
//        int[] preIndexOfT = new int[256];
//        for (int i = 0; i < s.length(); i++) {
//            char sc = s.charAt(i), tc = t.charAt(i);
//            // 记录上一次出现的位置，如果上一次出现的位置不同，那么就是不同构的
//            if (preIndexOfS[sc] != preIndexOfT[tc]) {
//                return false;
//            }
//            // 避免为 0
//            preIndexOfS[sc] = i + 1;
//            preIndexOfT[tc] = i + 1;
//        }
//        return true;
//    }

    public static void main(String[] args) {
        No205 no = new No205();
//        boolean isomorphic = no.isIsomorphic("egg", "add");
        boolean isomorphic = no.isIsomorphic("foo", "bar");
        System.out.println(isomorphic);
    }
}
