package UserInterfaceModule;

import java.util.Scanner;

import PlayerRepositoryModule.InvalidPlayerInformationException;
import PlayerRepositoryModule.Player;
import PlayerRepositoryModule.PlayerAlreadyExistsException;
import PlayerRepositoryModule.PlayerRepository;
import PlayerRepositoryModule.TeamNotFormedException;

public class UserInterface {

	private PlayerRepository playerRepository;
	private Scanner scanner;



	public UserInterface() {
		playerRepository = new PlayerRepository();
		scanner = new Scanner(System.in);
	}



	public void launchApplication() {
		System.out.println("Welcome!");

		int option = -1;

		while (option != 0) {
			
			System.out.println("Please select the action you want to perform:\n"
					+ "1. Add Players to repository\n"
					+ "2. Form team\n"
					+ "0. Exit");

			option = scanner.nextInt();

			if (option == 1) {
				System.out.println("Enter the number of players that you would like to add.");

				int numberOfPlayers = scanner.nextInt();

				for (int i = 1; i <= numberOfPlayers; i++) {
					System.out.println("Please enter the name of player " + i + ": ");

					Player p = new Player(scanner.next());

					while (p.getCategory() == null) {
						System.out.println("Please enter the category of player " + i + " from one of the following:"
								+ " \"Defender\", \"Midfielder\", \"Forward\" or \"Goalkeeper\".");

						try {
							p.setCategory(scanner.next());
						} catch (InvalidPlayerInformationException e) {
							System.out.println(e.getMessage());
						}
					}

					while (p.getRank() == 0) {
						System.out.println("Please enter the rank of player " + i + ": ");

						try {
							p.setRank(scanner.nextInt());
						} catch (InvalidPlayerInformationException e) {
							System.out.println(e.getMessage());
						}
					}

					try {
						playerRepository.addPlayer(p);
					} catch (PlayerAlreadyExistsException e) {
						e.getMessage();
					}
				}
			}

			else if (option == 2) {
				try {
					String message = playerRepository.formTeam();
					System.out.println(message);
				} catch (TeamNotFormedException e) {
					System.out.println(e.getMessage());
				}
			}

			else if (option == 0) {
				break;
			}
		}
	}

}
