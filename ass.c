//
//Adeoluwa Oyefeso, 105114057
//11/07/19

#include <stdio.h>

#define PLAYER1MOVE 'X'
#define PLAYER2MOVE 'O'

int SIDE = 3; //Initializing side as 3

void InitializeBoard(int m, int n , char board[][n]){
    
    int c = 1;
    int i, j;
    
    for(i = 0; i < m; i++){
        for(j = 0; j < n; j++){
            
            board[i][j] = c +'0';
            c++;
            
        }
    }
}
void PrintBoard(int m, int n, char board[][n]){ //A function to design how the board is going to be printed
    
    printf("\n");
    
    printf("\t %c | %c | %c \n", board[0][0], board[0][1], board[0][2]);
    printf("\t--------------\n");
    
    printf("\t %c | %c | %c \n", board[1][0], board[1][1], board[1][2]);
    printf("\t--------------\n");
    
    printf("\t %c | %c | %c \n\n", board[2][0], board[2][1], board[2][2]);
    
}

void CreateBoard(int m, int n, char board[][n]){ //Creating the tic-tac-toe board
    
    int cell;
    while(1){
        
        printf("Enter the number of the cell where you want to insert x or o or enter -1 to exit: ");
        
        scanf("%d", &cell);
        
        if(cell < 0){
            
            return;
            
        }else if(cell >= 1 && cell <= 9){
            
            cell--;
            
            int rowIn = cell/3;
            int colIn = cell % 3;
            char ch;
            
            printf("Type x or o: ");
            
            scanf("%c", &ch);
            scanf("%c", &ch);
            
            if(ch == 'x' || ch == 'X'){
                
                ch = 'X';
                
            }else{
                
                ch = 'O';
                
            }
            board[rowIn][colIn] = ch;
            PrintBoard(m, n, board);
            
        }else{
            
            printf("Please enter valid character\n");
            
        }
        
    }
    
}
int IsValidBoard(int m, int n, char board[][n]){ //Function to checkif the tic-tac-toe is valid or invalid
    
    int i, j;
    int Countx = 0;
    int County = 0;
    
    for(i = 0; i < m; i++){
        
        for(j = 0; j < n; j++){
            
            if(board[i][j] =='x' || board[i][j]=='X'){
                
                Countx++; //When the user enters X the counter for the number of X's is incremented
                
            }
            
            if(board[i][j]=='y' || board[i][j]=='Y'){
                
                County++; //When the user enters Y the counter for the number of Y's entered is incremented
                
            }
        }
    }
    int difference = Countx - County; //The difference between X and Y is calculated
    
    if(difference >= -1 && difference <= 1){
        
        return 1;
        
    }else{
        
        return 0;
    }

}

int rowCross(char board[][SIDE],char checkMe) //Function that checks if the same user entered 3 X's or O's in a row
{
    int i, j;
    int count = 0;
    int iAmCell = 0;
    int found = 0;
    
    for (i = 0; i < SIDE; i++)
        
    {
        
        count = 0;
        for(j = 0; j < SIDE; j++){
            
            if (board[i][j] == checkMe){
                
                count++;
                
            }
            
            if(board[i][j]!='O' && board[i][j]!='X'){
                
                iAmCell = i * 3 + j + 1;
            }
            
        }
        if(count==2 && iAmCell!=0){
            
            found = 1;
            printf("Cell # %d", iAmCell);
            
        }
        
    }
    
    return(found);
    
}

int columnCross(char board[][SIDE],char checkMe) //Function that checks if the same user entered 3 X's or O's in a column

{
    int i, j;
    int count = 0;
    int iAmCell = 0;
    int found = 0;
    
    for (i = 0; i < SIDE; i++)
        
    {
        
        count = 0;
        
        for(j = 0;j < SIDE; j++){
            
            if (board[j][i] == checkMe){
                
                count++;
                
            }
            if(board[j][i] != 'O' && board[j][i] != 'X'){
                
                iAmCell = j * 3 + i + 1;
                
            }
            
        }
        
        if(count == 2 && iAmCell != 0){
            
            found = 1;
            printf("Cell # %d", iAmCell);
            
        }
        
    }
    
    return(found);
    
}
int diagonalCross(char board[][SIDE],char checkMe) //Function that checks if the same user entered 3 X's or O's in the diagonal of the tic-tac-toe board

{
    int i;
    int count = 0;
    int iAMCell = 0;
    int found;
    
    for(i = 0; i < 3; i++){
        
        if (board[i][i] == checkMe){
            
            count++;
            
        }
        if (board[i][i] != 'O' &&board[i][i] != 'X' ){
            
            iAMCell = i * 3 + i + 1;
            
        }
        
    }
    count = 0;
    
    if(count == 2 && iAMCell != 0){
        
        found = 1;
        printf("Cell # %d", iAMCell);
        
    }
    
    for(i = 0; i < 3; i++){
        
        if (board[i][2-i] == checkMe){
            
            count++;
            
        }
        if (board[i][2-i] != 'O' && board[i][2-i] != 'X'){
            
            iAMCell = i * 3 - i + 1 + 2;
            
        }
        
    }
    
    if(count == 2 && iAMCell != 0){
        
        found = 1;
        printf("Cell # %d", iAMCell);
        
    }
    
    return(found);
    
}

void ListWinningCells(int m,int n,char board[][SIDE])

{
    char check = PLAYER1MOVE;
    
    int n1, n2, n3;
    
    n1 = columnCross(board, check);
    n2 = rowCross(board, check);
    n3 = diagonalCross(board, check);
    
    int found = 0;
    
    if(n1 == 1 || n2 == 1 || n3 == 1){
        
        found = 1;
        
        printf("Winning cells for player %c\n", PLAYER1MOVE);
        
    }
    
    check = PLAYER2MOVE;
    
    n1 = columnCross(board, check);
    n2 = rowCross(board, check);
    n3 = diagonalCross(board, check);
    
    if(n1 == 1 || n2 == 1 || n3 == 1){
        
        found = 1;
        
        printf("Winning cells for player %c", PLAYER2MOVE);
        
    }
    if(found==0){
        
        printf("No winning cell for player O or X");
        
    }
    
}

void printMenu(){ //Function to display the menu for the user to enter what they want to do
    
    printf("\npress 'p' to print the tic-tac-toe board\n");
    printf("press 'c' to create a tic-tac-toe with some x and o cells\n");
    printf("press 't' to test if a tic-tac-toe board is valid or invalid board\n");
    printf("press 'w' to predict winning cell for player x or o\n");
    printf("press 'e' to exit\n");
    printf("enter your choice : ");
    
}

int main() {
    
    int row = 3;
    int col = 3;
    char board[row][col];
    char choice;
    InitializeBoard(row, col, board);
    
    while(1){
        
        printMenu();
        
        scanf("%c", &choice);
        
        while(choice == '\n'){
            
            scanf("%c", &choice);
            
        }
        //If statements that are acted upon depending on user input
        if(choice == 'e') {
            break;
            
        } else if(choice == 'p') {
            PrintBoard(row, col, board);
            
        } else if(choice == 'c') {
            CreateBoard(row, col, board);
            
        } else if(choice == 't') {
            
            int checkMe=IsValidBoard(row, col, board);
            
            if(checkMe == 0){
                
                printf("Not a valid board");
                
            }else{
                
                printf("It is a valid board");
                
            }
            
        } else if(choice == 'w') {
            ListWinningCells(row, col, board);
            
        }
    }
    return 0;
}
