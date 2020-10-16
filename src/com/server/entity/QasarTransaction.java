package com.server.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Basic transaction entity for Qasar bank
 *
 * @author michaelf
 */
public class QasarTransaction
{
    public enum TransactionType {None, Deposit, Withdrawal, Payment, Transfer}
    public enum TransactionStatus {None, Pending, Approved, Complete, Cancelled, Failed }

    private String customerId;
    private double amount;
    private long debitLedgerAccountId;
    private long creditLedgerAccountId;
    private long transactionId;
    private long typeId;
    private long statusId;

    public QasarTransaction()
    {}

    public QasarTransaction(String customerId, double amount, long debitLedgerAccountId, long creditLedgerAccountId, long transactionId, long typeId, long statusId) {
        this.customerId = customerId;
        this.amount = amount;
        this.debitLedgerAccountId = debitLedgerAccountId;
        this.creditLedgerAccountId = creditLedgerAccountId;
        this.transactionId = transactionId;
        this.typeId = typeId;
        this.statusId = statusId;
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

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public long getStatusId() {
        return statusId;
    }

    public void setStatusId(long statusId) {
        this.statusId = statusId;
    }
}
