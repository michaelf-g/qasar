package com.server.entity;

import java.util.Date;

/**
 * Main account can be of type Current
 *
 * @author michaelf
 */
public class QasarAccount
{
    public enum AccountStatus {None, Active, Suspended, Terminated}
    public enum AccountType {None, Current, Savings}

    private String customerId;
    private double balance;
    private int type;
    private int status;
    private Date createDate;

    public QasarAccount()
    {}

    public QasarAccount(String customerId, double balance, int type, Date createDate)
    {
        this.customerId = customerId;
        this.balance = balance;
        this.type = type;
        this.createDate = createDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void updateBalance(double amount)
    {
        this.balance += amount;
    }
}
