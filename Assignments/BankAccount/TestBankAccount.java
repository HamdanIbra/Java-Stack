public class TestBankAccount{
    public static void main(String[] args){
        BankAccount account1=new BankAccount(1000,1000);

        System.out.println(account1.getCheckingBalance());
        System.out.println(account1.getsavingsBalance());
        account1.depositToCheckingBalance(500);
        account1.depositToSavingsBalance(200);
        System.out.println(account1.getCheckingBalance());
        System.out.println(account1.getsavingsBalance());
        account1.withdrawFromCheckingBalance(300);
        account1.withdrawFromSavingsBalance(600);
        System.out.println(account1.getCheckingBalance());
        System.out.println(account1.getsavingsBalance());

        System.out.println(account1.getTotalBalance());

    }
}