public class block implements global {

    protected int state = 0; //setting variable state to 0

    public boolean setState(int PMI){ //set state method

        if(isValidState(PMI)){ //if state is valid

            this.state = PMI; //it sets the state to whatever the game ended as

            return true;
        }

        return false; //else says it is a draw

    }
    public int getState() {

        return this.state; //gets the state

    }

    public boolean isValidState(int PMI) { //method to check if its a valid state 

        return (PMI == 2 || PMI == 1);
    }

    public String toString() {

        if (this.state == 1)

            return "X"; //returns X as the winner

        if (this.state == 0) {

            return " "; //returns an empty string (DRAW)

        }

        return "O"; //returns O as winner if state == 2

    }

}
