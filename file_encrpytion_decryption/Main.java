import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String fileName = "write.txt";
        createFile(fileName);
        writeInFile(fileName, input);
    }

    public static void createFile(String fileName) {
        try {
            File myFile = new File(fileName);
            if (myFile.createNewFile()) {
                System.out.println("File is created: " + myFile.getName());
            } else {
                System.err.println("File already exists.");
            }
        } catch (IOException e) {
            System.err.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }
    public static void writeInFile(String fileName, Scanner input) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            SecretKey secretKey = keyGenerator.generateKey();
            Cipher desCipher = Cipher.getInstance("DES");

            byte[] text = "Now we are going to write in the file ...".getBytes("UTF8");
            System.out.println("Before Encryption: " + new String(text, "UTF8"));

            desCipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] textEncrypted = desCipher.doFinal(text);

            String encryptedBase64 = Base64.getEncoder().encodeToString(textEncrypted);
            FileWriter writer = new FileWriter(fileName);
            writer.write(encryptedBase64);
            writer.close();
            System.out.println("Encrypted data written to file: " + encryptedBase64);

            System.out.print("\nIf you want to decrypt the data, enter 1:");
            int choice = input.nextInt();

            if (choice == 1) {
                Scanner fileReader = new Scanner(new File(fileName));
                String encryptedFromFile = fileReader.nextLine();
                fileReader.close();

                byte[] encryptedBytes = Base64.getDecoder().decode(encryptedFromFile);
                desCipher.init(Cipher.DECRYPT_MODE, secretKey);
                byte[] textDecrypted = desCipher.doFinal(encryptedBytes);

                System.out.println("Decrypted text: " + new String(textDecrypted, "UTF8"));
            } else {
                System.out.println("Process ended. Tata...");
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
