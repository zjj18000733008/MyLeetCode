import java.lang.reflect.Array;
import java.util.Arrays;

import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie01
 * @Date: 2021/9/3
 */
public class No130 {

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了74.97% 的用户
     * 内存消耗：40.8 MB, 在所有 Java 提交中击败了6.74% 的用户
     * @param board
     */
    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        char[][] copyBoard = new char[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    copyBoard[i][j]='O';
                }
                board[i][j]='X';
            }
        }

        // 遍历原数组,找到处于边缘的字符'O'
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i != 0 && i!=m-1 && j!=0 && j!=n-1) {
                    continue;
                }else if( copyBoard[i][j]=='O' ){
                    // 从边缘字符'O'扩散,将能接触到的字符'O'所在位置标记
                    scan(i, j, copyBoard, board);
                }
            }
        }

    }

    public void scan(int i,int j,char[][] board,char[][] copyBoard){

        int m=board.length;
        int n =board[0].length;

        copyBoard[i][j]='O';
        // 向左
        if (j - 1 >= 0 && board[i][j-1]=='O') {
            copyBoard[i][j-1]='O';
            board[i][j-1]='X';
            scan(i, j-1, board, copyBoard);
        }

        // 右
        if (j + 1 < n && board[i][j + 1] == 'O') {
            copyBoard[i][j+1]='O';
            board[i][j+1]='X';
            scan(i, j+1, board, copyBoard);
        }

        // 上
        if (i - 1 >= 0 && board[i - 1][j] == 'O') {
            copyBoard[i-1][j]='O';
            board[i-1][j]='X';
            scan(i-1, j, board, copyBoard);
        }

        // 下
        if (i + 1 < m && board[i + 1][j] == 'O') {
            copyBoard[i+1][j]='O';
            board[i+1][j]='X';
            scan(i+1, j, board, copyBoard);
        }

    }

    @Test
    public void test(){
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solve(board);
    }
}
