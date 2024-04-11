package be.intecbrussel.Service;

import be.intecbrussel.connection.EntityManagerProvider;
import be.intecbrussel.model.Country;
import be.intecbrussel.repository.CountryRepository;
import net.bytebuddy.dynamic.DynamicType;

import javax.persistence.EntityManager;
import java.util.Optional;

public class CountryService {
    private CountryRepository countryRepository = new CountryRepository();
    public void createCountry(Country country)
    {
        EntityManager en = EntityManagerProvider.getEntityManager();
        countryRepository.createCountry(en,country);
        en.close();
    }

    public Optional<Country> readCountry(String name)
    {
        EntityManager en = EntityManagerProvider.getEntityManager();
       Optional<Country> optionalCountry = countryRepository.readCountry(en,name);
        en.close();
        return optionalCountry;
    }

    public void deleteCountry(String name)
    {
        EntityManager en = EntityManagerProvider.getEntityManager();
        Optional<Country> country = countryRepository.readCountry(en,name);
        if(country.isPresent())
        {
            countryRepository.deleteCountry(en, country.get());
        }
        en.close();
    }

    public void updateCountry(Country country)
    {

        EntityManager en = EntityManagerProvider.getEntityManager();
        String countryName = country.getName();
        Optional<Country> dbOptionalCountry = countryRepository.readCountry(en, countryName );
        if(dbOptionalCountry.isEmpty())
        {
            en.close();
            return;
        }
        Country dbCountry = dbOptionalCountry.get();

        dbCountry.setName(country.getName());
        dbCountry.setPopulation(country.getPopulation());

        countryRepository.updateCountry(en,dbCountry);




        en.close();

    }






}
