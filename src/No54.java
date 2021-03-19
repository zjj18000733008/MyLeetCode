import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JJ
 * @date 2020/8/23 - 20:55
 */
public class No54 {
    //执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
    //内存消耗：37.3 MB, 在所有 Java 提交中击败了95.93% 的用户
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length==0)return new ArrayList<>();
        int m=matrix.length;
        int n=matrix[0].length;
        List<Integer> list=new ArrayList<>();
        boolean do_n=true,sub_2=false;//do_n 用于控制是操作行j还是列k,sub_2用于确定是做减法还是加法
        int up=1,down=m-1,left=0,right=n-1;//定义边界
        int j=0,k=-1;//行j,列k
        for (int i = 0; i < m * n; i++) {
            if(do_n){
                if(sub_2){//做减法
                    k--;
                    if(k==left){
                        left++;
                        do_n=false;
                    }
                }else{//做加法
                   k++;
                   if(k==right){//到边界了,下一次该改变方向了,以及边界需要更新了
                       right--;//更新边界
                       do_n=false;//改变方向
                   }
                }

            }else{
                if(sub_2){
                    j--;
                    if(j==up){
                        up++;
                        do_n=true;
                        sub_2=sub_2?false:true;
                    }
                }else{
                    j++;
                    if(j==down){
                        down--;
                        do_n=true;
                        sub_2=sub_2?false:true;
                    }
                }


            }
            list.add(matrix[j][k]);
        }
        return list;
    }

    public static void main(String[] args) {
        No54 no = new No54();
//        int[][] arr={
//                {1,2,3},
//                {4,5,6},
//                {7,8,9}
//        };
        int[][] arr={
                {1,2,3,4},
                {12,13,14,5},
                {11,16,15,6},
                {10,9,8,7}
        };
        List<Integer> list = no.spiralOrder(arr);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
