package org.example.service;

import org.example.Account;
import org.example.Client;
import org.example.TransactionHelper;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final TransactionHelper transactionHelper;
    private final SessionFactory sessionFactory;

    public AccountService(TransactionHelper transactionHelper, SessionFactory sessionFactory) {
        this.transactionHelper = transactionHelper;
        this.sessionFactory = sessionFactory;
    }

    public Account saveAccount(Account account){
        return transactionHelper.executeTransaction(session -> {
            session.persist(account);
            return account;
        });
    }

    public Account updateAccount(Account account){
        return transactionHelper.executeTransaction(session -> {
            return session.merge(account);
        });
    }
}
