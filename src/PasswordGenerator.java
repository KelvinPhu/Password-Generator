import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {
	
	private Scanner sc = new Scanner(System.in);
	
	PasswordGenerator() {
        menu();
    }
	
	void menu() {
		while (true) {
			System.out.println("1. Generate a strong password\n2. Convert your password to encrypted format");
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

	private void encryptPassword() {
		
	}

	private void generatePassword() {
		int passwordLength = 50;
		SecureRandom random = new SecureRandom();
		StringBuilder password = new StringBuilder();
		for(int i=0; i<passwordLength; i++) {
			char randomChar = (char) (random.nextInt(95) + 32);
			password.append(randomChar);
		}
		System.out.println("Your password is: " + password.toString());
	}
}
