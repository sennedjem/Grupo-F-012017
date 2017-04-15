package model;

public class TurnsManager {

	private static TurnsManager turnManagerInstance = null;
	private static CheckoutManager checkoutManager = CheckoutManager.getInstance();
	
	public Turn requestTurn() {
		Turn turn = new Turn(checkoutManager.getNextCash());
		return turn;
		
	}

	public static TurnsManager getInstance() {
	      if(turnManagerInstance == null) {
	    	  turnManagerInstance = new TurnsManager();
	       }
	       return turnManagerInstance;
	}
	
	public void setCheckoutManager(CheckoutManager checkoutManager){
		this.checkoutManager = checkoutManager;
	}
	
	public CheckoutManager getCheckoutManager(){
		return checkoutManager;
	}

}
