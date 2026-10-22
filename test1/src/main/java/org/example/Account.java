package org.example;

import jakarta.persistence.*;

@Entity
@Table
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String accountNumber;

    @Column
    private String currency;


    public Account(String accountNumber, String currency, Float balance, Client client) {
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.balance = balance;
        this.client = client;
    }

    @Column
    private Float balance;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }

    public Account(String accountNumber, String currency) {
        this.accountNumber = accountNumber;
        this.currency = currency;
    }

    public Account() {
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
