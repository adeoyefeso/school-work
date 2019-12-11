#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#define DEBUG 0

void SortWord(char *word, int size);
bool AnagramCheck(char *wordOne, char *wordTwo);
void AssignAnagramGroup(int wordIndex);
void SortWordList(void);
void CalculateTopGroups(void);
void wordScan(char *list);

char WordList[100][20];
int AnagramGroup[100];
int wordcount = 0;
int AnagramGroupCount = 0;
int AnagramGroupSizes[100];
int AnagramGroupMax = 5;
//Globally inititalizing the functions

int main(){
    char word[20];
    int terminate = 0;
    printf("Enter a set of words, type each word on a new line. Type 'STOP' to end the input:\n");
    
    do{
        wordScan(word);
        if(strcmp(word, "STOP") == 0 || wordcount > 99){
            break;
        }
        strcpy(WordList[wordcount], word);
        AssignAnagramGroup(wordcount++);
        if(DEBUG){
            printf("wordScan: WordList[%d]=\"%s\" AnagramGroup=%d\n", wordcount, word, AnagramGroup[wordcount-1]);
        }
    }while(!terminate);
    // The do while loop is used to check if the entries by the user fall in line with the requirements until the termination string
    
    if(DEBUG){
        printf("WordList size = %d words\n", wordcount);
        for(int x = 0; x < AnagramGroupCount; x++){
            printf("Anagram Group %d of size %d\n", x+1, AnagramGroupSizes[x]);
        }
    }
    SortWordList();
    if(DEBUG){
        for(int x = 0; x < wordcount; x++){
            printf("WordList[%d] = \"%s\"   Gid=%d   Gsize = %d \n", x, WordList[x], AnagramGroup[x], AnagramGroupSizes[AnagramGroup[x]-1]);
        }
    }
    CalculateTopGroups();
    return 0;
}

void wordScan(char *list){
    scanf("%s", list); //User input is scanned
    return;
}

void SortWord(char *word, int size){
    char temp;
    for(int i = 0; i < size - 1; i++){
        for(int j = i + 1; j < size; j++){
            if((int)*(word + i) > (int)*(word + j)){
                temp = *(word + i);
                *(word + i) = *(word + j);
                *(word + j) = temp;
            }
        }
    }
    return; //The words are sorted by length using a temporary value
}

bool AnagramCheck(char *wordOne, char *wordTwo){
    char temp1[20];
    char temp2[20];
    
    strcpy(temp1, wordOne);
    strcpy(temp2, wordTwo);
    
    SortWord(temp1, strlen(temp1));
    SortWord(temp2, strlen(temp2));
    
    if(strcmp(temp1, temp2) == 0){
        return true;
    }
    else{
        return false;
    }
    //This function checks which words are anagrams using the address of the words and comparing them. If its an anagram, true is returned if it is not, false is returned
}

void AssignAnagramGroup(int wordIndex){
    for(int x = 0; x <= wordIndex; x++){
        if(x == wordIndex){
            ++AnagramGroupCount;
            AnagramGroup[wordIndex] = AnagramGroupCount;
            ++AnagramGroupSizes[AnagramGroupCount-1];
            break;
        }
        else if(AnagramCheck(WordList[wordIndex],WordList[x])){
            AnagramGroup[wordIndex]=AnagramGroup[x];
            ++AnagramGroupSizes[AnagramGroup[x]-1];
            break;
        }
    }
    return;
}
//Assigns the anagrams to their groups

void SortWordList(void){
    char ctemp[20];
    int itemp;
    
    for(int i = 0; i < wordcount - 1; i++){
        for(int j = i + 1; j < wordcount; j++){
            if(strcmp(WordList[i], WordList[j]) > 0){
                strcpy(ctemp, WordList[i]);
                strcpy(WordList[i], WordList[j]);
                strcpy(WordList[j], ctemp);
                
                itemp = AnagramGroup[i];
                AnagramGroup[i] = AnagramGroup[j];
                AnagramGroup[j] = itemp;
            }
        }
    }
    return;
}
//This function is used to sort by alphabetical order

void CalculateTopGroups(void){
    int atemp[AnagramGroupCount];
    int itemp;
    int c1, c2;
    int t1, t2;
    
    
    for(int x = 0; x < AnagramGroupCount; x++){
        atemp[x] = x;
    }
    //This function is used to rank the anagrams
    
    for(int x = 0; x < AnagramGroupCount - 1; x++){
        for(int y = x + 1; y < AnagramGroupCount; y++){
            if(AnagramGroupSizes[x] < AnagramGroupSizes[y]){
                itemp = AnagramGroupSizes[x];
                AnagramGroupSizes[x] = AnagramGroupSizes[y];
                AnagramGroupSizes[y] = itemp;
                
                itemp = atemp[x];
                atemp[x] = atemp[y];
                atemp[y] = itemp;
            }
        }
    }
    //The anagrams are sorted in ascending order to determine their group size ranks
    
    for(int x = 0; x < AnagramGroupCount - 1; x++){
        for(int y = x+1; y < AnagramGroupCount; y++){
            t1 = 1, t2 = 1;
            if(AnagramGroupSizes[x] == AnagramGroupSizes[y]){
                c1 = 0, c2 = 0;
                while(t1 || t2){
                    if(AnagramGroup[c1] == atemp[x]+1){
                        t1 = 0;
                        break;
                    }
                    else if (t1){
                        ++c1;
                    }
                    if(AnagramGroup[c2] == atemp[y]+1){
                        t2 = 0;
                        break;
                    }
                    else if (t2){
                        ++c2;
                    }
                }
                if(strcmp(WordList[c1], WordList[c2]) > 0){
                    itemp = atemp[x];
                    atemp[x] = atemp[y];
                    atemp[y] = itemp;
                }
            }
        }
    }
    
    for(int x = 0; x < AnagramGroupMax; x++){
        c1 = 0;
        if(x + 1 <= AnagramGroupCount){
            printf("Group of size %d: ", AnagramGroupSizes[x]);
        }
        else{
            printf("Group of size 0:");
        }
        //prints out the group sizes
        
        for(int id = 0; id < AnagramGroupSizes[x]; c1++){
            if(AnagramGroup[c1] == atemp[x]+1){
                printf("%s ", WordList[c1]);
                ++id;
            }
        }
        printf("\n");
    }
    return;
}



//Adeoluwa Oyefeso-Odusami, Assignment 2
