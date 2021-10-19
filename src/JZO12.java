import org.junit.Assert;
import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie
 * @Date: 2021/10/13
 */
public class JZO12 {

    /**
     * 85/87 , 最后案例超时
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;
        char c = word.charAt(0);
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == c){
                    visited[i][j]=1;
                    if(1 >= word.length() || backtrace(board, visited, word, i, j, 1)){
                        return true;
                    }
                    visited[i][j]=0;
                }
            }
        }

        return false;
    }

    public boolean backtrace(char[][] board, int[][] visited, String word, int i, int j, int p) {

        int m = board.length;
        int n = board[0].length;
        char c = word.charAt(p);

        boolean leftFlag = false;
        boolean belowFlag = false;
        boolean rightFlag = false;
        boolean upFlag = false;

        //left
        if (j - 1 >= 0 && visited[i][j - 1] != 1 && board[i][j - 1] == c) {
            visited[i][j - 1] = 1;
            if (p == word.length() - 1) {
                return true;
            }
            leftFlag = backtrace(board, visited, word, i, j - 1, p + 1);
            visited[i][j - 1] = 0;
        }

        //below
        if (i + 1 < m && visited[i + 1][j] != 1 && board[i + 1][j] == c) {
            visited[i + 1][j] = 1;
            if (p == word.length() - 1) {
                return true;
            }
            belowFlag = backtrace(board, visited, word, i + 1, j, p + 1);
            visited[i + 1][j] = 0;
        }

        //right
        if (j + 1 < n && visited[i][j + 1] != 1 && board[i][j + 1] == c) {
            visited[i][j + 1] = 1;
            if (p == word.length() - 1) {
                return true;
            }
            rightFlag = backtrace(board, visited, word, i, j + 1, p + 1);
            visited[i][j + 1] = 0;
        }

        //up
        if (i - 1 >= 0 && visited[i - 1][j] != 1 && board[i - 1][j] == c) {
            visited[i - 1][j] = 1;
            if (p == word.length() - 1) {
                return true;
            }
            upFlag = backtrace(board, visited, word, i - 1, j, p + 1);
            visited[i-1][j]=0;
        }

        return leftFlag || belowFlag || rightFlag || upFlag;

    }

    @Test
    public void test() {
        Assert.assertTrue(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCCED"));
        Assert.assertTrue(exist(new char[][]{{'a'}},"a"));
        Assert.assertFalse(exist(new char[][]{{'a','a'}},"aaa"));
        Assert.assertTrue(exist(new char[][]{{'a','b'}},"ba"));
        Assert.assertTrue(exist(new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}},"ABCESEEEFS"));


//        System.out.println("[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"E\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]".replace(
//                "[", "{").replace("]", "}").replace("\"", "\'"));
    }
}
