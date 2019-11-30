//
//  assignment3a.c
//
//
//  Created by Ade Oyefeso on 2019-07-28.
//


#include <stdio.h>
#include <time.h>
#include <string.h>

#define MAX_TWEETS 10

struct tweet{
    
    int id;
    char created_at[51];
    char text[141];
    char user[21];
    
};

typedef struct tweet Tweet;


//Prototype here
Tweet CreateNewTweet(int id, char *name);

void DisplayTweets(Tweet *tweets, int size);

int SearchTweets(Tweet *tweets,int size, char *keyword);

int SaveTweets(Tweet *tweets, int size, char *filename);

int LoadTweets(Tweet tweets[],int size, char *filename);


int main(){
    
    Tweet tweets[MAX_TWEETS];
    
    char username[21];   //store the current username
    
    int _id = 0;   //initialize the id start at 1000
    
    int terminal;   //determine when to terminal the program
    
    char keywords[21];   //store the keyword user entered
    
    char filename[21];   //max length for filename
    
    char loadfile[21];
    
    int count = 0;       //count how many tweets loaded
    
    printf("Welcome to your Simple Twitter\n");
    printf("-------------------------\n");
    
    printf("Please enter your name: ");
    
    scanf("%20[^\n]s", username);
    
    printf("Welcome %s, let's start tweeting...", username);
    
    
    do{
        
        //Main Menu
        
        printf("\n1. Create a new tweet\n");
        printf("2. Search tweets\n");
        printf("3. Display tweets\n");
        printf("4. Save tweets to file\n");
        printf("5. Load tweets from file\n");
        printf("6. Exit\n");
        printf("\n>> ");
        
        scanf("%d",&terminal);
        
        getchar();       //get rid of the '\n' character
        
        
        switch(terminal){
                
            case 1:
                
                if((_id)< MAX_TWEETS){
                    
                    printf("Tweet text (No more than 140 characters): ");
                    
                    tweets[_id] = CreateNewTweet(_id, username);
                    
                    _id++;
                    
                }else{
                    
                    puts("Array is full!");
                    
                }
                
                break;
                
            case 2:
                
                printf("Please enter the search keyword: ");
                
                scanf("%s", keywords);
                
                SearchTweets(tweets,MAX_TWEETS,keywords);
                
                break;
                
            case 3:
                
                DisplayTweets(tweets,MAX_TWEETS);
                
                break;
                
            case 4:
                
                printf("Please enter a filename: ");
                
                scanf("%20[^\n]s%*c", filename);
                
                SaveTweets(tweets,MAX_TWEETS,filename);
                
                break;
                
            case 5:
                
                printf("Please enter a filename: ");
                
                scanf("%20[^\n]s%*c", loadfile);
                
                count = LoadTweets(tweets,MAX_TWEETS,loadfile);
                
                _id = 0 + count;
                
                printf("%d tweet(s) loaded form file \"%s\"",count, loadfile);
                
                break;
                
            case 6:
                
                puts("Good bye!");
                
                break;
                
                
            default:
                
                printf("\nNo Such Function\n");
                
                break;
        }
        
        
    }while(terminal != 6);
    
    return 0;
}


Tweet CreateNewTweet(int id, char *name){
    
    Tweet temp;
    
    temp.id = id;   //get id
    
    strcpy(temp.user,name);   //get username
    
    scanf("%140[^\n]s", temp.text);       //get text
    
    /*get UTC time*/
    
    struct tm *local;
    
    time_t t;
    
    t = time(NULL);
    
    local = gmtime(&t);
    
    strcpy(temp.created_at,asctime(local));   //get time
    
    strcpy(temp.created_at,strtok(temp.created_at,"\n") );
    
    
    printf("New Tweet Created:\n");
    printf("id: %-10dCreated at: %s by %s\n%s\n",temp.id,temp.created_at, temp.user,temp.text);
    
    return temp;
    
    
}


void DisplayTweets (Tweet *tweets, int size){
    
    int count = 0;
    
    while( (tweets + count)->id >= 0 && (tweets+count)->id < 10){
        count++;
    }
    
    printf("Displaying all %d tweets:\n", count);
    
    for(int i = 0; i < count; i++){
        
        printf("id: %-10dCreated at: %s by %s\n%s\n",
               (tweets+i)->id,(tweets+i)->created_at,(tweets+i)->user, (tweets+i)->text);
        
    }
    
    return;
}


int SearchTweets(Tweet *tweets,int size, char *keyword){
    
    int count = 0;       //if count is 0; print no tweet has been found
    
    for(int i = 0; i < size; i++){
        
        if(strstr( (tweets+i)->text, keyword) != NULL ){
            
            printf("Found match:\n");
            
            printf("id: %-10dCreated at: %s by %s\n%s\n",
                   (tweets+i)->id,(tweets+i)->created_at,(tweets+i)->user, (tweets+i)->text);
            
            count++;
        }
        
    }
    
    if(count == 0){
        
        printf("No tweets found\n");
        
    }else{
        
        printf("Found %d tweets matching the criteria!\n", count);
        
    }
    
    return 0;
    
}



int SaveTweets(Tweet *tweets, int size, char *filename){
    
    int count = 0;       //count how many tweets in the array
    
    while( (tweets + count)->id >= 0 && (tweets+count)->id < 10){
        count++;
    }
    
    
    
    FILE *fp;
    
    fp = fopen(filename,"w");
    
    if(fp != NULL){
        
        for(int n = 0; n < count; n++){
            
            fprintf(fp,"%d\n%s\n%s\n%s\n",
                    (tweets+n)->id,(tweets+n)->created_at,(tweets+n)->user,(tweets+n)->text);
            
        }
        
        fclose(fp);
        
        printf("%d tweet(s) saved in file \"%s\"",count,filename);
    }else{
        
        puts("There's something wrong with the file");
        
    }
    
    return 0;
    
}


int LoadTweets(Tweet tweets[],int size, char *filename){
    
    FILE *fp;
    
    int count = 0;
    
    fp = fopen(filename,"r");
    
    if(fp!=NULL){
        while(!feof(fp)){
            
            fscanf(fp,"%d%*c",&tweets[count].id);
            
            fscanf(fp,"%24[^\n]s",tweets[count].created_at);
            
            fscanf(fp,"%*c");
            
            fscanf(fp,"%20[^\n]s",tweets[count].user);
            
            fscanf(fp,"%*c");
            
            fscanf(fp,"%140[^\n]s",tweets[count].text);
            
            //%50[^\n]s\n%20[^\n]s\n%140[^\n]s",
            //tweets[count].id,tweets[count].created_at,tweets[count].user,tweets[count].text);
            
            count++;
        }
        
        fclose(fp);
        
        count--;
        return count;
    }
    else{
        
        printf("There's something wrong with the file");
        return 0;
    }
    }
