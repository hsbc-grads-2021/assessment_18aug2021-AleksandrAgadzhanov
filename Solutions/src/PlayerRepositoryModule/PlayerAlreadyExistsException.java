package PlayerRepositoryModule;

public class PlayerAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1336174504415761231L;

	
	
	public PlayerAlreadyExistsException(String message) {
		super(message);
	}

}
