import java.util.Random;
import java.util.Scanner;

class game implements global {

    //declaring variables gameBoard, playerX, playerO, turn and done
    board gameBoard; 
    player PlayerX;
    player PlayerO;
    int turn;
    boolean done = false;


    public game() {

        Scanner scan = new Scanner(System.in); //creating an object that takes user input
        this.gameBoard = new board(); //printing out a new board to the user

        //giving input, string s1 and s2 a value
        String s1 = null; 
        String s2 = "ADE AI";

        int input = 0;

        while (!this.done) { //while true, infinite loop

            System.out.println("Welcome to Adeoluwa Oyefeso's Tic Tac Toe game, The only game option is Human vs AI press 1 to play");

            input = scan.nextInt(); //when user enters 1

            switch (input) {

                case 1:
                    System.out.println("Please enter Human playerX name: "); //user asked to enter their name
                    s1 = scan.next();

                    this.done = true;
                    continue;

            }

            System.out.println("Error... pls enter a valid selection"); //if user doesnt enter 1 they cant continue

        }

        if (input == 1){

            this.PlayerX = new HumanPlayer(this.gameBoard, 1, s1);

            this.PlayerO = new AIPlayer(this.gameBoard, 2, s2);


        }

            System.out.println("\nGAME BEGINS... " + s1 + " VS " + s2 + "\n");

    }

        public void start(){ //start method called in main

            Random rand = new Random(); //creating a rand object
            boolean bool = false; //declaring variable bool as false
 
            this.turn = rand.nextInt(2) + 1; //generating a random number

            if (this.turn == 1) { //whichever player gets turn == 1, they start the game
                System.out.println(this.PlayerX.name + " wins the coin toss... X will start\n");

            } else
                System.out.println(this.PlayerO.name + " wins the coin toss... O will start\n");

            while (!bool) {

                if (this.turn == 1) {

                    System.out.println( "" + this.PlayerX.name + "'s turn...");
                    this.gameBoard.displayBoard(); //displaying the board

                    this.PlayerX.play(this.gameBoard); //allowing player X to play

                }

                else {

                    System.out.println( "" + this.PlayerO.name + "'s turn...");
                    this.gameBoard.displayBoard(); //displaying the board


                    this.PlayerO.play(this.gameBoard); //allowing player O to play

                }


                if (this.gameBoard.getState() != 0) bool = true; //if get state isnt 0 then bool is set as true


                if (!bool) {

                    if (this.turn == 1) {

                        this.turn = 2; continue;

                    }

                    this.turn = 1;

                }

            }

            this.gameBoard.displayBoard();


            if (this.gameBoard.getState() == 3) { //if the state of the game is 3 then is is a draw

                System.out.println("DRAW...");

            }
            else if (this.turn != 1) {

                //whichever player got turn == 1 is player x so they win
                System.out.println(this.PlayerO + " WINS!!!!");

            }
            else {

                //player o wins
                System.out.println(this.PlayerX + " WINS!!!! ");
            }


        }

    }

