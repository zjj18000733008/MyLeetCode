/**
 * @author JJ
 * @date 2020/8/4 - 16:50
 */
public class No263 {

    public boolean isUgly(int num) {
        if(num==1)return true;
        if(num==0)return false;
        while(true){
            if(num%2==0){
                if(num==2)break;
                num/=2;
            }else if(num%3==0){
                if(num==3)break;
                num/=3;
            }else if(num%5==0){
                if(num==5)break;
                num/=5;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No263 no = new No263();
        System.out.println(-1%2);
    }
}
