public class TestBank {
    public static void main(String[] args) {
        BankAcc account1 = new BankAcc(10.99, 5.99);
        BankAcc account2 = new BankAcc(5.99, 3.99);
        account2.setSavings(10);
        account2.checkingWithdraw(10000);
        account2.savingsWithdraw(10000);
        System.out.println(account2.checkTotal());
        System.out.println(account2.getSavings()); 
        System.out.println(BankAcc.numberOfAccounts);
        System.out.println(BankAcc.totalAmount);
    }
}

