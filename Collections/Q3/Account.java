package collections.Q3;

import Chapter4.Account.*;
import java.io.Serializable;

public class Account implements Serializable{
    
    private int accountNumber;
    private String accountName;
    private float accountBalance;

    public Account(int accNo, String accName, float accBalance) {
        this.accountNumber = accNo;
        this.accountName = accName;
        this.accountBalance = accBalance;
    }

    public int getAccNo() {
        return accountNumber;
    }

    public void setAccNo(int accNo) {
        this.accountNumber = accNo;
    }

    public String getAccName() {
        return accountName;
    }

    public void setAccName(String accName) {
        this.accountName = accName;
    }

    public float getAccBalance() {
        return accountBalance;
    }

    public void setAccBalance(float accBalance) {
        this.accountBalance = accBalance;
    }
    
    @Override
    public String toString() {
        return "Number : " + this.accountNumber + "\nName : " + this.accountName +
                "\nBalance : " + this.accountBalance ;
    }
}
