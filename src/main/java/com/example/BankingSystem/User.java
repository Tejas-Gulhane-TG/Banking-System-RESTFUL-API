package com.example.BankingSystem;

public class User {
    private String name;
    private int accountNo;
    private int age;
    private int password;
    private double balance;
    private String address;

    public User(String name, int accountNo, int age, int password, double balance, String address) {
        this.name = name;
        this.accountNo = accountNo;
        this.age = age;
        this.password = password;
        this.balance = balance;
        this.address = address;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
