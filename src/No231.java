/**
 * 判断一个整数是否是2的幂次方
 * @author JJ
 * @date 2020/8/1 - 9:10
 */
public class No231 {

    //解法一
    public boolean isPowerOfTwo(int n) {
        /**
         * 解释：
         * 2的幂次方在二进制下，只有1位是1，其余全是0。
         * 例如:8---00001000。
         * 负数的在计算机中二进制表示为补码
         * (原码->正常二进制表示，原码按位取反(0-1,1-0)，最后再+1。
         * 然后两者进行与操作，得到的肯定是原码中最后一个二进制的1。
         * 例如8&(-8)->00001000 & 11111000 得 00001000，即8。
         * 建议自己动手算一下，按照这个流程来一遍，加深印象。
         */
        return n>0 && (n&-n)==n;
    }

    //解法二
//    public boolean isPowerOfTwo(int n){
//        /**
//         * 移位运算：把二进制数进行左右移位。左移1位，扩大2倍；右移1位，缩小2倍。
//         * 1<<30得到最大的2的整数次幂，对n取模如果等于0，说明n只有因子2。
//         */
//        return (n>0) && (1<<30)%n==0;
//    }

    public static void main(String[] args) {
        No231 no = new No231();
        boolean powerOfTwo = no.isPowerOfTwo(1);
        System.out.println(powerOfTwo);
    }
}
