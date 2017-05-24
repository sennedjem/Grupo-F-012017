package utils;

public class Money {
	
	private Integer entirePart;
	private Integer decimalPart;
	private Integer id;
	
	public Money(){

	}
	public Money(Integer entire, Integer decimal){
		this.entirePart = entire;
		this.decimalPart = decimal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer Id) {
		this.id = Id;
	}
	
	public Integer getEntirePart() {
		return entirePart;
	}

	public void setEntirePart(Integer entirePart) {
		this.entirePart = entirePart;
	}

	public Integer getDecimalPart() {
		return decimalPart;
	}

	public void setDecimalPart(Integer decimalPart) {
		this.decimalPart = decimalPart;
	}
	
	@Override
	public String toString(){
		return "$" + this.entirePart.toString() + "," + this.decimalPart.toString();
	}
	
	public Boolean higher(Money otherMoney){
		return (entirePart>otherMoney.getEntirePart()) || (entirePart.equals(otherMoney.getEntirePart()) && decimalPart > otherMoney.getDecimalPart());
	}
	
	@Override
	public boolean equals(Object moneyToCompare){
		if (moneyToCompare != null && moneyToCompare instanceof Money){
			Money newMoney = (Money) moneyToCompare;
			return this.entirePart.equals(newMoney.entirePart) && this.decimalPart.equals(newMoney.decimalPart);
		}
		return false;		
	}
	
	public void add(Money otherMoney){
		Integer newCents = this.addCents(otherMoney.decimalPart);
		this.entirePart += this.carryCents(otherMoney.decimalPart);
		this.entirePart += otherMoney.entirePart;
		this.decimalPart = newCents;
	}
	
	
	public Integer addCents(Integer cents){
		return (this.decimalPart + cents) % 100;
	}
	
	public Integer carryCents(Integer cents){
		return (this.decimalPart + cents) / 100;
	}
	
	public Money times(Integer quantity){
		Integer uncalculatedCents = this.decimalPart * quantity;
		Integer uncalculatedEntire = this.entirePart * quantity;
		Money result = new Money(0,0);
		Integer newCents = result.addCents(uncalculatedCents);
		Integer newCarry = result.carryCents(uncalculatedCents);
		newCarry += uncalculatedEntire;
		return new Money(newCarry, newCents);
	}
	
	public static Money toMoney(String string) {
		String current = "";
		Integer entire = 0;
		Integer decimal = 0;
		
		for(char c : string.toCharArray()){
			if(c == '.'){
				entire = Integer.parseInt(current);
				current = "";
			} else {
				current += c;
			}
		}
		
		decimal = Integer.parseInt(current);
		return new Money(entire, decimal);
	}

public boolean valid() {
		
		return this.id != null ;
	}

}
