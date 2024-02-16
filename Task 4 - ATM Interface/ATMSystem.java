import java.util.Scanner;

public class ATMSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Account ac = new Account(2000);
        ATM atm = new ATM(ac);

        while (true){
            atm.showOptions();
            System.out.println("Select Option:");
            int option = input.nextInt();


            switch (option) {
                case 1:
                    System.out.println("Your Account Balance is :" + atm.checkBalance());
                    break;

                case 2:
                    System.out.println("Enter Your Amount to Withdraw: ");
                    double money = input.nextDouble();
                    atm.withdraw(money);
                    break;

                case 3:
                    System.out.println("Enter Your Amount to Deposit: ");
                    double depositMoney = input.nextDouble();
                    atm.deposit(depositMoney);
                    break;

                case 4:
                    System.out.println("Thank You for using our ATM......");
                    System.exit(0);
                    break;


            }
        }
    }
}
