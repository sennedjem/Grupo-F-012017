package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckoutManager {
	private static CheckoutManager checkoutManagerInstance = null;
	
	private List<CashRegister> cashes;
	
	public CheckoutManager(Integer quantityOfCashes){
		this.cashes = new ArrayList<CashRegister>();
		this.initializeCashes(quantityOfCashes);
	}
	
	
	public void initializeCashes(Integer quantityOfCashes){
		for (Integer i=0; i < quantityOfCashes; i++){
			this.cashes.add(new CashRegister());
		}
	}
	
	public CashRegister getNextCash() {
		Collections.sort(this.cashes);
		return this.cashes.get(0);
	}

	public void setCashes(List<CashRegister> cashes){
		this.cashes = cashes;
	}
	
	public List<CashRegister> getCashes(){
		return this.cashes;
	}
	
	public void setCheckoutManagerInstance(Object o){
		this.checkoutManagerInstance = (CheckoutManager) o;
	}
	
	public static CheckoutManager getInstance() {
	      if(checkoutManagerInstance == null) {
	    	  checkoutManagerInstance = new CheckoutManager(20);
	       }
	       return checkoutManagerInstance;
	}


}
