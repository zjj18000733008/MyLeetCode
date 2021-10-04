/**
 * 外观数列
 * @author JJ
 * @date 2020/7/18 - 22:53
 */
public class No38 {

    public static void main(String[] args) {
        No38 no = new No38();
        String s = no.countAndSay(6);
        System.out.println(s);
    }

    public String countAndSay(int n){
        if(n==1){
            return "1";
        }
        if(n==2){
            return "11";
        }
        String s = countAndSay(n - 1);


        int count=1;
        char temp=s.charAt(0);
        StringBuffer str=new StringBuffer("");
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==temp){
                count++;
            }else{
                str.append(count+""+temp);
                temp=s.charAt(i);
                count=1;
            }
            if(i==s.length()-1){
                str.append(count+""+temp);
            }
        }



        return str.toString();
    }
}
