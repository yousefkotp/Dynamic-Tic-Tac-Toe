public class CheckWinner {
    static int state = 0;

    public static void checkRow(char[][] board,char type,int row,int column) {
        int i,j;
        for (i = 0; i < row; i++) {
            for (j = 0; j < column-2; j++) {
                if (board[i][j]==board[i][j+1] && board[i][j]==board[i][j+2] && board[i][j] == type){
                    state= 1;
                }
            }
        }
    }

    public static void checkCol(char [][] board,char type,int row,int column){
        int i,j;
        for( i=0;i<column;i++){
            for(j=0;j<row-2;j++){
                if(board[j][i] == board[j+1][i] && board[j][i] == board[j+2][i] && board[j][i] == type){
                    state= 1;
                }
            }
        }
    }

    public static void checkDiagonal(char [][] board, char type,int row,int column){
        int i,j;
        for(i=0;i<row-2;i++){
            for(j=0;j<column-2;j++) {
                if (board[i][j] == board[i + 1][j + 1] && board[i][j] == board[i + 2][j + 2] && board[i][j] == type)
                    state = 1;

            }
        }
        for(i=row-1;i>1;i--){
            for(j=0;j<column-2;j++) {
                if (board[i][j] == board[i - 1][j + 1] && board[i][j] == board[i - 2][j + 2] && board[i][j] == type)
                    state = 1;

            }
        }
    }
    public static int checkDraw(char[][] board,int row,int column){
        int i,j;
        for(i=0;i<row;i++){                   //iterating through the whole 2-D array
            for(j=0;j<column;j++){
                if(board[i][j] == '-')
                    return 0;
            }
        }
        return 1;
    }

}
