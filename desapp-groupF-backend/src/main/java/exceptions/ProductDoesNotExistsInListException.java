package exceptions;

public class ProductDoesNotExistsInListException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductDoesNotExistsInListException() {		
		super("The selected product dos not exist on your shopping list.");
	}

}
