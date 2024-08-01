import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AccountInfo accountInfo = new AccountInfo();
        Account[] accounts = new Account[3];
        for(int i=0; i<accounts.length; i++){
            System.out.println("Creating Account Mode");
            accounts[i] = accountInfo.createAccount();
        }

        RunATM runATM = new RunATM();
        for(; ;){
            runATM.demo(accounts);
        }
    }
}