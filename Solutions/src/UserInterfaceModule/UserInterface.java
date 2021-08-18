package UserInterfaceModule;

import java.util.Scanner;

import PlayerRepositoryModule.InvalidPlayerInformationException;
import PlayerRepositoryModule.Player;
import PlayerRepositoryModule.PlayerRepository;

public class UserInterface {
	
	private PlayerRepository playerRepository;
	private Scanner scanner;
	
	
	
	public UserInterface() {
		playerRepository = new PlayerRepository();
		scanner = new Scanner(System.in);
	}
	
	
	
	public void launchApplication() {
		System.out.println("Welcome! Please select the action you want to perform:\n"
				+ "1. Add Players to repository\n"
				+ "2. Form team");
		
		int option = scanner.nextInt();
		
		if (option == 1) {
			System.out.println("Enter the number of players that you would like to add.");
			
			int numberOfPlayers = scanner.nextInt();
			
			for (int i = 1; i <= numberOfPlayers; i++) {
				String name = null;
				String category = null;
				int rank = 0;
				
				System.out.println("Please enter the player name:");

				name = scanner.nextLine();

				while (category == null) {

					System.out.println("Please enter the player category from one of the following:"
							+ " \"Defender\", \"Mid fielder\", \"Forward\" or \"Goal keeper\".");

					try {
						category = scanner.nextLine();
					} catch (InvalidPlayerInformationException e) {
						System.out.println(e.getMessage());
					}
				}

				System.out.println("Please enter the player rank (should be greater than or equal to 1):");

				rank = scanner.nextInt();
				
				// The logic above is unfinished and incorrect since I ran out of time. Due to the same reason other methods are unimplemented.
			}
		}
	}

}
