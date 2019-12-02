public class board implements global {


    protected int state = 0; //setting state as 0



    public block[][] blocks = new block[3][3]; //creating a new block

    public board() {

        for (int b = 0; b < 3; b++) {



            for (int c = 0; c < 3; c++)

            {

                this.blocks[b][c] = new block(); //block is populated 

            }

        }

    }

    public void displayBoard() { //displays the board

        System.out.print("" + this.blocks[0][0] + "|" + this.blocks[0][1] + "|" + this.blocks[0][2] + "\n");

        System.out.print("" + this.blocks[1][0] + "|" + this.blocks[1][1] + "|" + this.blocks[1][2] + "\n");

        System.out.print("" + this.blocks[2][0] + "|" + this.blocks[2][1] + "|" + this.blocks[2][2] + "\n");

    }

    public void displayAvailableMoves() { //method to display the moves that are available, in this method, as long as a postion on the board is open and no one has played in that position us available

        int a = 1;

        for (int b = 0; b < 3; b++) {


            for (int c = 0; c < 3; c++) {


                System.out.print((this.blocks[b][c].getState() == 0) ? Integer.valueOf(a) : this.blocks[b][c]);

                a++;

                if (c != 2) System.out.print("|");

            }
            System.out.print("\n");

        }
    }


    public int updateState() { //the state is updated after checking the rows, columns and diagonals for a winner

        int i = checkRow(0) + checkRow(1) + checkRow(2) + checkCol(0) + checkCol(1) + checkCol(2) + checkDiagonal();


        if (i != 0) {

            this.state = i;

        }

        else {

            this.state = checkDraw();

        }

        return this.state;

    }


    public int  getState(){

        return updateState();
    }


    public int checkDraw(){ //checking if the game finished as a draw

        for (int b = 0; b < 3; b++){

            for (int c = 0; c < 3; c++){

                if (this.blocks[b][c].getState() == 0)

                    return 0;
            }
        }
        return 3;

    }



    private int checkRow(int PMI) { //checking the rows for 3 consecutive moves entered by the same player


        if (this.blocks[PMI][0].getState() != 0)

        {

            if (this.blocks[PMI][0].getState() == this.blocks[PMI][1].getState() && this.blocks[PMI][1].getState() == this.blocks[PMI][2].getState())

                return this.blocks[PMI][0].getState();

        }

        return 0;

    }



    private int checkCol(int PMI) { //checking the columns for 3 consecutive moves entered by the same player



        if (this.blocks[0][PMI].getState() != 0)

        {

            if (this.blocks[0][PMI].getState() == this.blocks[1][PMI].getState() && this.blocks[1][PMI].getState() == this.blocks[2][PMI].getState())

                return this.blocks[0][PMI].getState();

        }

        return 0;

    }



    private int checkDiagonal() { //checking the diagonals for 3 consecutive moves entered by the same player


        if (this.blocks[0][0].getState() != 0)

        {

            if (this.blocks[0][0].getState() == this.blocks[1][1].getState() && this.blocks[1][1].getState() == this.blocks[2][2].getState()) {

                return this.blocks[0][0].getState();

            }

        }

        if (this.blocks[0][2].getState() != 0)

        {

            if (this.blocks[0][2].getState() == this.blocks[1][1].getState() && this.blocks[1][1].getState() == this.blocks[2][0].getState()) {

                return this.blocks[0][2].getState();

            }

        }

        return 0;

    }
    public boolean makeMove(int PMI1, int PMI2) { //called by a player making a move

        int a = 0;
        int b = 0;

        if (PMI1 < 1 || PMI1 > 9) {

            return false;
        }

        if (PMI1 == 1) {

            a = 0; b = 0;
        }

        if (PMI1 == 2) {

            a = 0; b = 1;
        }

        if (PMI1 == 3) {

            a = 0; b = 2;
        }

        if (PMI1 == 4) {

            a = 1; b = 0;
        }

        if (PMI1 == 5) {

            a = 1; b = 1;
        }

        if (PMI1 == 6) {

            a = 1; b = 2;
        }

        if (PMI1 == 7) {

            a = 2; b = 0;
        }

        if (PMI1 == 8) {

            a = 2; b = 1;
        }

        if (PMI1 == 9) {

            a = 2; b = 2;
        }


        if (this.blocks[a][b].getState() == 0) {

                this.blocks[a][b].setState(PMI2);

                return true;

        }

        return false;

    }


}
