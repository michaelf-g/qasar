package com.client.entities;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * @author michaelf
 */
@XmlRootElement
public class Account
{
    public enum AccountType {None, Current, Savings}

    private String customerId;
    private double balance;
    private int type;
    private Date createDate;

    public Account()
    {}

    public Account(String customerId, double balance, int type, Date createDate)
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
}
