package provider;

import lombok.NoArgsConstructor;
import model.Country;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class CountryProviderImpl implements CountryProvider {

    private String filePath = "src/main/java/resources/countries.txt";

    public CountryProviderImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Country> getAllCountries() {
        List<Country> countriesList = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] lineResult = line.split(";");
                countriesList.add(
                        new Country(
                                lineResult[0], //Country Name
                                lineResult[1], //Country Alias
                                lineResult[2]  //Country Currency
                        )
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countriesList;
    }
}
