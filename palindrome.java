//Adeoluwa Oyefeso-Odusami
//105114057
//October 29th 2019

import java.util.Scanner;

public class palindrome
{
    public static boolean isPalindrome(String s){

        boolean isPalindrome = true; //setting isPalindrome to true

        for(int i = 0; i < s.length()/2; i++)
        {
            char left = s.charAt(i), right = s.charAt(s.length() - i - 1); //left if the first index and right is the last index

            if(left != right) {
                isPalindrome = false; //if left != right make isPalindrome false

            }
        }
      return isPalindrome; //returning the value of isPalindrome
    }

    public static boolean isMirror(String s){

        boolean isMirror = true;
        for(int i = 0; i < s.length()/2; i++)
        {

            char left = s.charAt(i), right = s.charAt(s.length() - i - 1); //left if the first index and right is the last index

            if(left == 'O' || left == '0') //if left is empty, then skip the character
                continue;

            char reverse = getReverse(left); //getting the reverse character of the left character of the string

            if(reverse == '-') //if left doesn't have a reverse character ...
                isMirror = false; //set isMirror to false

            else if(reverse != right) //if reverse and right characters are not the same ...
                isMirror = false; //set isMirror to false
        }

        return isMirror; //returning the value of isMirror
    }
    public static void check(String s){

        boolean isPalindrome = isPalindrome(s), isMirror = isMirror(s);
        if(isPalindrome && isMirror) //if the values of isPalindrome and isMirror are true
            System.out.println(s+" -- is a mirrored palindrome");
        else if(isPalindrome) //if only isPalindrome is true
            System.out.println(s+" -- is a regular palindrome");
        else if(isMirror) //if only isMirror is true
            System.out.println(s+" -- is a mirrored string");
        else //if none are true
            System.out.println(s+" -- is not a palindrome");
    }
    //This function returns the reverse character of the input character
    public static char getReverse(char ch)
    {
        char[] character = {'A','E','H','I','J','L','M','S','T','U','V','W','X','Y','Z','1','2','3','5','8'}; //list of valid characters
        char[] reverse = {'A','3','H','I','L','J','M','2','T','U','V','W','X','Y','5','1','S','E','Z','8'}; //the reverse of the above characters
        for(int i = 0; i < character.length; i++) //while i is not greater than the length of the character array
        {
            if(character[i] == ch) //If input character found in character array
                return reverse[i]; //return the reversed array
        }
        return '-'; //return '-' if input character not found in character array
    }

}