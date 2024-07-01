import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class City {
    private int id;
    private String name;
    private int population;
    private String CountryCode;
    public City(int id, String name, int population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }

    public City(String line) {
        String regexId = "id=[0-9]+,";
        String regexName = " name=.+,";
        String regexPopulation = " population=[0-9]+,";
        String regexCountryCode = " countryCode=[A-Z]{3}";
        String delimiter = "[=,]";
        Pattern patternId = Pattern.compile(regexId);
        Pattern patternName = Pattern.compile(regexName);
        Pattern patternPopulation = Pattern.compile(regexPopulation);
        Pattern patternCountryCode = Pattern.compile(regexCountryCode);
        Matcher matcherId = patternId.matcher(line);
        Matcher matcherName = patternName.matcher(line);
        Matcher matcherPopulation = patternPopulation.matcher(line);
        Matcher matcherCountryCode = patternCountryCode.matcher(line);
        if (matcherId.find() &&
            matcherName.find() &&
            matcherPopulation.find() &&
            matcherCountryCode.find()) {
            String id = matcherId.group().split(delimiter)[1];
            String name = matcherName.group().split(delimiter)[1];
            String population = matcherPopulation.group().split(delimiter)[1];
            String countryCode = matcherCountryCode.group().split(delimiter)[1];
            this.id = Integer.parseInt(id);
            this.name = name.trim();
            this.population = Integer.parseInt(population.trim());
            this.CountryCode = countryCode.trim();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City city)) return false;
        return id == city.id &&  Objects.equals(name, city.name) && Objects.equals(CountryCode, city.CountryCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, CountryCode);
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", CountryCode='" + CountryCode + '\'' +
                '}';
    }
}
