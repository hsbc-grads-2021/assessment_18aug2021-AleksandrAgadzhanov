package PlayerRepositoryModule;  // Mentor Comment: package names should be in lowercase letters. Usually company names web url is be included in package names. "com.hsbc.player.repositorymodule" could be an ideal name

import java.util.ArrayList;

public class PlayerRepository {
	
	private ArrayList<Player> players;
	private int numberOfDefenders;
	private int numberOfMidFielders;
	private int numberOfForwards;
	private int numberOfGoalKeepers;
	
	
	
	public PlayerRepository() {
		players = new ArrayList<>();
	}
	
	
	
	public void addPlayer(Player p) throws PlayerAlreadyExistsException { // Mentor Comment : instead of the parameter name as "p", it could be "player"
		for (Player storedPlayer : players) { // Mentor Comment : You could have used this.players while refering to the member variable(though in this case it is not required)
			if (storedPlayer.equals(p)) {
				throw new PlayerAlreadyExistsException("This player already exists in the repository.");
			}
		}
		
		String category = p.getCategory();
		
		switch (category) {
		case "Defender": numberOfDefenders++; break;
		case "Midfielder": numberOfMidFielders++; break;
		case "Forward": numberOfForwards++; break;
		case "Goalkeeper": numberOfGoalKeepers++; break;
				
		// Mentor Commnet : default case?
		}
		
		players.add(p); // Mentor Comment: Same as mentioned in Line 22
	}
	
	
	
	public String formTeam() throws TeamNotFormedException {
		if (numberOfDefenders < 4 || numberOfMidFielders < 3 || numberOfForwards < 3 || numberOfGoalKeepers < 1) {
			throw new TeamNotFormedException("There are not enough players to form a team. Current number of players in each category:\n"
					+ "Number of Defenders: " + numberOfDefenders + " (4 required)\n"
							+ "Number of Midfielders: " + numberOfMidFielders + " (3 required)\n"
									+ "Number of Forwards: " + numberOfForwards + " (3 required)\n"
											+ "Number of Goalkeepers: " + numberOfGoalKeepers + " (1 required)\n");
		}
		else {
			StringBuilder sb = new StringBuilder("Team formed with 11 players:\n"
					+ "S No., Player Name, Category, Rank\n");
			int addedDefenders = 0;
			int addedMidFielders = 0;
			int addedForwards = 0;
			int addedGoalKeepers = 0;
			
			for (int i = 0; i < players.size(); i++) {
				Player currentPlayer = players.get(i);
				boolean shouldBeAdded = false;
				
				if (addedDefenders < 4 && currentPlayer.getCategory().equals("Defender")) {
					addedDefenders++;
					shouldBeAdded = true;
				}
				else if (addedMidFielders < 3 && currentPlayer.getCategory().equals("Midfielder")) {
					addedMidFielders++;
					shouldBeAdded = true;
				}
				else if (addedForwards < 3 && currentPlayer.getCategory().equals("Forward")) {
					addedForwards++;
					shouldBeAdded = true;
				}
				else if (addedGoalKeepers < 1 && currentPlayer.getCategory().equals("Goalkeeper")) {
					addedGoalKeepers++;
					shouldBeAdded = true;
				}
				
				if (shouldBeAdded) {
					sb.append((i+1) + ", " + currentPlayer.getName() + ", " + currentPlayer.getCategory() +
							", " + currentPlayer.getRank() + "\n");
				}
				
				if (addedDefenders == 4 && addedMidFielders == 3 && addedForwards == 3 && addedGoalKeepers == 1) {
					break;
				}
			}
			
			return sb.toString();
			
		}
	}

}
