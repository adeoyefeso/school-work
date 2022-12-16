import java.util.Random;
//yo
public class AIPlayer extends player implements global {

    public AIPlayer(board Board, int PMI, String Name) {
        super(Board, PMI, Name); //caling the constructor from player

    }

    public void play(board Board) {//play method for the ai 

        int i = 0;



        i = senseWin(); //sensewin method

        if (i != 0) {
            
            Board.makeMove(i, this.PlayerMoveIndicator); //tells the ai where to make the move
            return;

        }

        i = senseLoss(); //senseloss method

        if (i != 0) {
             
            Board.makeMove(i, this.PlayerMoveIndicator); //tells the ai where to make the move
            return;

        }

        i = randomLegal(); //randomLegal move method

        Board.makeMove(i, this.PlayerMoveIndicator);
        System.out.println(this.name + ": I played at position " + i); //the ai tells the human what position it played at

    }

        private int senseWin(){
            //in this method i am telling my ai what positions it shold play in to sense a win, if the columns, rows or diagonls are a legal move(empty), then it should play 3 consecutive moves in either the same row, column or diagonal


            for (int a = 0; a < 3; a++) {



                for (int b = 0; b < 3; b++) {



                    if (this.gameBoard.blocks[a][b].getState() == 0) {


                        int p2 = 0;

                        if (this.gameBoard.blocks[0][b].getState() == this.PlayerMoveIndicator) p2++;

                        if (this.gameBoard.blocks[1][b].getState() == this.PlayerMoveIndicator) p2++;

                        if (this.gameBoard.blocks[2][b].getState() == this.PlayerMoveIndicator) p2++;

                        if (p2 == 2) return 3 * a + 1 + b;



                        p2 = 0;

                        if (this.gameBoard.blocks[a][0].getState() == this.PlayerMoveIndicator) p2++;

                        if (this.gameBoard.blocks[a][1].getState() == this.PlayerMoveIndicator) p2++;

                        if (this.gameBoard.blocks[a][2].getState() == this.PlayerMoveIndicator) p2++;

                        if (p2 == 2) return 3 * a + 1 + b;



                        p2 = 0;

                        if ((a == 0 && b == 2) || (a == 1 && b == 1) || (a == 2 && b == 0)) {



                            if (this.gameBoard.blocks[0][2].getState() == this.PlayerMoveIndicator) p2++;

                            if (this.gameBoard.blocks[1][1].getState() == this.PlayerMoveIndicator) p2++;

                            if (this.gameBoard.blocks[2][0].getState() == this.PlayerMoveIndicator) p2++;

                            if (p2 == 2) return 3 * a + 1 + b;



                        }

                        p2 = 0;

                        if ((a == 0 && b == 0) || (a == 1 && b == 1) || (a == 2 && b == 2)) {



                            if (this.gameBoard.blocks[0][0].getState() == this.PlayerMoveIndicator) p2++;

                            if (this.gameBoard.blocks[1][1].getState() == this.PlayerMoveIndicator) p2++;

                            if (this.gameBoard.blocks[2][2].getState() == this.PlayerMoveIndicator) p2++;

                            if (p2 == 2) return 3 * a + 1 + b;



                        }

                    }

                }

            }



            return 0;

        }


        private int senseLoss() {

            //it can sense a loss if the user plays at index 1
            boolean bool;

            if (this.PlayerMoveIndicator == 1) {

                bool = true;

            } else {

                bool = true;

            }




            return 0;

        }


        private int randomLegal() {

            //if it cannot sense a win or loss then this is just for my ai to play any move
            int h = 0;

            int[] arrayOfInt = new int[9];

            Random random = new Random();



            for (int b = 0; b < 3; b++) {



                for (int c = 0; c < 3; c++) {



                    if (this.gameBoard.blocks[b][c].getState() == 0)

                    {

                        arrayOfInt[h++] = 3 * b + 1 + c;

                    }

                }

            }


            return arrayOfInt[random.nextInt(h)];

        }


    }

