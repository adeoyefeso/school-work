public abstract class player {

    public board gameBoard; //variable gameBoard of type board
    public String name; //variable name which takes the name of the human player
    public int PlayerMoveIndicator; //variable player move indicator which shows the moves the player has available

    public abstract void play(board Board); //abstract method for classes that extend player to use
    

    public player(board Board, int PMI, String Name) { //overlaoded constructor

        this.gameBoard = Board;
        this.name = Name;
        this.PlayerMoveIndicator = PMI;

    }

    public String toString() {

        return this.name; //returns the users name
    }

}



