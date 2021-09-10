import java.util.Arrays;

public class Board {

    public static void printBoard(char [][] board,int row,int column){
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void fillBoard(char [][] board){
        for(char[] row:board)
            Arrays.fill(row,'-');
    }
    public static int isFull(char[][] board, int indexX, int indexY) {
        if (board[indexX][indexY] == 'X' || board[indexX][indexY] == 'O') {
            return 1;
        }
        return 0;
    }
}
