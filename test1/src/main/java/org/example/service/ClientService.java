package org.example.service;

import org.example.Client;
import org.example.TransactionHelper;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final TransactionHelper transactionHelper;
    private final SessionFactory sessionFactory;

    public ClientService(TransactionHelper transactionHelper, SessionFactory sessionFactory) {
        this.transactionHelper = transactionHelper;
        this.sessionFactory = sessionFactory;
    }

    public Client saveClient(Client client){
        return transactionHelper.executeTransaction(session -> {
            session.persist(client);
            return client;
        });
    }
    public void removeClient(Long id){
        transactionHelper.executeTransaction(session -> {
            Client client=session.get(Client.class, id);
            session.remove(client);
        });
    }
    public Client updateClient(Client client){
        return transactionHelper.executeTransaction(session -> {
            return session.merge(client);
        });
    }

}
