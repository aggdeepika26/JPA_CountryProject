package be.intecbrussel.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvider {

    private static EntityManagerFactory enf = Persistence.createEntityManagerFactory("persistence-pu");
    public static EntityManager getEntityManager() {return enf.createEntityManager();}
}
