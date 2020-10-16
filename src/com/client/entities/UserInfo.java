package com.client.entities;

import com.server.entity.QasarAccount;
import com.server.entity.QasarTransaction;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * A user representation with account and transaction information
 *
 * @author michaelf
 */
@XmlRootElement
public class UserInfo
{

    private long customerId;
    private String name;
    private String surname;

    private Account account;
    List<Transaction> transactions;

    public UserInfo(long customerId, String name, String surname, Account account, List<Transaction> transactions) {
        this.customerId = customerId;
        this.name = name;
        this.surname = surname;
        this.account = account;
        this.transactions = transactions;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
