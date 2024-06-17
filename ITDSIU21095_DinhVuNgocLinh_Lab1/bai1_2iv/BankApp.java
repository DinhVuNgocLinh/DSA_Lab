package bai1_2iv;

public class BankApp {
  public static void main(String[] args) {
    BankAccount ba1 = new BankAccount(100.00); // create acct

    // System.out.print("Before transactions, ");
    // ba1.display(); // display balance
    System.out.println("Before transactions " + BankAccount.balanceOfAcc());

    ba1.deposit(74.35); // make deposit
    ba1.withdraw(20.00); // make withdrawal

    // System.out.print("After transactions, ");
    // ba1.display(); // display balance

    System.out.println("After transactions " + BankAccount.balanceOfAcc());
  } // end main()
}
