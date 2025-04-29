import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your password :");
        String password =input.nextLine();

        checkPassword(password);

        input.close();
    }

    private static void checkPassword(String password) {

        String givenPassword = password;

        int len = givenPassword.length();
        char grade = checkPasswordLength(len);
        String upperCasePattern = ".*[A-Z].*"; // Matches if at least one uppercase letter is present
        String lowerCasePattern = ".*[a-z].*"; // Matches if at least one lowercase letter is present

        int numbers = 1234567890;
        String specialCase = ".*[@#$&)].*";
        boolean passwordStrength = checkPasswordWithPatterns(givenPassword, upperCasePattern, lowerCasePattern,
                specialCase, numbers);
        if (!passwordStrength) {
            System.out.println("Try to include some extra elements into your password from these  " + upperCasePattern
                    + " " + lowerCasePattern + " " + specialCase + " "
                    + " in your password  { " + givenPassword + " } ");
        } else if (grade == 'B' || grade == 'C') {
            System.out.println("Your password is clear   all the edge cases : " + givenPassword
                    + " but recommended to add some extra characters to increase teh lenght of you password ");
        } else {
            System.out.println("Your password is clear   all the edge cases : " + givenPassword);

        }

    }

    private static boolean checkPasswordWithPatterns(String givenPassword, String upperCasePatterns,
            String lowerCasePatterns, String specialCase, int numbers) {

        boolean lowerCase = false;
        boolean upperCase = false;
        boolean specialCharacters = false;

        if (givenPassword.matches(specialCase)) {
            specialCharacters = true;
        }
        if (givenPassword.matches(upperCasePatterns)) {
            upperCase = true;
        }
        if (givenPassword.matches(lowerCasePatterns)) {
            lowerCase = true;
        }

        if (lowerCase && upperCase && specialCharacters && containNumbersChecker(givenPassword)) {
            return true;
        }

        return false;

    }

    public static char checkPasswordLength(int passwordLength) {

        int givenPasswordLength = passwordLength;

        if (givenPasswordLength >= 8)
            return 'A';
        else if (givenPasswordLength >= 6)
            return 'B';
        else
            return 'C';

    }

    public static boolean containNumbersChecker(String input) {
        return input.matches(".*\\d.*");
    }

}
