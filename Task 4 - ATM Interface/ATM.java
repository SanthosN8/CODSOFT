public class ATM {
    Account account;

    public ATM(Account account){
        this.account = account;
    }

    public void showOptions(){
        System.out.println("-----ATM Options-----");
        System.out.println("1: Check Balance");
        System.out.println("2: Withdraw");
        System.out.println("3:Deposit");
        System.out.println("4: Cancel");
    }

    //check balance
    public double checkBalance(){
        double balance  = account.getBalance();
        return balance;
    }

    //withdraw amount
    public boolean withdraw(double amount){
        if(amount<account.getBalance()){
            double withdraw = (account.getBalance() - amount);
            account.setBalance(withdraw);
            System.out.println("Successfully withdraw Rs." + amount);

            return true;
        }else {
            return false;
        }
    }

    //deposit money
    public void deposit(double amount){
        account.setBalance((account.getBalance()+amount));
        System.out.println("You successfully deposited Rs. "+amount);
        System.out.println("Your Account balance is Rs."+ account.getBalance());
    }
}
