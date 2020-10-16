package com.server.resources;

import com.server.entity.QasarAccount;
import com.server.entity.QasarTransaction;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * A user information with account and transactions to send to client via API
 *
 * @author michaelf
 */
@XmlRootElement
public class UserInformation
{
    private String customerId;
    private String name;
    private String surname;

    private QasarAccount qasarAccount;
    List<QasarTransaction> transactions;

    public UserInformation(String customerId, String name, String surname, QasarAccount qasarAccount, List<QasarTransaction> transactions) {
        this.customerId = customerId;
        this.name = name;
        this.surname = surname;
        this.qasarAccount = qasarAccount;
        this.transactions = transactions;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
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

    public QasarAccount getQasarAccount() {
        return qasarAccount;
    }

    public void setQasarAccount(QasarAccount qasarAccount) {
        this.qasarAccount = qasarAccount;
    }

    public List<QasarTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<QasarTransaction> transactions) {
        this.transactions = transactions;
    }
}
