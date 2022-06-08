

public class BankAcc{
    private double checking;
    private double savings;

    public static int numberOfAccounts = 0;
    public static double totalAmount = 0;

    public BankAcc( double checkingAmount, double savingsAmount){
    this.checking = checkingAmount;
    this.savings = savingsAmount;
    numberOfAccounts++;
    totalAmount+= (checkingAmount + savingsAmount);
    }

     // getter
    public double getChecking() {
        return checking;
    }
    
    // setter
    public void setChecking(double checking) {
        totalAmount+= checking;
        this.checking += checking;
    }

         // getter
    public double getSavings() {
        return savings;
    }
    
    // setter
    public void setSavings(double savings) {
        totalAmount += savings;
        this.savings += savings;
    }

    public void checkingWithdraw(double withdrawAmt){
        if (this.checking >= withdrawAmt){
            this.checking -= withdrawAmt;
        }
        else{
            System.out.println("oops no monies");
        }
    }

    public void savingsWithdraw(double withdrawAmt){
        if (this.savings >= withdrawAmt){
            this.savings -= withdrawAmt;
        }
        else{
            System.out.println("oops no monies");
        }
    }

    public double checkTotal(){
        return this.checking + this.savings;
    }

}