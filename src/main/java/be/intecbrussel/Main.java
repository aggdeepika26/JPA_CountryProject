package be.intecbrussel;

import be.intecbrussel.Service.CountryService;
import be.intecbrussel.model.Country;
import be.intecbrussel.model.President;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        President albert = new President("Albert" , 80);
        President macron = new President("Macron" , 60);
        President dina = new President("Dina Bolvarte" , 80);

        Country belgium = new Country("Belgium" , 110000000,albert);
        Country france = new Country("France" , 610000000,macron);
        Country peru = new Country("Peru" , 110000000,dina);
        CountryService cs = new CountryService();

        //create
        cs.createCountry(belgium);
        cs.createCountry(france);
        cs.createCountry(peru);

        //read
        Optional<Country> dbCountry = cs.readCountry("Peru");
        System.out.println(dbCountry.toString());


        //Update
        Country updatedCountry = new Country("Peru", 150000);
        cs.updateCountry(updatedCountry);

        //delete

        cs.deleteCountry("Peru");
        System.out.println("deleted country");






    }
}
