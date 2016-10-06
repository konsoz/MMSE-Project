package model;

public enum Role {
	CustomerService("Customer Service"),
	SeniorCustomerService("Seniour Customer Service"),
	FinancialManager("Financial Manager"),
	AdministrationManager("Administration Manager");
	
	private final String text;
	
	private Role(final String text){
		this.text = text;
	}
	
	
	@Override
	public String toString(){
		return text;
	}
}
