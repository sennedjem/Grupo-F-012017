package exceptions;

public class MaxAmountExceededException extends Exception {

	private static final long serialVersionUID = 1L;

	public MaxAmountExceededException() {		
		super("Max Amount Exceeded");
	}
}
