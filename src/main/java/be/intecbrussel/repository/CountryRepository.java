package be.intecbrussel.repository;

import be.intecbrussel.connection.EntityManagerProvider;
import be.intecbrussel.model.Country;

import javax.persistence.EntityManager;
import java.util.Optional;

public class CountryRepository {
    public void createCountry(EntityManager en , Country country)
    {
        en.getTransaction().begin();
        en.persist(country);
        en.getTransaction().commit();
    }

    public Optional<Country> readCountry(EntityManager en , String name)
    {
        Country country = en.find(Country.class,name);
        return Optional.ofNullable(country);
    }

    public void deleteCountry(EntityManager en , Country country)
    {
        en.getTransaction().begin();
        en.remove(country);
        en.getTransaction().commit();
    }


   public void updateCountry(EntityManager en , Country country)
    {
        en.getTransaction().begin();

        en.merge(country);
        en.getTransaction().commit();
    }





}
