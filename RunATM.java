import java.util.Objects;
import java.util.Scanner;

public class RunATM {
    ATM atm = new ATM();

    public int accSearchByUniqueId(Account[] accounts, String uniqueId) {
        for (int i = 0; i < accounts.length; i++) {
            if (Objects.equals(uniqueId, accounts[i].getUniqueId())) {
                return i;
            }
        }
        return -1;
    }

    public int accSearchByUniqueId(Account[] accounts, int accNo) {
        for (int i = 0; i < accounts.length; i++) {
            if (Objects.equals(accNo, accounts[i].getAccNo())) {
                return i;
            }
        }
        return -1;
    }

    public void demo(Account[] accounts) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to ATM");
        System.out.println("Enter unique Id: ");
        String uniqueId = sc.next();
        int i = accSearchByUniqueId(accounts, uniqueId);
        if (i == -1) {
            System.out.println("Account Not registered yet");
            return;
        } else {
            System.out.println("Enter Your PIN: ");
            int pin = sc.nextInt();
            if (pin == accounts[i].getPin()) {
                do {
                System.out.println("1.Withdraw\n2.Deposit\n3.Account Transfer\n4.Display Account details");
                System.out.println("Enter your choice: ");
                int ch = sc.nextInt();
                    switch (ch) {
                        case 1:
                            System.out.flush();
                            atm.withdraw(accounts[i]);
                            break;

                        case 2:
                            System.out.flush();
                            atm.deposit(accounts[i]);
                            break;

                        case 3:
                            System.out.flush();
                            System.out.println("Enter account number to transfer fund");
                            int accNo = sc.nextInt();
                            int j = accSearchByUniqueId(accounts, accNo);
                            if (j == -1) {
                                System.out.println("Account not yet Registered");
                                return;
                            } else {
                                System.out.println("Enter Amount  for transferring funds: ");
                                double amount = sc.nextDouble();
                                atm.Transfer(accounts[i], accounts[j], amount);
                            }
                            break;

                        case 4:
                            System.out.flush();
                            atm.displayDetails(accounts[i]);
                            break;

                        default:
                            System.out.println("Invalid choice");
                    }
                    System.out.println("Do you want to continue: ");
                }while (sc.next().equals("yes"));
                return;
            }

        }
    }
}