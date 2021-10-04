import java.util.HashMap;
import java.util.concurrent.ForkJoinPool;

/**
 * @author JJ
 * @date 2020/10/6 - 18:59
 */
public class No36 {

    public boolean isValidSudoku(char[][] board) {
        /*
            0   1   2
            3   4   5
            6   7   8
            box_index=(row/3)*3+col*3
         */
        //可以利用 value -> count 哈希映射来跟踪所有已经遇到的值。
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] cols = new HashMap[9];

        //初始化
        for (int i = 0; i < 9; i++) {
            boxes[i]=new HashMap<Integer,Integer>();
            rows[i]=new HashMap<Integer,Integer>();
            cols[i]=new HashMap<Integer,Integer>();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char num=board[i][j];
                if(num!='.'){
                    int n=num-0;
                    int box_index=(i/3)*3+j/3;
                    rows[i].put(n,rows[i].getOrDefault(n,0)+1);
                    cols[j].put(n,cols[j].getOrDefault(n,0)+1);
                    boxes[box_index].put(n,boxes[box_index].getOrDefault(n,0)+1);

                    if(rows[i].getOrDefault(n,0)>1 || cols[j].getOrDefault(n,0)>1 || boxes[box_index].getOrDefault(n,0)>1){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku1(char[][] board) {
        for (char[] chars : board) {
            int[] flag=new int[10];
            for (char c : chars) {
                if(c!='.'){
                    if(flag[c-'0']==1){
                        return false;
                    }else {
                        flag[c - '0'] = 1;
                    }
                }
            }
        }

        for (int col = 0; col < 9; col++) {
            int[] flag=new int[10];
            for (int row = 0; row < 9; row++) {
                char c=board[row][col];
                if(c!='.'){
                    if(flag[c-'0']==1){
                        return false;
                    }else {
                        flag[c - '0'] = 1;
                    }
                }
            }
        }

        for (int row = 0; row <=6; row+=3) {
            int[] flag=new int[10];
            for (int col = 0; col <=6; col+=3) {

            }
        }

        return true;
    }
}
