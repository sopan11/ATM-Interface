import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.util.Scanner;

public class AccountInfo {
    Scanner sc = new Scanner(System.in);
    public Account createAccount(){
        System.out.println("Enter Account Number: ");
        int accNo = sc.nextInt();
        System.out.println("Enter Customer Name: ");
        String customerName = sc.next();
        System.out.println("Enter Username: ");
        String uniqueId = sc.next();
        int pin = 0;
        do{
            System.out.println("Enter 4 digit pin: ");
            pin = sc.nextInt();
        }while ((pin<1000) || (pin>10000));

        System.out.println("Enter Initial account amount: ");
        double balance = sc.nextDouble();
        System.out.println("Account created successfully");

        String fileName = accNo+".txt";
        File file = new File(fileName);
        try {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("Account created");
            fileWriter.write("Account Number: "+accNo+"\n");
            fileWriter.write("Customer Name: "+customerName+"\n");
            fileWriter.write("User ID: "+uniqueId+"\n");
            fileWriter.write("PIN: "+pin+"\n");
            fileWriter.write("Balance: "+balance+"\n");
            fileWriter.write("Date: "+new Date()+"\n");
            fileWriter.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return new Account(accNo, customerName, pin, balance, uniqueId);
    }
}
