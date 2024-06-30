import java.util.ArrayList;
import java.util.List;

public class Bank {
	List<Account> accounts = new ArrayList<>();
	int totalAccount;
	
	//계좌를 생성한다
	void addAccount(String accountNo, String name) {
		accounts.add(new Account(accountNo, name));
		totalAccount = accounts.size();
	}
	
	//계좌를 찾는다(계좌번호로)
	Account getAccount(String accountNo) {
		for(Account ac : accounts) {
			if(ac.accountNo.equals(accountNo)) {
				return ac;
			}
		}
		return null;
	}
	
	//계좌를 찾는다(소유자명으로)
	List<Account> findAccounts(String name) {
		List<Account> tempAccount = new ArrayList<>();
		for(Account ac : accounts) {
			if(ac.name.equals(name)) {
				tempAccount.add(ac);
			}
		}
		return tempAccount;
	}
	
	//계좌목록을 본다
	//총 계좌 수를 반환한다
	int getTotalAccount() {
		return totalAccount;
	}

	//계좌목록을 본다
	public List<Account> getAccounts() {
		return accounts;
	}

	
	
	
}
