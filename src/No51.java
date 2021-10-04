import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * N皇后
 * @author JJ
 * @date 2021/4/2 - 10:45
 */
public class No51 {

    public static void main(String[] args) {
        No51 no = new No51();
        List<List<String>> lists = no.solveNQueens(4);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.printf("%s \n",s);
            }
            System.out.println("=====");
        }
        System.out.println(lists.size());
    }

    List<List<String>> lists = new ArrayList<>();

    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了62.45% 的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了57.15% 的用户
     * @author JJ
     * @date 2021/4/3 10:15
     */
    public List<List<String>> solveNQueens(int n) {

        int[][] plate = new int[n][n];
        int[] row=new int[n];
        int[] col=new int[n];
        int[] leftUpToRightBottom=new int[(n-1)*2+1];
        int[] rightUpToLeftBottom=new int[(n-1)*2+1];
        backtrack(plate,row,col,0,leftUpToRightBottom,rightUpToLeftBottom);
        return lists;
    }

    public void backtrack(int[][] plate,int[] row,int[] col,int count,int[] leftUpToRightBottom,int[] rightUpToLeftBottom ) {
        int n=plate.length;
        if(count==plate.length){
            List<String> list = outputPlate(plate);
            lists.add(list);
            return;
        }

        for (int i = 0; i <n ; i++) {
            if(row[i]==1){//如果第i行已被访问过
                continue;
            }

            for (int j = 0; j < n; j++) {
//                if(col[j]==1 || IsThereAQueenOnTheHypotenuse(plate,i,j)){//如果第j列已被访问过或者斜边上有皇后
//                    continue;
//                }
                if(col[j]==1 || leftUpToRightBottom[i+j]==1|| rightUpToLeftBottom[i-j+n-1]==1){
                    continue;
                }
                row[i]=1;
                plate[i][j]=1;

                col[j]=1;
                leftUpToRightBottom[i+j]=1;
                rightUpToLeftBottom[i-j+n-1]=1;
                backtrack(plate,row,col,count+1,leftUpToRightBottom,rightUpToLeftBottom);
                plate[i][j]=0;
                row[i]=0;
                col[j]=0;
                leftUpToRightBottom[i+j]=0;
                rightUpToLeftBottom[i-j+n-1]=0;
            }
            if(row[i]==0){//如果当前行的每一列都不能放, 则直接return回退
                return;
            }

        }
    }

    public List<String> outputPlate(int[][] plate){
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < plate.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < plate[i].length; j++) {
                if(plate[i][j]==0){
                    sb.append(".");
                }else{
                    sb.append("Q");
                }
            }
            list.add(sb.toString());
        }
        return list;
    }

    public boolean IsThereAQueenOnTheHypotenuse(int[][] plate, int row, int col) {

        int n = plate.length;
        int i = row, j = col;

        if(row-1>=0 && j+1<n){
            do{//向右上找
                i--;
                j++;
                if(plate[i][j]==1){
                    return true;
                }
            }while(i>0 && j<n-1);
            i=row;
            j=col;
        }

        if(row+1<n && col+1<n){
            do{//向右下找
                i++;
                j++;
                if(plate[i][j]==1){
                    return true;
                }
            }while(i<n-1 && j<n-1);
            i=row;
            j=col;
        }

       if(row-1>=0 && col-1>=0){
           do{//向左上找
               i--;
               j--;
               if(plate[i][j]==1){
                   return true;
               }
           }while(i>0 && j>0);
           i=row;
           j=col;
       }

        if(row+1<n && col-1>=0){
            do{//向左下找
                i++;
                j--;
                if(plate[i][j]==1){
                    return true;
                }
            }while(i<n-1 && j>0);
        }

        return false;
    }
}
