import java.util.Scanner;

public class HumanPlayer extends player implements global{

        public HumanPlayer(board Board, int PMI, String Name){

            super(Board, PMI, Name);//calling constructor in player
        }

        public void play(board Board){ //humans play method

            boolean bool;
            Scanner scan = new Scanner(System.in); //takes user input

            this.gameBoard = Board;


                do {

                    System.out.println("Please make a move by selecting one of the available options: ");
                    Board.displayAvailableMoves(); //displays the available moves on the board to the user

                    int i = scan.nextInt(); //saves the users input of where to play

                    bool = Board.makeMove(i, this.PlayerMoveIndicator);

                    if (bool) {
                        continue;
                    }
                    System.out.println("Invalid move... Please try again"); //play a valid move

                }

                while (!bool);


        }



}


