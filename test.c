#include <stdio.h>
#include <stdlib.h>

typedef struct ListNode{
    int value;
    struct ListNode *next;
} ListNode;

void InitiateList(ListNode **);

void InsertAtBeginning(int, ListNode **);

void InsertAtEnd(int, ListNode **);

void DeleteAtBeginning(ListNode **);

void DeleteAtEnd(ListNode **);

int IsEmptyList(ListNode *);

int IsFullList(ListNode *);

int ListSize(ListNode *);

void ClearList(ListNode **);

void PrintList(ListNode*);

void SortList(ListNode *);

void PrintListBackwards(ListNode *);

void PrintListRec(ListNode *head);

int main() {
    
    ListNode *head = NULL;
    
    InitiateList(&head);
    printf("Is Empty List? %d\n", IsEmptyList(head));
    
    for (int i=1; i<=10; i++){
        InsertAtBeginning(i*2,&head);
    }
    
    printf("List after adding some elements \n");
    PrintList(head);
    
    printf("\n");
    
    
    SortList(head);
    
    printf("Print List after shorting using recursive some elements \n");
    
    PrintListRec(head);
    printf("\n");
    
    printf("Print List after shorting in backward order using recursive some elements \n");
    
    PrintListBackwards(head);
    printf("\n");
    
    
    return 0;
    
}


void InitiateList(ListNode **head){
    
    if(head!=NULL)
        ClearList(head);
    
    *head = NULL;
}

void InsertAtBeginning(int v, ListNode **head){
    
    ListNode *node = (ListNode*)malloc(sizeof(ListNode));
    
    node->value = v;
    node->next = NULL;
    
    if (*head==NULL){
        *head = node;
    }else{
        node->next = *head;
        *head = node;
    }
}

void InsertAtEnd(int v, ListNode **head){
    
    
    // To handle  the case when the list is empty
    if(*head == NULL){
        InsertAtBeginning(v, head);
        return;
    }
    
    ListNode *node = (ListNode*)malloc(sizeof(ListNode));
    node->value = v;
    node->next = NULL;
    
    
    ListNode * current = *head;
    while(current->next!=NULL){
        current = current->next;
    }
    
    current->next = node;
    
}

void DeleteAtBeginning(ListNode **head) {
    
    // To handle the case when the list is empty
    if (*head != NULL){
        ListNode *node = *head;
        *head = (*head)->next;
        free(node);
    }
}

void DeleteAtEnd(ListNode **head){
    
    // To handle the case when list is empty
    if( *head == NULL)
        return;
    
    // To handle the case when list contains only one node
    if((*head)->next == NULL){
        DeleteAtBeginning(head);
        return;
    }
    
    ListNode *current = *head;
    while(current->next->next!=NULL){
        current = current->next;
    }
    
    ListNode *node = current->next;
    current->next = NULL;
    free(node);
}

void ClearList(ListNode **head){
    
    ListNode *current  = *head;
    
    while(current!=NULL){
        current = current->next;
        
        free(*head);
        
        *head = current;
    }
}

int IsEmptyList(ListNode *head){
    
    if(head==NULL)
        return 1;
    else
        return  0;
}

int ListSize(ListNode *head){
    
    int size = 0;
    
    ListNode *current;
    
    current = head;
    
    while(current!=NULL){
        size = size + 1;
        current = current->next;
    }
    
    return size;
}

void PrintList(ListNode *head) {
    
    ListNode *current;
    current = head;
    
    while (current != NULL) {
        
        printf("%d --> ", current->value);
        current = current->next;
        
    }
    printf("NULL\n");
}


void PrintListRec(ListNode *head) {
    
    // This is the base case
    if(head == NULL){
        printf("--> NULL");
        return;
    }
    
    
    printf("%d --> ", head->value);
    
    // This is the recursive statement
    PrintList(head->next);
    
}

void PrintListBackwards(ListNode *head) {
    
    // This is the base case
    if(head == NULL){
        printf("NULL <--");
        return;
    }
    
    // This is the recursive statement
    PrintListBackwards(head->next);
    
    printf("%d <-- ", head->value);
}

int IsFullList(ListNode *head){
    
    return 0;
}

void SortList(ListNode *head){
    
    ListNode *current;
    ListNode *after;
    
    int temp;
    
    // check if list is empty
    if (head== NULL)
        return;
    
    for(current = head; current->next!=NULL; current = current->next){
        for(after =current->next; after!=NULL; after=after->next){
            if(current->value > after->value){
                temp = current->value;
                current->value = after->value;
                after->value = temp;
            }
        }
    }
}
