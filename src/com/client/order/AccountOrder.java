package com.client.order;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Order concept for requesting a new bank account from Qasar bank
 *
 * @author michaelf
 */
@XmlRootElement
public class AccountOrder
{
    public enum AccountOrderStatus {None, Pending, Approved, Complete, Cancelled, Failed};

    private String orderReference;
    private int orderStatusId;
    private int orderTypeId;
    private String customerId;
    private double initialCredit;

    public AccountOrder()
    {}

    public AccountOrder(String orderReference, int orderStatusId, int orderTypeId, String customerId, double initialCredit) {
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
