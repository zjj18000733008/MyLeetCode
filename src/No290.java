import java.util.HashMap;

/**
 * @author JJ
 * @date 2020/8/5 - 16:22
 */
public class No290 {

    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if(pattern.length()!=strs.length){
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            String s = map.get(pattern.charAt(i));
            if(s==null){
                if(map.containsValue(strs[i])){
                    return false;
                }else{
                    map.put(pattern.charAt(i),strs[i]);
                }
            }else{
                if(!s.equals(strs[i])){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No290 no = new No290();
//        boolean b = no.wordPattern("abba", "dog cat cat dog");
        boolean b = no.wordPattern("abba", "dog dog dog dog");
        System.out.println(b);
    }
}
