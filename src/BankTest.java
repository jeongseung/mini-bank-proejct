import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankTest {
   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      // 사용자가 0을 입력하면 시스템이 종료되도록 설정
      boolean continueCheck = true;
      Bank bank = new Bank();
      while (continueCheck) {
         System.out.println("============================================");
         System.out.println("1. 계좌 생성");
         System.out.println("2. 계좌번호로 계좌 조회");
         System.out.println("3. 소유자명으로 계좌 조회");
         System.out.println("4. 계좌 목록");
         System.out.println("5. 총 계좌 수");
         System.out.println("6. 입금");
         System.out.println("7. 출금");
         System.out.println("8. 잔고 확인");
         System.out.println("9. 거래내역");
         System.out.println("0. 종료");
         System.out.println("============================================");
         System.out.print("필요하신 서비스를 번호로 입력해주세요 : ");
         int input = sc.nextInt();
         switch (input) {
         case 1: {
            System.out.print("생성할 계좌 번호를 입력하세요 : ");
            String accountNo = sc.next();
            // 이미 있는 계좌 처리
            boolean accountCheck = false;
            boolean isAccount = accountNo.matches("[+-]?\\d*(\\.\\d+)?");
            for (Account account : bank.getAccounts()) {
               if (account.accountNo.equals(accountNo)) {
                  accountCheck = true;
                  break;
               }
            }
            if (accountCheck) {
               System.out.println("이미 존재하는 계좌 번호입니다. 메인 메뉴로 돌아갑니다.");
            } 
            else if(!isAccount){
               System.out.println("숫자만 입력가능합니다. 메인 메뉴로 돌아갑니다.");
            }
            else {
               System.out.print("소유자명을 입력하세요 : ");
               String name = sc.next();
               
               bank.addAccount(accountNo, name);
               System.out.println("계좌가 성공적으로 생성되었습니다.");
            }
            break;
         }
         case 2: {
            System.out.print("조회할 계좌번호를 입력하세요 : ");
            String accountNo = sc.next();
            Account account = bank.getAccount(accountNo);
            if (account != null) {
               System.out.println("= 해당 계좌번호의 계좌정보 =\n" + account);
            } else {
               System.out.println("해당 계좌를 찾을 수 없습니다.");
            }
            break;
         }
         case 3: {
            System.out.print("조회할 소유자명을 입력하세요 :");
            String name = sc.next();
            List<Account> accounts = bank.findAccounts(name);
            if (!accounts.isEmpty()) {
               System.out.println("= 해당 소유자명의 계좌 목록 =");
               for (Account account : accounts) {
                  System.out.println(account);
               }
            } else {
               System.out.println("해당 소유자명을 가진 계좌를 찾을 수 없습니다.");
            }
            break;
         }
         case 4: {
            System.out.println("계좌 목록 : ");
            List<Account> accounts = bank.getAccounts();
            for (Account account : accounts) {
               System.out.println(account);
            }
            break;
         }
         case 5: {
            System.out.println("총 계좌 수 :  " + bank.getTotalAccount());
            break;
         }
         case 6: {
            System.out.print("입금할 계좌 번호를 입력하세요 : ");
            String accountNo = sc.next();
            Account account = bank.getAccount(accountNo);
            if (account != null) {
               System.out.print("입금할 금액을 입력하세요 : ");
               long amount = sc.nextLong();
               account.deposit(amount);
               System.out.println(amount + "원 입금하셨습니다.\n현재 잔액은 " + account.getBalance() + "원 입니다.");
            } else {
               System.out.println("해당 계좌를 찾을 수 없습니다.");
            }
            break;
         }
         case 7: {
            System.out.print("출금할 계좌 번호를 입력하세요 : ");
            String accountNo = sc.next();
            Account account = bank.getAccount(accountNo);
            if (account != null) {
               System.out.print("출금할 금액을 입력하세요 : ");
               long amount = sc.nextLong();
               if (account.getBalance() >= amount) {
                  account.withdraw(amount);
                  System.out.println(amount + "원 인출하셨습니다.\n현재 잔액은 " + account.getBalance() + "원 입니다.");
               } else {
                  System.out.println("잔액이 부족합니다.");
               }
            } else {
               System.out.println("해당 계좌를 찾을 수 없습니다.");
            }
            break;
         }
         case 8: {
            System.out.print("잔고를 확인할 계좌 번호를 입력하세요 : ");
            String accountNo = sc.next();
            Account account = bank.getAccount(accountNo);
            if (account != null) {
               System.out.println("현재 잔액은 " + account.getBalance() + "원 입니다.");
            } else {
               System.out.println("해당 계좌를 찾을 수 없습니다.");
            }
            break;
         }
         case 9: {
            System.out.print("거래내역을 확인할 계좌 번호를 입력하세요 : ");
            String accountNo = sc.next();
            Account account = bank.getAccount(accountNo);
            if (account != null) {
               System.out.println("= 거래내역 =");
               List<Transaction> transactions = account.getTransactions();
               for (Transaction transaction : transactions) {
                  System.out.println(transaction);
               }
            } else {
               System.out.println("해당 계좌를 찾을 수 없습니다.");
            }
            break;
         }
         case 0: {
            continueCheck = false;
            System.out.println("프로그램을 종료합니다");

            sc.close();
         }

         default:

         }
      }

   }

}
