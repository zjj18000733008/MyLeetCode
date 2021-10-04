/**
 * 最后一个单词的长度
 * @author JJ
 * @date 2020/7/19 - 8:48
 */
public class No58 {

    public static void main(String[] args) {
        No58 no = new No58();
        int hello_world = no.lengthOfLastWord("he ");
        System.out.println(hello_world);
    }

    //AC
//    public int lengthOfLastWord(String s){
//        int count=0;
//        s = s.trim();
//        for(int i=s.length()-1;i>=0;i--){
//            if(s.charAt(i)==' '){
//                break;
//            }
//            count++;
//        }
//        return count;
//    }

    public int lengthOfLastWord(String s){

        int lastLetter=s.length()-1;
        int blank=-1;

        if("".equals(s)){
            return 0;
        }

        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)!=' '){
                lastLetter=i;
                break;
            }
        }
        for(int i=lastLetter;i>=0;i--){
            if(s.charAt(i)==' '){
                blank=i;
                break;
            }
        }
        return lastLetter-blank;
    }
}
