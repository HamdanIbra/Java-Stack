public class BankAccount{
    private double checkingBalance;
    private double savingsBalance;
    private static int numberOfAccounts = 0;
    public BankAccount(double checkingBalance, double savingsBalance){
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        BankAccount.numberOfAccounts++;
    }

    public double getCheckingBalance(){
        return this.checkingBalance;
    }

    public double getsavingsBalance(){
        return this.savingsBalance;
    }

    public void depositToCheckingBalance(double deposit){
        this.checkingBalance+=deposit;
    }

    public void depositToSavingsBalance(double deposit){
        this.savingsBalance+=deposit;
    }

    public void withdrawFromCheckingBalance(double withdraw){
        if (this.checkingBalance > withdraw){
            this.checkingBalance -= withdraw;
        }
    }

    public void withdrawFromSavingsBalance(double withdraw){
        if (this.savingsBalance > withdraw){
            this.savingsBalance -= withdraw;
        }
    }

    public double getTotalBalance(){
        double total=this.checkingBalance+this.savingsBalance;
        return total;
    }


}