/**
 * @author JJ
 * @date 2020/7/31 - 18:06
 */
public class No204 {

    public int countPrimes(int n) {

//        int count=0;
//        int t=2;
//        int i=2;
//        while(t<=n){
//            count++;
//            t=2*i;
//            i++;
//        }
//        t=3;
//        i=3;
//        while(t<=n){
//            count++;
//            t=3*i;
//            i++;
//        }
//        t=5;
//        i=
//        return count;
        if(n<3)return 0;
        int[] arr=new int[n];//默认为0,1代表不是质数
        arr[0]=1;
        arr[1]=1;
        /**
         * 埃拉托斯特尼筛法在当前值的平方大于n时，就不必再继续划去他的倍数了，
         * 可以在循环前加入判断，加快执行时间。
         */
        //删除2,3,5,7,...11,13...的倍数,剩下的就是质数
        for(int i=2;i<=Math.sqrt(n);i++){
            for(int m=2;m*i<n;m++){
                arr[m*i]=1;
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            count+=arr[i];//统计不是质数的个数
        }

        return n-count;
    }

    public static void main(String[] args) {
        No204 no = new No204();
        int i = no.countPrimes(130);
        System.out.println(i);
    }
}
