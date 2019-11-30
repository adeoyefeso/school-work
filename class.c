

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct ProductDescription{
    
    char productName [25];
    float productPrice;
    float  productWeight;
    struct ProductDescription *next;
    
}ProductNode;

void CreateEmptyProductList(ProductNode **head){ // double pointer is needed as it points to an array of arrays
    *head = NULL;
}


ProductNode * SetProductInfo(){
    ProductNode *product;
    product = (ProductNode *) malloc(sizeof(ProductNode));
    printf("\nPlease Enter the ProductNode Name: ");
    scanf(" [ ^\n ]%s", product->productName);
    printf("\nPlease Enter the ProductNode Price: ");
    scanf(" %f", &product->productPrice);
    printf("\nPlease Enter the ProductNode Weight: ");
    scanf(" %f", &product->productWeight);
    product->next = NULL;
 
    return product;
}

void InsertProductAtHead(ProductNode **head){
    ProductNode * productInfo = SetProductInfo();
    if(*head == NULL){ // check if the list is empty
        *head = productInfo;
    }
    else{
    productInfo->next = *head; //add at the head
    *head = productInfo;
    }
}
void InsertProductAtEnd(ProductNode **head){
    ProductNode * productInfo = SetProductInfo();
    if(*head == NULL){ // check if the list is empty
        *head = productInfo;
        
    }else{
    ProductNode *productInfo = SetProductInfo();
        ProductNode *current = *head;
        
        while(current->next != NULL){
            current = current->next; //add at the end
            current->next = productInfo;
        }
    }
    
}
//This function prints the product list
void PrintProductList(ProductNode *head){
    ProductNode *current = head;
    
    while(current != NULL){
        printf("\n ProductName: %s", current->productName);
        printf("\n ProductPrice: %f", current->productPrice);
        printf("\n ProductWeight: %f", current->productWeight);
        printf("\n---------------------------------------------------------------\n");
        current = current->next;
    }
}
//This function prints the product list using recursion
void PrintProductListRec(ProductNode *head){
    
}
void ClearProductList(ProductNode **head){
    
    ProductNode *current = *head;
    while (current != NULL) {
        current = current->next;
        free(*head);
        *head = current;
    }
    
}

int main() {
    
    printf("\n");
    
    char c;
    ProductNode *head;
    
    CreateEmptyProductList(&head);
    
    do{
        
        printf("press 's' or 'e' to add product to the list or any other key to exit: ");
        scanf(" %c",&c);
        
        if(c == 's'){
            InsertProductAtHead(&head);
        }
        if(c == 'e'){
            InsertProductAtEnd(&head);
        }
        
        
    }while(c == 's' || c == 'e');
    
    PrintProductList(head);

    
    printf("press 'c' to clear the products list: ");
    scanf(" %c",&c);
    
    if(c=='c'){
        CreateEmptyProductList(&head);
    }
    
    PrintProductList(head);
    
    return 0;
}





