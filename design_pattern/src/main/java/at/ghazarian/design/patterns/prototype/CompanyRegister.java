package at.ghazarian.design.patterns.prototype;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CompanyRegister {

    public static final Comparator<Company> COMPANY_COMPARATOR = (c1, c2) -> c1.getCompanyName().compareTo(c2.getCompanyName());
    private static volatile CompanyRegister companyRegister;
    private TreeSet<Company> companies;

    public static CompanyRegister getInstance() {
        if (companyRegister == null) {
            synchronized (CompanyRegister.class) {
                if (companyRegister == null) {
                    // simulating two second load from db.
                    try {
                        Thread.sleep(2000);
                        var companies = new TreeSet<Company>(COMPANY_COMPARATOR);
                        companies.add(new Company(1L, "Amazon", LocalDate.now().minusYears(10), null));
                        companies.add(new Company(2L, "Google", LocalDate.now().minusYears(12), null));
                        companies.add(new Company(3L, "Uber", LocalDate.now().minusYears(5), null));
                        companies.add(new Company(4L, "Ebay", LocalDate.now().minusYears(15), LocalDate.now()));
                        companyRegister = new CompanyRegister();
                        companyRegister.setCompanies(companies);
                    } catch (InterruptedException e) {
                        //
                    }
                }
            }
        }
        return companyRegister;
    }

    private CompanyRegister() {

    }

    private void setCompanies(TreeSet<Company> companies) {
        this.companies = companies;
    }

    public Set<Company> getCompanies() {
        return this.companies.stream()
                .map(c -> (Company) c.clone())
                .collect(
                        Collectors.toCollection(() -> new TreeSet<>(COMPANY_COMPARATOR)));
    }
}
