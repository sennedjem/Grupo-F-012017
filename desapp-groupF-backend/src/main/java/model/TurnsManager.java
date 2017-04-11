package model;

public class TurnsManager {

	private static TurnsManager instance = null;
	
	public void requestTurn() {
		// TODO Auto-generated method stub
		
	}

	public static TurnsManager getInstance() {
	      if(instance == null) {
	    	  instance = new TurnsManager();
	       }
	       return instance;
	}

}
