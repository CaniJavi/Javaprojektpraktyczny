import provider.CountryProviderImpl;
import provider.CountryProvider;

public class Main {
    public static void main(String[] args) {
        CountryProviderImpl countryProvider = new CountryProviderImpl();
        countryProvider.getAllCountries().forEach(System.out::println);
    }
}
