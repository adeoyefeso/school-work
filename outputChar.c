//  Created by Ade Oyefeso on 2019-12-09.
//

#include <stdio.h>

int main()
{
    char ch;
    int a_counter = 0;
    int n_counter = 0;
    int s_counter = 0;
   
    for(int i = 0; i <= 10; i++)
{
    printf("Enter any character: \n");
    scanf("%c", &ch);

    if((ch >= 97 && ch <= 122) || (ch >= 65 && ch <= 90))
    {
        a_counter++;
    }
    else if(ch >= 48 && ch <= 57)
    {
        n_counter++;
    }
    else
    {
        s_counter++;
    }
        
}
    printf("The number of alphabetical characters is: %d\n", a_counter);
    printf("The number of numeric digits is: %d\n", n_counter);
    printf("The number of special characters is: %d\n", s_counter);
    
    return 0;
}
