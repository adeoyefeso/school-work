//
//  rps.c
//  
//
//  Created by Ade Oyefeso on 2019-10-21.
//

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
    char selection;
    int Pscore = 0;
    int AIscore = 0;
    int choice;
    srand(time(NULL));
    int ai = rand() % 3 + 1;
    
    printf("Welcome to your rock paper scissors game! \n Rock = 1, Paper = 2, and Scissors = 3 \n");
    
    while (1) {
        printf("press 'p' to play and 'e' to exit \n");
        scanf("%c", &selection);
        
        
        if (selection == 'p') {
        
              printf("Enter your choice: \n");
              scanf("%d", &choice);
              
                  if(choice == 1){
                      if(ai == 1){
                          printf("AI entered: %d, so...Draw!\n", ai);
                      }
                      if(ai == 2){
                          printf("AI entered: %d, so...AI Wins, Paper covers rock \n", ai);
                          AIscore = AIscore + 1;
                      }
                      if(ai == 3){
                          printf("AI entered: %d, so...You Win!, Rock smashes Scissors \n", ai);
                          Pscore = Pscore + 1;
                      }
                  }
                    else  if(choice == 2){
                          if(ai == 2){
                              printf("AI entered: %d, so...Draw\n", ai);
                          }
                          if(ai == 3){
                              printf("AI entered: %d, so...AI Wins, Scissors cuts paper \n", ai);
                              AIscore = AIscore + 1;
                          }
                          if(ai == 1){
                              printf("AI entered: %d, so...You Win! Paper covers Rock \n", ai);
                              Pscore = Pscore + 1;
                          }
                      }
                      else if(choice == 3){
                          if(ai == 3){
                              printf("AI entered: %d, so...Draw\n", ai);
                          }
                          if(ai == 2){
                              printf("AI entered: %d, so...You Win! Scissors cuts paper\n", ai);
                              
                              Pscore = Pscore + 1;
                              
                          }
                          if(ai == 1){
                              printf("AI entered: %d, so...AI Wins! Rock smashes Paper\n", ai);
                              AIscore = AIscore + 1;

                          }
                      }
                      else{
                          
                          printf("Invalid Input...\n");
                      }
        }
        else if(selection == 'e'){
            
            printf("Exiting game...\n");
            if(AIscore > Pscore){
                      printf("AI wins %d to %d!\n",AIscore, Pscore);
                  }
                  else if(AIscore < Pscore){
                      printf("Player wins %d to %d!\n",Pscore, AIscore);
                  }
                 else if(Pscore == AIscore){
                      printf("It ends as a Draw!\n");
                  }
            break;
        }
    }
    
    return 0;
}
