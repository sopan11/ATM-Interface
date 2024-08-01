public class Account {
    private int accNo;
    private String custName;
    private int pin;
    private double balance;
    private String uniqueId;

    public Account(){};

    public Account(int accNo, String custName, int pin, double balance, String uniqueId) {
        this.accNo = accNo;
        this.custName = custName;
        this.pin = pin;
        this.balance = balance;
        this.uniqueId = uniqueId;
    }

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
}
