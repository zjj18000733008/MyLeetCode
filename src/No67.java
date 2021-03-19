/**
 * @author JJ
 * @date 2020/7/27 - 10:30
 */
public class No67 {

    public static void main(String[] args) {
    }

    public String addBinary(String a, String b) {

        int ca=0;
        StringBuilder ans=new StringBuilder();
        for(int i=a.length()-1,j=b.length()-1;i>=0 || j>=0;i--,j--){
            int sum=ca;
            sum+=(i>=0?a.charAt(i)-'0':0);
            sum+=(j>=0?b.charAt(j)-'0':0);
            ans.append(sum%2);
            ca=sum/2;
        }
        ans.append(ca==1?ca:"");
        return ans.reverse().toString();

    }
}
