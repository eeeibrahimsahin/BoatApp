package com.company.Room3;

import sun.security.util.Password;

public class Employee {
    private static int count = 1;
    private int employeeId;
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String emailAddress;
    private String userName;
    private String password;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String telephoneNumber, String emailAddress) {
        this.employeeId = count;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.emailAddress = emailAddress;
        count++;
    }

    public Employee( String firstName, String lastName, String telephoneNumber, String emailAddress, String userName, String password) {
        this.employeeId = count;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.emailAddress = emailAddress;
        this.userName = userName;
        this.password = password;
        count++;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
