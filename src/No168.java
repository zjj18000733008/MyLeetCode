import java.util.Stack;

/**
 * @author JJ
 * @date 2020/7/30 - 14:50
 */
public class No168 {

    public String converToTitle(int n){
        Stack<Character> stack = new Stack<>();
        while(n!=0){
            if(n%26==0){
                stack.add(((char)(25+'A')));
                n=n/26-1;
            }else{
                stack.add((char)(n%26-1+'A'));
                n/=26;
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        No168 no = new No168();
        String s = no.converToTitle(28);
        System.out.println(s);
    }
}
