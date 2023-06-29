package com.ses.jdbc.model;

public class BankAccountInfo {
    private Long id;
    private String fullName;
    private Double balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public BankAccountInfo(Long id, String fullName, Double balance) {
        this.id = id;
        this.fullName = fullName;
        this.balance = balance;
    }

}
