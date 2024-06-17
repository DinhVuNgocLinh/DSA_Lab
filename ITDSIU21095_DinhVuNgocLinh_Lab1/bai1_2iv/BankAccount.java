package bai1_2iv;

public class BankAccount {
   static Object balance; // account balance

   public BankAccount(double openingBalance) { // constructor
      balance = openingBalance;
   }

   public void deposit(double amount) // makes deposit
   {
      balance = (double) balance + amount;
   }

   public void withdraw(double amount) // makes withdrawal
   {
      balance = (double) balance - amount;
   }

   public void display() // displays balance
   {
      System.out.println("balance=" + balance);
      System.out.println("Type is " + balance.getClass().getSimpleName()); // print data type
   }

   // anpther method to output balance
   public static Object balanceOfAcc() {
      return balance;
   }

}
