package com.server.orders;

import com.client.order.AccountOrder;

/**
 * Qasar bank account orders created from API client orders
 * This object will hold the client's request for a new account
 *
 * @author michaelf
 */
public class QasarAccountOrder
{
    private enum AccountOrderStatus {None, Pending, Approved, Complete, Cancelled, Failed};

    private String orderReference;
    private int orderStatusId;
    private int orderTypeId;

    private String customerId;
    private double initialCredit;

    public QasarAccountOrder()
    {}

    public QasarAccountOrder(AccountOrder newAccountOrder)
    {
        this.orderReference = newAccountOrder.getOrderReference();
        this.orderStatusId = AccountOrderStatus.Pending.ordinal();
        this.orderTypeId = newAccountOrder.getOrderTypeId();
        this.customerId = newAccountOrder.getCustomerId();
        this.initialCredit = newAccountOrder.getInitialCredit();
    }

    public QasarAccountOrder(String orderReference, int orderStatusId, int orderTypeId, String customerId, double initialCredit) {
        this.orderReference = orderReference;
        this.orderStatusId = orderStatusId;
        this.orderTypeId = orderTypeId;
        this.customerId = customerId;
        this.initialCredit = initialCredit;
    }

    public String getOrderReference() {
        return orderReference;
    }

    public void setOrderReference(String orderReference) {
        this.orderReference = orderReference;
    }

    public int getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(int orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public int getOrderTypeId() {
        return orderTypeId;
    }

    public void setOrderTypeId(int orderTypeId) {
        this.orderTypeId = orderTypeId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getInitialCredit() {
        return initialCredit;
    }

    public void setInitialCredit(double initialCredit) {
        this.initialCredit = initialCredit;
    }
}
