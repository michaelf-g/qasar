package com.server.entity;

import java.util.Date;

/**
 * Basic user CRM info object
 * Must exist before a Qasar accounts can be created
 *
 * @author michaelf
 */
public class QasarUserProfile
{
    private String id;          //customerId
    private String name;
    private String surname;
    private String address;
    private Date createDate;

    public QasarUserProfile() {
    }

    public QasarUserProfile(String name, String surname, String address, String id, Date createDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.createDate = createDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
