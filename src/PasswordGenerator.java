import java.util.Scanner;

public class PasswordGenerator {
	
	private Scanner sc;
	
	PasswordGenerator() {
        sc = new Scanner(System.in);
        
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
		// TODO Auto-generated method stub
		
	}

	private void generatePassword() {
		// TODO Auto-generated method stub
		
	}
}
