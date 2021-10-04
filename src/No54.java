import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import jdk.nashorn.internal.runtime.linker.LinkerCallSite;

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

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：36.3 MB, 在所有 Java 提交中击败了88.90% 的用户
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder2(int[][] matrix){

        /*
        转向条件:
        1. 下个元素是越界
        2. 下个元素被访问过
            2.1 可以创建一个跟matrix行列数相等的数组来记录元素是否被访问过
            2.2 由于matrix中元素最大值为100, 我们可以将访问过的元素设置为200, 起到标记的作用

        旋转方向:
        先往右, 以后每次顺时针转90°

        什么情况下表示全部遍历完了?
        计数.
         */

        // 0右, 1下, 2左, 3上
        int direction=0;
//        int[][] visited = Arrays.copyOf(matrix, matrix.length);
        int i=0;
        int j=-1;
        List<Integer> list = new ArrayList<>();
        int m=matrix.length;
        int n=matrix[0].length;
        int count=0;
        int total=m*n;

        while(true){

            if(count==total){
                break;
            }


            if(direction%4==0){
                j++;
                if(j>=n || matrix[i][j]==200){
                    direction++;
                    j--;
                    // 交给下次移动
                    continue;
                }
            }else if(direction%4==1){
                i++;
                if(i>=m || matrix[i][j]==200){
                    direction++;
                    i--;
                    continue;
                }
            }else if(direction%4==2){
                j--;
                if (j < 0 || matrix[i][j] == 200) {
                    direction++;
                    j++;
                    continue;
                }
            }else {
                i--;
                if ( i<0 || matrix[i][j]==200 ) {
                    direction++;
                    i++;
                    continue;
                }
            }

            list.add(matrix[i][j]);
            matrix[i][j]=200;
            count++;

        }


        return list;
    }

    @Test
    public void test(){
        List<Integer> list = spiralOrder2(new int[][] {
                {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}
        });
        for (Integer i : list) {
            System.out.print(i+" ");
        }
    }

//    public boolean needTurn()

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
