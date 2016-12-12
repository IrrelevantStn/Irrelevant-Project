/**
 * @author Aisha Ekangaki
 * UserDoesNotExistException.java creates an exception for when the user is not in the system
 */
public class UserDoesNotExistException extends RuntimeException{
	
	public UserDoesNotExistException(){
		super();
	}
	
	public UserDoesNotExistException(String message){
		super(message);
	}

}
