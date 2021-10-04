/**
 *实现strStr()函数
 * @author JJ
 * @date 2020/7/17 - 16:19
 */
public class No28 {

    public static void main(String[] args) {
        String haystack="";
        String needle="";
        No28 no = new No28();
        System.out.println(no.strStr(haystack,needle));
    }


//    public int strStr(String haystack,String needle){
//        int L = needle.length(), n = haystack.length();
//        for (int start = 0; start < n - L + 1; ++start) {
//            if (haystack.substring(start, start + L).equals(needle)) {//滑动窗口
//                return start;
//            }
//        }
//        return -1;
//    }

    //KMP
    public int strStr(String haystack,String needle){

        if("".equals(needle)){
            return 0;
        }

        int[] next = getNext(needle);

        for(int i=0,j=0;i<haystack.length();i++){

            while(j>0 && haystack.charAt(i)!=needle.charAt(j)){
                j=next[j-1];
            }

            if(haystack.charAt(i)==needle.charAt(j)){
                j++;
            }
            if(j==needle.length()){
                return i-j+1;
            }
        }

        return -1;
    }

    public static int[] getNext(String pattern){
        int[] next = new int[pattern.length()];

        for(int i=1,j=0;i<pattern.length();i++){

            while(j>0 && pattern.charAt(j)!=pattern.charAt(i)){
                j=next[j-1];
            }

            if(pattern.charAt(j)==pattern.charAt(i)){
                j++;
            }
            next[i]=j;
        }
        return next;
    }
}
