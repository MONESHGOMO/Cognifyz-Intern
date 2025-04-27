import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Choose your Password should must consist of:");
        System.out.println("1. Include numbers only");
        System.out.println("2. Include lowercase and uppercase letters");
        System.out.println("3. Include lowercase, uppercase letters and special characters");
        System.out.println("4. Include all (letters, numbers, special characters)");

        int user_option = 0;
        try {
            System.out.print("Enter your option in number here: ");
            user_option = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("You entered wrong input! Please enter a valid number.");
            return; 
        }

        String generated_password = generatePassword(user_option, input); 
        System.out.println(generated_password);

        input.close(); 
    }

    public static String generatePassword(int user_option, Scanner USER_INPUT) {
       
        Random random = new Random();

        switch (user_option) {
            case 1:
                try {
                    System.out.print("Enter the password length you want: ");
                    int passwordLength = USER_INPUT.nextInt();
                    String pattern = "0123456789";
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < passwordLength; i++) {
                        int index = random.nextInt(pattern.length());
                        sb.append(pattern.charAt(index));
                    }
                    return "Your generated password is: " + sb.toString();
                } catch (InputMismatchException e) {
                    return "You entered wrong input! Please enter a valid number, try again.";
                } catch (Exception e) {
                    e.printStackTrace();
                    return "Something went wrong, please try again.";
                }

            case 2:
                try {
                    System.out.print("Enter the password length you want: ");
                    int passwordLength = USER_INPUT.nextInt();
                    String pattern = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < passwordLength; i++) {
                        int index = random.nextInt(pattern.length());
                        sb.append(pattern.charAt(index));
                    }
                    return "Your generated password is: " + sb.toString();
                } catch (InputMismatchException e) {
                    return "You entered wrong input! Please enter a valid number, try again.";
                } catch (Exception e) {
                    e.printStackTrace();
                    return "Something went wrong, please try again.";
                }

            case 3:
                try {
                    System.out.print("Enter the password length you want: ");
                    int passwordLength = USER_INPUT.nextInt();
                    String pattern = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%^&*()";
                    StringBuilder sb = new StringBuilder();  // why StringBuilder because it is faster when compared to StringBuffer
                    for (int i = 0; i < passwordLength; i++) {
                        int index = random.nextInt(pattern.length());
                        sb.append(pattern.charAt(index));
                    }
                    return "Your generated password is: " + sb.toString();
                } catch (InputMismatchException e) {
                    return "You entered wrong input! Please enter a valid number, try again.";
                } catch (Exception e) {
                    e.printStackTrace();
                    return "Something went wrong, please try again.";
                }

            case 4:
                try {
                    System.out.print("Enter the password length you want: ");
                    int passwordLength = USER_INPUT.nextInt();
                    String pattern = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < passwordLength; i++) {
                        int index = random.nextInt(pattern.length());
                        sb.append(pattern.charAt(index));
                    }
                    return "Your generated password is: " + sb.toString();
                } catch (InputMismatchException e) {
                    return "You entered wrong input! Please enter a valid number, try again.";
                } catch (Exception e) {
                    e.printStackTrace();
                    return "Something went wrong, please try again.";
                }

            default:
                return "Invalid option selected! Please run the program again.";
        }
    }
}
