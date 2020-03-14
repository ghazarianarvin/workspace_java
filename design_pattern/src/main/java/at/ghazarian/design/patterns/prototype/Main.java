package at.ghazarian.design.patterns.prototype;

import org.junit.jupiter.api.Assertions;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        // first call should take long
        System.out.println("first time fetching from db --> slow");
        Set<Company> companiesOne =  CompanyRegister.getInstance().getCompanies();
        // second call should be fast because cached.
        System.out.println("second time reading from cache --> fast");
        Set<Company> companiesTwo = CompanyRegister.getInstance().getCompanies();

        Assertions.assertTrue(companiesOne != companiesTwo); // not the same reference

        Iterator<Company> c1 = companiesOne.iterator();
        Iterator<Company> c2 = companiesTwo.iterator();

        while (c1.hasNext()) {
            Company companyOne = c1.next();
            Company sameCompany = c2.next();
            Assertions.assertFalse(companyOne == sameCompany);
        }
        Assertions.assertFalse(c2.hasNext());

        System.out.println("Yeah! No exception --> cloning was successful.");
    }
}
