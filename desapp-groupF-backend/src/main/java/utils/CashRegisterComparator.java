package utils;

import java.util.Comparator;

import model.CashRegister;

public class CashRegisterComparator implements Comparator<CashRegister>{

	public int compare(CashRegister cash1, CashRegister cash2) {
		if (cash1.getWaitingTime()>cash2.getWaitingTime()){
			return 1;
		} else if (cash1.getWaitingTime().equals(cash2.getWaitingTime())){
			return 0;
		}
		return -1;
	}

}
