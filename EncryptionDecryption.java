import java.util.*;
import java.security.*;
import javax.crypto.*;

public class EncryptionDecryption {
    // Vince Ted Matthew D. Chua
    // May 1st, 2024
    // Professor Carlos N. Romero
    // Information Assurance and Security

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int position; // Retrieves from the switch case.
        
        System.out.println("Vince Chua presents: Cryptify 2024 ");
        System.out.println(); // For space next.
        System.out.println("1. Cipher & Decipher");
        System.out.println("2. Display Name");
        System.out.println("3. End Program");
        System.out.println(); // For space next.
        System.out.print("Pick a case: ");
        position = scan.nextInt();
        
        switch (position) {
            case 1:
                cipherDecipher(scan);
                break;
            case 2:
                displayName();
                break;
            case 3:
                end();
                break;
            default:
                System.out.println("Invalid Option Selected");
                displayName();
                end();
                break;
        }
        
        scan.close();
    }

    public static void cipherDecipher(Scanner scan) {
        try {
            // Step 1: Create a KeyPairGenerator object
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");

            // Step 2: Initialize the KeyPairGenerator object
            keyPairGen.initialize(2048);

            // Step 3: Generate the KeyPair
            KeyPair pair = keyPairGen.generateKeyPair();

            // Step 4: Get the Public Key
            PublicKey publicKey = pair.getPublic();

            // Step 5: Create a Cipher object
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

            // Step 6: Initialize the Cipher object for encryption
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

            // Step 7: Add data to the Cipher object
            System.out.println("Enter text to Encrypt:");
            scan.nextLine(); // Consume the newline character left by scan.nextInt()
            String inputText = scan.nextLine();
            byte[] input = inputText.getBytes();

            // Step 8: Encrypt the data
            byte[] cipherText = cipher.doFinal(input);
            System.out.println("Encrypted Text:");
            System.out.println(Base64.getEncoder().encodeToString(cipherText));

            // Step 9: Initialize the Cipher object for decryption
            cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());

            // Step 10: Decrypt the data
            byte[] decipheredText = cipher.doFinal(cipherText);
            System.out.println("Decrypted Text:");
            System.out.println(new String(decipheredText, "UTF-8"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void displayName() {
        // Displays the "displayName" method system out.
        System.out.println("Vince Chua");
        System.out.println("IAS -3BSCS2");
        System.out.println("Assignment: #3");
        System.out.println("Created: May 1st, 2024");
    }

    public static void end() {
        // Displays the "end" method system out.
        System.out.println("Stopping...");
        System.out.println("Terminating...");
        System.out.println("Ended...");
        System.out.println("Terminated by the Programmer - Vince Chua (3BSCS2)");
    }
}

