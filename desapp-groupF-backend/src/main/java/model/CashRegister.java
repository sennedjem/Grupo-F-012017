package model;

import java.util.ArrayList;
import java.util.List;

public class CashRegister implements Comparable<CashRegister> {

	private boolean open;
	private boolean busy;
	private List<Purchase> purchases;
	
	public CashRegister(){
		this.open = true;
		this.busy = false;
		this.purchases = new ArrayList<Purchase>();
	}
	
	public List<Purchase> getPurchases(){
		return this.purchases;
	} 
	
	public Long getWaitingTime(){
		Long totalTime = 0L;
		for(Purchase purchase : this.purchases){
			totalTime += purchase.getDurationOfPurchase();
		}
		return totalTime;
	}
	
	public boolean isOpen(){
		return this.open;
	}
	
	public boolean isBusy(){
		return this.busy;
	}
	
	public void setOpen(boolean stateOfCashRegister){
		this.open = stateOfCashRegister;
	}
	 
	public void advanceLine(){ 
		Purchase currentPurchase = this.purchases.get(0);
		this.purchases.remove(currentPurchase);
		this.processPurchase(currentPurchase);
		this.setNextPurchase();
	}
	
	public void processPurchase(Purchase aPurchase){
		try {
			this.busy = true;
			Thread.sleep(aPurchase.getDurationOfPurchase()); //Simulo la duracion del pedido en la caja
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
	
	public void setNextPurchase(){
		this.busy = false;
	}

	public int compareTo(CashRegister anotherCashRegister) {
		if(this.getWaitingTime() > anotherCashRegister.getWaitingTime()){
			return 1;
		}else{
			if (this.getWaitingTime() == anotherCashRegister.getWaitingTime()){
				return 0;
			}
			return -1;
		}
		
	}
	
	public void addPurchase(Purchase p){
		this.purchases.add(p);
	}

}
