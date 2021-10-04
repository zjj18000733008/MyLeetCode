/**
 * @author JJ
 * @date 2020/8/4 - 14:25
 */
public class No242 {

    public boolean isAnagram(String s, String t) {
        int[] map=new int[30];
        if(s.length()!=t.length())return false;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
//            if(c>='A'&&c<='Z' || c>='a'&&c<='z'){
                map[(c&0xDF)-'A']++;
//            }
        }
        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
//            if(c>='A'&&c<='Z' || c>='a'&&c<='z'){
                map[(c&0xDF)-'A']--;
//            }
        }
        for(int i=0;i<map.length;i++){
            if(map[i]!=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No242 no = new No242();
        boolean anagram = no.isAnagram("a", "b");
        System.out.println(anagram);
    }
}
