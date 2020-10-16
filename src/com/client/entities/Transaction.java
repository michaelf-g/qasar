package com.client.entities;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author michaelf
 */
@XmlRootElement
public class Transaction
{
    public enum TransactionType {None, Deposit, Withdrawal, Payment, Transfer}

    private String customerId;
    private double amount;
    private long debitLedgerAccountId;
    private long creditLedgerAccountId;
    private long transactionId;

    public Transaction() {
    }

    public Transaction(String customerId, double amount, long debitLedgerAccountId, long creditLedgerAccountId, long transactionId) {
        this.customerId = customerId;
        this.amount = amount;
        this.debitLedgerAccountId = debitLedgerAccountId;
        this.creditLedgerAccountId = creditLedgerAccountId;
        this.transactionId = transactionId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getDebitLedgerAccountId() {
        return debitLedgerAccountId;
    }

    public void setDebitLedgerAccountId(long debitLedgerAccountId) {
        this.debitLedgerAccountId = debitLedgerAccountId;
    }

    public long getCreditLedgerAccountId() {
        return creditLedgerAccountId;
    }

    public void setCreditLedgerAccountId(long creditLedgerAccountId) {
        this.creditLedgerAccountId = creditLedgerAccountId;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }
}
