/**
 * @author JJ
 * @date 2020/8/24 - 13:27
 */
public class No59 {

    //执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
    //内存消耗：37.5 MB, 在所有 Java 提交中击败了63.64% 的用户
    public int[][] generateMatrix(int n) {
        int i=0,j=-1;
        int up=1,down=n-1,left=0,right=n-1;
        boolean do_j=true,sub=false;

        int[][] res=new int[n][n];

        for(int k=1;k<=n*n;k++){
            if(do_j){
                if(sub){
                    j--;
                    if(j==left){
                        left++;
                        do_j=false;
                    }
                }else{
                    j++;
                    if(j==right){
                        right--;
                        do_j=false;
                    }
                }
            }else{
                if(sub){
                    i--;
                    if(i==up){
                        up++;
                        do_j=true;
                        sub=sub?false:true;
                    }
                }else{
                    i++;
                    if(i==down){
                        down--;
                        do_j=true;
                        sub=sub?false:true;
                    }
                }
            }
            res[i][j]=k;
        }
        return res;
    }

    public static void main(String[] args) {
        No59 no = new No59();
        int[][] ints = no.generateMatrix(3);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
