import java.util.Stack;

/**
 * 有效的括号
 * @author JJ
 * @date 2020/7/16 - 16:07
 */
public class No20 {

    public static void main(String[] args) {
        No20 no = new No20();
        System.out.println(no.isValid("()"));
        System.out.println(no.isValid("()[]{}"));
        System.out.println(no.isValid("(]"));
        System.out.println(no.isValid("([)]"));
        System.out.println(no.isValid("{[]}"));
        System.out.println(no.isValid("["));
    }

    public boolean isValid(String s){

        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case '(':
                    stack.push('(');break;
                case '[':
                    stack.push('[');break;
                case '{':
                    stack.push('{');break;
                case ']':
                    if(stack.size()==0 || stack.pop()!='['){
                        return false;
                    }
                    break;
                case ')':
                    if(stack.size()==0 ||stack.pop()!='('){
                        return false;
                    }
                    break;
                case '}':
                    if(stack.size()==0 ||stack.pop()!='{'){
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        if(stack.size()==0){
            return true;
        }else{
            return false;
        }
    }
}
