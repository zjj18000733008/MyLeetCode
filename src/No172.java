/**
 * @author JJ
 * @date 2020/7/30 - 19:17
 */
public class No172 {
    //此方法行不通
//    public int trailingZeroes(int n) {
//        long product=1;
//        int count=0;
//        for(int i=n;i>=1;i--){
//            product*=i;
//        }
//        while(product>=0){
//            if(product%10==0){
//                count++;
//                product/=10;
//            }else{
//                break;
//            }
//        }
//        return count;
//    }

    public int trailingZeroes(int n) {
        /**
         * 末尾有0的原因只能是2*5产生0,(4->2*2...)
         * 所以只用统计有多少对2*5,末尾就有多少个0
         * 又2的数量比5多,所以只用统计5的个数即可
         * 又5是每5个数就出现一次,所以有如下的统计方法
         */
        int count=0;
        while(n>=1){
            count+=n/5;
            n/=5;//这一步是考虑到25,125等带有多个乘法因子5
        }
        return count;
    }

    public static void main(String[] args) {
        No172 no = new No172();
        int i = no.trailingZeroes(13);
        System.out.println(i);
    }
}
