import java.util.Scanner;
public class Player {
    public char type;
    public int indexX;
    public int indexY;
    public static int n=3,m=3;
    public Player(char type) {
        this.type = type;
    }

    public void setIndexX(int indexX) {
        this.indexX = indexX;
    }

    public void setIndexY(int indexY) {
        this.indexY = indexY;
    }

    public static void startPlaying(){
        Scanner s =new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        n = s.nextInt();
        System.out.println("Enter the number of columns: ");
        m = s.nextInt();
        char [][] board = new char[n][m];
        Board.fillBoard(board);                 //fill the board with '-'
        Board.printBoard(board,n,m);                //printing the board which is filled with '-'
           //scanning index for x,y co-ordinates
        int x=1;                                //to identify player number (player 1 & player 2)


        Player player = new Player('X');      //variable which will carry xy co-ordinate & its type (X or Y)

        while(CheckWinner.state ==0){           //the global variable (state) is set to 0 unless there is at lease 1 winning condition
		
            System.out.println("Please Enter row Co-ordinates for player " + x +" (1-6) "); //taking desired co-ordinates by the player
            player.setIndexX(s.nextInt());
            System.out.println("Please Enter column Co-ordinates for player " + x +" (1-7) ");
            player.setIndexY(s.nextInt());
            while(Board.isFull(board, player.indexX -1, player.indexY -1) ==1) { //To make sure there is no 'X' or 'O' in the same spot
                System.out.println("Please enter in a free slot");
                System.out.println("Please Enter x Co-ordinates for player " + x);
                player.setIndexX(s.nextInt());
                System.out.println("Please Enter y Co-ordinates for player " + x);
                player.setIndexY(s.nextInt());
            }

            board[player.indexX-1][player.indexY-1] = player.type;    //filling the slot with either 'X' or 'O'


            Board.printBoard(board,n,m);                            //printing the board
            System.out.println();

            CheckWinner.checkRow(board,player.type,n,m);                 //Checking the 3 conditions for winning
            CheckWinner.checkCol(board,player.type,n,m);              //Each function has the ability to change state variable to 1
            CheckWinner.checkDiagonal(board,player.type,n,m);         //if it is true
            CheckWinner.checkDraw(board,n,m);
            if(CheckWinner.state ==1){
                System.out.println("Player "+ x +" has won the game!");
                System.exit(0);
            }
            if(CheckWinner.checkDraw(board,n,m)==1)                 //Check if the whole board is full
                System.out.println("It is a draw !");

            if(player.type=='X')          //changing the player turn
                player.type ='O';
            else
                player.type = 'X';

            if(x==1)                    //changing the player turn
                x=2;
            else
                x=1;
        }
    }
}
