package model;

public class ProductDoesNotExistWithThisIdException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProductDoesNotExistWithThisIdException() {		
		super("Product does not exist with this identification");
	}
}
