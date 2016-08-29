
public class BankAccount {
	String name;
	int balance;
	int trans;
	
	public BankAccount(String account){
		name = account;
	}
	
	public void deposit(int amount){
		balance = balance + amount;
		trans = trans + 1;
	}
	
	public void withdraw(int amount){
		balance = balance - amount;
		trans = trans +1;
	}
	
	public int getBalance(){
		return balance;
	}
	
	public int getNumTransactions(){
		return trans;
	}
	public String toString(){
		return name;
	}
	
	public void transfer(int amount, BankAccount destination) {
	    balance = balance - amount;
	    trans = trans + 1;
	    destination.balance = destination.balance + amount;
	    destination.trans = destination.trans + 1;
	}
}
