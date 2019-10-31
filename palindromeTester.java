import java.util.Scanner;

public class palindromeTest { //Class to test the isPalindrome and isMirror functions
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in); //Creating a new object called scanner

        String array[] = new String[4]; //Stores 4 user inputs

        for(int i = 0; i < 4; i++) { //allows the user to enter 4 arrays
            System.out.println("Enter your String to be checked: ");
            array[i] = scan.nextLine(); //stores arrays entered by user
            System.out.println("Processing "+array[i]);
        }

        for(int i = 0; i < 4; i++) {
            palindrome.check(array[i]); //Checks the array entered by user
        }
        scan.close();
    }
}
