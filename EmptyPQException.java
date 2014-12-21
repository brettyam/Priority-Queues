/**
* This exception signifies an invalid access on an empty heap.
*/
public class EmptyPQException extends RuntimeException {
	public EmptyPQException() 
	{}

	public EmptyPQException(String message) {
		super(message);
	}
}