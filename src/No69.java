/**
 * @author JJ
 * @date 2020/7/27 - 12:08
 */
public class No69 {

    public static void main(String[] args) {
        No69 no = new No69();
//        System.out.println(no.mySqrt(2147395600));
        System.out.println(no.mySqrt(8));
    }

//    public int mySqrt(int x) {
//
//        for(long i=1;i<Integer.MAX_VALUE;i++){
//            if(x<i*i){
//                return (int)(i-1);
//            }
//        }
//        return 0;
//    }

    public int mySqrt(int x){
        int left=0;
        int right=x;
        while(left<=right){
            long mid=(left+right)/2;
            if(mid*mid==x){
                return (int)mid;
            }else if(mid*mid<x){
                left=(int)mid+1;
            }else{
                right=(int)mid-1;
            }
        }
        return right;
    }

}
