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
			System.out.println("1. Create new password\n"
							 + "2. Encrypt your password\n"
							 + "3. Check your password Strength\n"
							 + "4. Display Useful Password Tips\n"
							 + "5. Exit\n");
			char option = Character.toUpperCase(sc.nextLine().charAt(0));
			
			switch (option) {
			case '1':
				generatePassword();
				break;
				
			case '2':
				encryptPassword();
				break;
			
			case '3':
				checkPasswordStrengh();
				break;
			
			case '4':
				displayPasswordTips();
				break;
				
			case '5':
				exit();
				break;

			default:
				System.out.println("Invalid Option");
				break;
			}
		}
	}

	private void exit() {
		// TODO Auto-generated method stub
		
	}

	private void displayPasswordTips() {
		// TODO Auto-generated method stub
		
	}

	private void checkPasswordStrengh() {
		System.out.println("Enter Your password: ");
		String password = sc.nextLine();
		
		boolean hasUpperCase = false;
		boolean hasLowerCase = false;
		boolean hasNumber = false;
		boolean hasSymbol = false;
		
		for(char c : password.toCharArray()) {
			if(Character.isUpperCase(c)) {
				hasUpperCase = true;
			}else if(Character.isLowerCase(c)) {
				hasLowerCase = true;
			}else if(Character.isDigit(c)) {
				hasNumber = true;
			}else{
				hasSymbol = true;
			}
		}
		
		if(password.length() < 8) {
			System.out.println("Uour password is too short. It should be at lease 8 characters.");
		}else if(password.length() < 16) {
			System.out.println("your password is decent, for strong password, consider using at lease 16 characters.");
		}else {
			System.out.println("Your password is good");
		}
		
		System.out.println("Does your password contain an uppercase letter ? " + (hasUpperCase ? "yes" : "no"));
		System.out.println("Does your password contain a lowercase letter ? " + (hasLowerCase ? "yes": "no"));
		System.out.println("Does your password contain a number ? " + (hasNumber ? "yes": "no"));
		System.out.println("Does your password contain a symbol ? " + (hasSymbol ? "yes" : "no"));
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
		
		System.out.println("Do you want uppercase letters in your password? (Y/N): ");
		boolean useUpperCase = sc.nextLine().equalsIgnoreCase("yes");
		System.out.println("Do you want lowerCase letters in your password? (Y/N): ");
		boolean useLowerCase = sc.nextLine().equalsIgnoreCase("yes");
		System.out.println("Do you want symbols in your password? (Y/N): ");
		boolean useSymbols = sc.nextLine().equalsIgnoreCase("Yes");
		System.out.println("Do you want numbers to your password? (Y/N): ");
		boolean useNumbers = sc.nextLine().equalsIgnoreCase("yes");
		
		System.out.println("Enter the length of password: ");
		int passwordLength = Integer.parseInt(sc.nextLine());
		
		String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String LowerCase = "abcdefghijklmnopqrstuvwxyz";
		String Symbols = "!@#$%^&*()_+{}|:<>?~";
		String Numbers = "1234567890";
		
		String character = "";
		if(useUpperCase) {
			character += upperCase;
		}
		if(useLowerCase) {
			character += LowerCase;
		}
		if(useSymbols) {
			character += Symbols;
		}
		if(useNumbers) {
			character += Numbers;
		}
		
		for(int i=0; i<passwordLength; i++) {
			char randomChar = character.charAt(random.nextInt(character.length()));
			password.append(randomChar);
		}
		System.out.println("Your password is: " +password.toString());
	}
}
