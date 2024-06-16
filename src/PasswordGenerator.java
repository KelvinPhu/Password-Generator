import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {
	
	private Scanner sc = new Scanner(System.in);
	
	PasswordGenerator() {
        menu();
    }
	
	void menu() {
		while (true) {
			System.out.println("--------------------------------");
			System.out.println("1. Generate a strong password\n2. Convert your password to encrypted password");
			char option = Character.toUpperCase(sc.nextLine().charAt(0));
			
			switch (option) {
			case 'G':
				generatePassword();
				break;
				
			case 'C':
				encryptPassword();
				break;

			default:
				System.out.println("Invalid Option");
				break;
			}
		}
	}

	// encrypt using hashing algorithm
	private void encryptPassword() {
		System.out.println("Enter your password: ");
		String password = sc.nextLine();
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
			BigInteger number = new BigInteger(1, hash);
			String hashedPassword = number.toString(16);
			while(hashedPassword.length() < 32) {
				hashedPassword = "0" +hashedPassword;
			}
			System.out.println("Your password after encryption is: " +hashedPassword);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Error occured while encrypting password");
		}
	}

	private void generatePassword() {
		StringBuilder password = new StringBuilder();
		SecureRandom random = new SecureRandom();
		int passwordLength = 30;
		for(int i=0; i<passwordLength; i++) {
			char randomChar = (char) (random.nextInt(95) + 32);
			password.append(randomChar);
		}
		System.out.println("Your password is:" +password.toString());
	}
}
