package org.example;

import org.example.service.AccountService;
import org.example.service.ClientService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    static void main(String[] args) {
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext("org.example");

        ClientService clientService=context.getBean(ClientService.class);
        AccountService accountService=context.getBean(AccountService.class);

        Client client1=new Client("Pasha", "pashok@", 21312F);
        clientService.saveClient(client1);


        Account account1=new Account("1", "2131", 1212F, client1);
        accountService.saveAccount(account1);
        client1.getAccounts().add(account1);
        client1=clientService.updateClient(client1);
        System.out.println(client1.getAccounts().size());
    }
}