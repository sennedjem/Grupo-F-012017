package model;

public class CheckoutManager {
	private static CheckoutManager checkoutManagerInstance = null;
	
	public static CheckoutManager getInstance() {
	      if(checkoutManagerInstance == null) {
	    	  checkoutManagerInstance = new CheckoutManager();
	       }
	       return checkoutManagerInstance;
	}

	public Object getNextCash() {
		// TODO Auto-generated method stub
		return null;
	}


}
