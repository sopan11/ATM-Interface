import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class ATM {
    Scanner sc = new Scanner(System.in);

    public void withdraw(Account account) {
        System.out.println("Withdraw Money");
        System.out.println("Enter Amount with multiple of 100: ");
        double amount = sc.nextDouble();
        if (amount % 100 == 0) {
            if (account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
                System.out.println("Transaction is Processing...");
                try {
                    String fileName = account.getAccNo() + ".txt";
                    FileWriter fileWriter = new FileWriter(fileName, true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                    bufferedWriter.write("Date: " + new Date()+"\n"+"\n");
                    bufferedWriter.write("Withdrawal: " + amount+"\n");
                    bufferedWriter.write("Account Number: " + account+"\n");
                    bufferedWriter.write("Remaining Balance: " + account.getBalance()+"\n");

                    bufferedWriter.close();
                    fileWriter.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                System.out.println("Insufficient balance");
            }
        }
    }

    public void depositByTransfer(Account account, double amount) {
        account.setBalance(account.getBalance() + amount);
        try {
            String fileName = account.getAccNo() + ".txt";
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Date: " + new Date()+"\n"+"\n");
            bufferedWriter.write("Deposit: " + amount+"\n");
            bufferedWriter.write("Account Number: " + account.getAccNo()+"\n");
            bufferedWriter.write("Remaining Balance: " + account.getBalance()+"\n");
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deposit(Account account) {
        System.out.println("Enter money to deposit in account: ");
        double amount = sc.nextDouble();
        account.setBalance(account.getBalance() + amount);

        try {
            String fileName = account.getAccNo() + ".txt";
            System.out.println("File Name: "+fileName);
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Date: "+new Date()+"\n"+"\n");
            bufferedWriter.write("Deposit: "+amount+"\n");
            bufferedWriter.write("Account Number: "+account.getAccNo()+"\n");
            bufferedWriter.write("Account Balance: "+account.getBalance()+"\n");
            bufferedWriter.close();
            fileWriter.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void Transfer(Account account1, Account account2, double amount){
        if(account1.getBalance() >= amount){
            account1.setBalance(account1.getBalance()-amount);

            ATM atm = new ATM();
            atm.depositByTransfer(account2, amount);

            try {
                String fileName = account1.getAccNo()+".txt";
                FileWriter fileWriter = new FileWriter(fileName, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write("Date: "+new Date()+"\n"+"\n");
                bufferedWriter.write("Deposit: "+amount+"\n");
                bufferedWriter.write("Account Number: "+account1.getAccNo()+"\n");
                bufferedWriter.write("Account Balance: "+account1.getBalance()+"\n");
                bufferedWriter.close();
                fileWriter.close();
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        else{
            System.out.println("Insufficient Balance");
        }
    }

    public void displayDetails(Account account){
        System.out.println("Displaying Account Details");
        try{
            Thread.sleep(2000);

        }
        catch (Exception e){
            System.out.println(e);
        }
        try{
            String fileName = account.getAccNo()+".txt";
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while((line = bufferedReader.readLine())!=null){
                System.out.println(line);
            }
            bufferedReader.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void quit(){
        System.out.println("Thank You");
        return;
    }
}