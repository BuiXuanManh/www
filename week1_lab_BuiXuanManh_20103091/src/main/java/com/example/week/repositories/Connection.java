package com.example.week.repositories;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Connection {
    private EntityManagerFactory emf;
    private static Connection instance;

    private Connection() {
        emf= Persistence.createEntityManagerFactory("default");
    }

    public static Connection getInstance() {
        if(instance==null)
            instance= new Connection();
        return instance;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }
}
