import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string to  check  it is a palindrome or not : ");
        String userInput = input.next();
        String givenInput = userInput.trim();

        boolean is_Palindrome = plaindromeChecker(givenInput);
        if (is_Palindrome) {
            System.out.println("Yes the  given " + " " + userInput + " " + "is palindrome ");
        }
        else {
            System.out.println("No the  given " + " " + userInput + " " + "is not  a  palindrome ");

        }

        input.close();
    }
    

    public static boolean plaindromeChecker(String givenInputString) {

        String reversedString = "";
        int length = givenInputString.length()-1;

        for (int i = length; i >= 0; i--) {
            reversedString += givenInputString.charAt(i);
        }
        
        if (reversedString.equals(givenInputString)) {
            return true;
        }


        return false;
    }
}
