//거래내역
public class Transaction {
	//거래일
	String transactionDate;
	//거래시간
	String transactionTime;
	//구분(입금 또는 출금) 0입금 1출금
	long kind;
	//거래금액
	long amount;
	//잔고
	long balance;
	
	public Transaction(long amount, long balance) {
		this.amount = amount;
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "[거래금액:" + amount + ", 잔액:" + balance+ "원 /"
				+ transactionDate+transactionTime + "]";
	}

	public Transaction(String transactionDate, String transactionTime, long kind, long amount, long balance) {
		super();
		this.transactionDate = transactionDate;
		this.transactionTime = transactionTime;
		this.kind = kind;
		this.amount = amount;
		this.balance = balance;
	}

	


}

