
import java.util.Scanner;

/**
 *Coditation Assignment -Associate Software Developer Position
 * @author Kumar Rajmani Bapat 
 * language - Java
 * complete code updated and properly structured.
 */
public class Main {

    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);

        System.out.println("Welcome to connect4");
        System.out.println("Select game type");
        System.out.println("Enter 1 for \"Player vs. Computer\"");
        System.out.println("Enter 2 for \"Player  vs. Player\"");
        int m=1;
        while(m==1){
        // prepar empty board //****************************/
        char[][] board = new char[6][7];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' '; // one space = empty input             
            }//endfor j            
        }//endfor i

        // select game type //*****************************/
        int game_type = S.nextInt(); // [1]= player+cpu , [2]=player+player
        System.out.println("Starting game");

        char input;
        int turn = 1;// turn42
        boolean x = true;
        while (x = true) {
            if (turn % 2 == 1) {
                System.out.print("Player 1,what column do you want to put your piece? ");
                input = 'X';//input player1
            } else {
                System.out.print("Player 2,what column do you want to put your piece? ");
                input = 'O';// input player2
            }

            int col;
            if (game_type == 1 && turn % 2 == 0) {
                col = 1 + (int) (Math.random() * 7); // cpu player
                System.out.println(col);
            } else {

                // input col index           
                col = S.nextInt();
                if (col < 1 || col > 7) {
                    System.out.println("Invalid place, play again");
                    continue; // to play again
                }
            }
            col--; // because input equal index

            // input row index
            int row = 5; // last index row
            // get count of all inputs in col           
            for (int i = 0; i < board.length; i++) {
                if (board[i][col] == 'X' || board[i][col] == 'O') {
                    row--;
                }
            }
            //if full col
            if (row < 0) {
                System.out.println("Invalid place, play again");
                continue; // to play again
            }

            // insert the input by row & col
            board[row][col] = input;

            // print board 
            System.out.println(" 1 | 2 | 3 | 4 | 5 | 6 | 7 |");

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    System.out.print(" " + board[i][j] + " |");
                }//endfor j
                System.out.println();
            }//endfor i

            turn++;


            /**
             * ************* checks **************
             */
            if (turn > 42) {// 6??7=42 full board inputs
                System.out.println("Draw!");
                break;
            }

            // check col 
            int count = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[i][col] == input) {
                    count++; // count if sequance
                    if (count == 4) {
                        break;
                    }//end if
                } else {
                    count = 0; //not sequance start again
                }//end if
            }

            if (count != 4) {
                count = 0;// start count again

                // check row
                for (int i = 0; i < board[row].length; i++) {// row length
                    if (board[row][i] == input) {
                        count++; // count if sequance
                        if (count == 4) {
                            break;
                        }// if=4
                    } else {
                        count = 0; //not sequance start again
                    }//if = input
                }//endfor
            }// if<> 4

            if (count != 4) {
                count = 0;

                // check diagonal[\] ??????????  
                int down = board.length - row - 1;
                int r = row + down;
                int c = col + down;

                // if out of board range
                while (r >= 0 && c >= 0) {
                    if (!(c <= 6) || !(r <= 5)) {
                        c--;
                        r--;
                        continue;
                    }

                    // check count of diagonal
                    if (board[r][c] == input) {
                        count++;
                        if (count == 4) {
                            break;
                        }
                    } else {
                        count = 0;
                    }
                    // move up
                    r--;
                    c--;
                }// end while

            }

            if (count != 4) {
                count = 0;

                // check secnd diagonal[/] ??????????  
                int up = board.length - row - 1;
                int rw = row + up;
                int cl = col - up;

                // if out of board range
                while (rw >= 0 && cl >= 0) {
                    if (!(cl <= 6) || !(rw <= 5)) {
                        cl++;
                        rw--;
                        continue;
                    }

                    // check count of diagonal
                    if (board[rw][cl] == input) {
                        count++;
                        if (count == 4) {
                            break;
                        }
                    } else {
                        count = 0;
                    }
                    // move up
                    rw--;
                    cl++;
                }// end while

            }// end if 

            // print winner player
            if (count >= 4) {
                int player = 1;
                if (turn % 2 == 1) {
                    player = 2;
                }
                System.out.println("Player " + player + " is the Winner!");
                System.out.println("Do you want to play again(0-no,1-yes)?");
                Scanner T = new Scanner(System.in);
                m=T.nextInt();
                break;

                
            }// if print
}
        }//end while
    }//end main
}// end class
