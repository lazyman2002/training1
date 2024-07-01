import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Country {
    private String code;
    private String name;
    private String continent;
    private double surfaceArea;
    private int population;
    private double gnp;
    private int capital;
    private List<City> cities = new ArrayList<>();
    private City capitalCity = null;

    public Country(String code, String name, String continent, double surfaceArea, int population, double gnp, int capital) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.surfaceArea = surfaceArea;
        this.population = population;
        this.gnp = gnp;
        this.capital = capital;
    }

    public Country(String line) {
        String regexCode = "code=[A-Z]{3},";
        String regexName = " name=.+,";
        String regexContinent = " continent=.+,";
        String regexSurfaceArea = " surfaceArea=[0-9]+\\.[0-9]*(E[+-]?[0-9]+)?,"; //????
        String regexPopulation = " population=[0-9]+,";
        String regexGnp = " gnp=[0-9]+\\.[0-9]+,";
        String regexCapital = " capital=-?[0-9]+";
        String delimiter = "[=,]";
        Pattern patternCode = Pattern.compile(regexCode);
        Pattern patternName = Pattern.compile(regexName);
        Pattern patternContinent = Pattern.compile(regexContinent);
        Pattern patternSurfaceArea = Pattern.compile(regexSurfaceArea);
        Pattern patternPopulation = Pattern.compile(regexPopulation);
        Pattern patternGnp = Pattern.compile(regexGnp);
        Pattern patternCapital = Pattern.compile(regexCapital);
        Matcher matcherCode = patternCode.matcher(line);
        Matcher matcherName = patternName.matcher(line);
        Matcher matcherContinent = patternContinent.matcher(line);
        Matcher matcherSurfaceArea = patternSurfaceArea.matcher(line);
        Matcher matcherPopulation = patternPopulation.matcher(line);
        Matcher matcherGnp = patternGnp.matcher(line);
        Matcher matcherCapital = patternCapital.matcher(line);
        if (matcherCode.find() &&
                matcherName.find() &&
                matcherContinent.find() &&
                matcherSurfaceArea.find() &&
                matcherPopulation.find() &&
                matcherGnp.find() &&
                matcherCapital.find()) {
            String[] code = matcherCode.group().split(delimiter);
            String[] name = matcherName.group().split(delimiter);
            String[] continent = matcherContinent.group().split(delimiter);
            String[] surfaceArea = matcherSurfaceArea.group().split(delimiter);
            String[] population = matcherPopulation.group().split(delimiter);
            String[] gnp = matcherGnp.group().split(delimiter);
            String[] capital = matcherCapital.group().split(delimiter);
            this.code = code[1];
            this.name = name[1];
            this.continent = continent[1];
            this.surfaceArea = Double.parseDouble(surfaceArea[1]);
            this.population = Integer.parseInt(population[1]);
            this.gnp = Double.parseDouble(gnp[1]);
            this.capital = Integer.parseInt(capital[1]);
        }   else return;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getGnp() {
        return gnp;
    }

    public void setGnp(double gnp) {
        this.gnp = gnp;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public List<City> getCities() {
        return cities;
    }

    public void addCity(City city) {
        this.cities.add(city);
    }

    public void removeCity(City city) {
        this.cities.remove(city);
    }

    public City getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(City capitalCity) {
        this.capitalCity = capitalCity;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", surfaceArea=" + surfaceArea +
                ", population=" + population +
                ", gnp=" + gnp +
                ", capital=" + capital +
                '}';
    }
}
