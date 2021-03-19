import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.Stack;

/**
 * 整数反转
 *
 * @author JJ
 * @date 2020/7/16 - 14:27
 */
public class No7 {

    public static void main(String[] args) {
        No7 no7 = new No7();
        System.out.println(Integer.MAX_VALUE);
        //                    2147483647
//        int i = no7.reverse(9646324351);
//        System.out.println(i);
    }

    public int reverse(int x) {

        String str = (x + "");
        String result = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && str.charAt(0) == '-') {
//                isNegetive = true;
                result+="-";
                continue;
            }
            stack.push(str.charAt(i));
        }

        if(stack.peek()==0){//如果栈顶是0,将其剔除
            stack.pop();
        }

        while(!stack.isEmpty()){
            result+=stack.pop();
        }

        Long n=Long.parseLong(result);
        if(n<-Integer.MIN_VALUE || n>Integer.MAX_VALUE){
            return 0;
        }
        return n.intValue();
    }
}
