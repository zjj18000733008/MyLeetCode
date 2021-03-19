import sun.plugin.dom.core.CoreConstants;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author JJ
 * @date 2020/8/25 - 12:32
 */
public class No79 {

    public static void main(String[] args) {
        No79 no = new No79();
        char[][] arr = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        boolean exist = no.exist(arr, "SEE");
        System.out.println(exist);
    }

    public boolean exist(char[][] board, String word) {
//        ArrayList<Integer> list = new ArrayList<>();

        int len = word.length();
        char captital = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == captital) {
                    int[][] visited = new int[board.length][board[0].length];
                    visited[i][j] = 1;
                    int k = 1;
                    int x = i, y = j;
                    while (k < len) {
                        Coordinate next = fun(board, visited, new Coordinate(x, y), word.charAt(k));
                        if (next == null) {
                            break;
                        } else {
                            k++;
                            x = next.x;
                            y = next.y;
                            visited[x][y] = 1;
                        }
                    }
                    if (k == len) {//全都找到了
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private Coordinate fun(char[][] board, int[][] visited, Coordinate cur, char target) {
        int x = cur.x;
        int y = cur.y;
        if (y > 0 && visited[x][y - 1] != 1 && board[x][y - 1] == target) {//向上找
            return new Coordinate(x, y - 1);
        }
        if (y < board.length - 1 && visited[x][y + 1] != 1 && board[x][y + 1] == target) {//向下
            return new Coordinate(x, y + 1);
        }
        if (x > 0 && visited[x - 1][y] != 1 && board[x - 1][y] == target) {//向左
            return new Coordinate(x - 1, y);
        }
        if (x < board[0].length - 1 && visited[x + 1][y] != 1 && board[x + 1][y] == target) {//向右
            return new Coordinate(x + 1, y);
        }
        return null;
    }

    private class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

class No79_2 {
    public boolean exist(char[][] board, String word) {
        return false;
    }

    private void backtrack(char[][] board, int[][] visited, int count, Coordinate cur, String word) {
        if (count == 3) {//当前位置找不到下一个字符
            return;
        }
        int x = cur.x, y = cur.y;
        char target = word.charAt(0);
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 1:
                    if (y > 0 && visited[x][y - 1] != 1 && board[x][y - 1] == target) {//如果上面的元素没有访问过,且是目标值
                        visited[x][y - 1] = 1;
                        backtrack(board, visited, 0, new Coordinate(x, y - 1), word.substring(1));
                        visited[x][y - 1] = 0;
                    }
                    //如果递归下去能找到,将不会执行下面的句子
                    //但是如果找不到,说明这个方向不通,count+1表示一个方向已经判断了
                    count += 1;
                    break;
            }
        }

    }

    private class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

class No79_3 {

    /**
     *
     * 遍历二维数组,以二维数组的每一个元素为起点向四周扩散
     * 执行用时：7 ms, 在所有 Java 提交中击败了77.76% 的用户
     * 内存消耗：41.5 MB, 在所有 Java 提交中击败了83.40% 的用户
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (search(board, visited, word, 0, i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, int[][] visited, String word, int k, int x, int y) {
        if (k >= word.length()) return true;
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y] == 1 || board[x][y]!=word.charAt(k)) return false;
        visited[x][y] = 1;
        boolean res = search(board, visited, word, k + 1, x - 1, y) || search(board, visited, word, k + 1, x + 1, y)
                || search(board, visited, word, k + 1, x, y + 1) || search(board, visited, word, k + 1, x, y - 1);
        visited[x][y] = 0;
        return res;
    }

    public static void main(String[] args) {
        No79_3 no = new No79_3();
        char[][] arr = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        boolean exist = no.exist(arr, "ABCB");
        System.out.println(exist);
    }
}

class No79_4{

    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了85.87% 的用户
     * 内存消耗：40.3 MB, 在所有 Java 提交中击败了61.46% 的用户
     * @author JJ
     * @date 2021/1/13 15:59
     */
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        int[][] visited=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(board,word,visited,0,i,j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board,String word,int[][] visited,int k ,int x,int y){
        if(k>=word.length()){
            return true;
        }
        boolean result;
        if(x<0 || x>=board.length || y<0 || y>=board[0].length || visited[x][y]==1 || board[x][y]!=word.charAt(k))return false;
        visited[x][y]=1;
        result=search(board,word,visited,k+1,x,y+1) || search(board,word,visited,k+1,x,y-1)
                || search(board,word,visited,k+1,x+1,y) || search(board,word,visited,k+1,x-1,y);
        visited[x][y]=0;
        return result;
    }

}