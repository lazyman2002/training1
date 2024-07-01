import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static List<Country> countries = new ArrayList<Country>();
    private static List<City> cities = new ArrayList<City>();
    public static void readCountry() throws IOException {
        FileReader fr = new FileReader("./input_8/countries.dat");
        BufferedReader br = new BufferedReader(fr);
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            countries.add(new Country(line));
        }
        br.close();
        fr.close();
    }
    public static void readCity() throws IOException {
        FileReader fr = new FileReader("./input_8/cities.dat");
        BufferedReader br = new BufferedReader(fr);
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            cities.add(new City(line));
        }
        br.close();
        fr.close();
    }
    public static void main(String[] args) throws IOException {
        readCountry();
        readCity();
        for(City city : cities) {
            for (Country country : countries) {
                if(country.getCode().compareTo(city.getCountryCode()) == 0){
                    country.addCity(city);
                }
                if(country.getCapital() == city.getId()){
                    country.setCapitalCity(city);
                }
            }
        }

//        countries.stream().forEach((country) -> {
//            country.getCities().stream()
//                    .max(Comparator.comparingInt(City::getPopulation))
//                    .ifPresent((city) -> {
//                        System.out.println(country.getName() + ": " + city.getName() + ": " + city.getPopulation());
//                    });
//        });

//        countries.stream()
//                .flatMap(country -> country.getCities().stream().map(city -> new AbstractMap.SimpleEntry<>(country.getContinent(), city)))
//                .collect(Collectors.groupingBy(Map.Entry::getKey,
//                        Collectors.maxBy(Comparator.comparingInt(entry -> entry.getValue().getPopulation()))))
//                .forEach((continent, entry) -> entry.ifPresent(e -> System.out.println(continent + ": " + e.getValue().getName() + ": " + e.getValue().getPopulation())));

//        Optional<City> c =  countries.stream()
//                .map(Country::getCapitalCity)
//                .filter(Objects::nonNull)
//                .max(Comparator.comparing(City::getPopulation));
//        System.out.println(c);

//        countries.stream()
//                .filter(country -> country.getCapitalCity()!=null)
//                .map(country -> new AbstractMap.SimpleEntry<>(country.getContinent(), country.getCapitalCity()))
//                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.maxBy(
//                        Comparator.comparingInt(entry -> entry.getValue().getPopulation())
//                                )
//                        )
//                )
//                .forEach((continent, city) -> {
//                    city.ifPresent(e ->System.out.println(continent + ": "+ e.getValue().getName() + ": "+ e.getValue().getPopulation()));
//                });

//        countries.stream()
//                .sorted(Comparator.comparing((Country c) -> c.getCities().size()).reversed())
//                .forEach(c -> System.out.println(c + ": " + c.getCities().size()));

        countries.stream()
                .filter(country -> country.getPopulation() > 0)
                .map(country -> new AbstractMap.SimpleEntry<>(country.getPopulation()/country.getSurfaceArea(), country.getName()) {} )
                .sorted(Map.Entry.<Double, String>comparingByKey().reversed())
                .forEach(entry-> System.out.println(entry.getValue() + " " + entry.getKey() ));
    }
}