import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Account {

	//계좌번호
	String accountNo;
	//소유자명
	String name;
	//잔고
	long balance;
	//거래내역(0개 이상)
	List<Transaction> transactions = new ArrayList<>();
	Date date = new Date();
	//총 거래내역
	int totalTransaction;
	

	public Account() {}
	
	public Account(String accountNo, String name) {
		this.accountNo = accountNo;
		this.name = name;
	}
	
	
	
	//입금한다
	void deposit(long amount) {
		String transactionDate = date.day();
		String transcationTime = date.time();
		balance += amount;
		Transaction transaction = new Transaction(transactionDate, transcationTime, 0, amount, balance);
		transactions.add(transaction);
//		transactions[totalTransaction] = transaction;
		totalTransaction++;
	}
	
	//출금한다
	void withdraw(long amount) {
		String transactionDate = date.day();
		String transcationTime = date.time();
		balance -= amount;
		Transaction transaction = new Transaction(transactionDate, transcationTime, 1, amount, balance);
		transactions.add(transaction);
		totalTransaction++;
			
		
	}
	
	//잔고를 확인한다
	long getBalance() {
		return balance;
	}
	
	//거래내역을 본다
	List<Transaction> getTransactions() {
		return transactions;
	}

	@Override
	public String toString() {
		return " [계좌번호:" + accountNo + ", 소유자 명:" + name + ", 잔액:" + balance + "]";
	}
	
	

	
}
