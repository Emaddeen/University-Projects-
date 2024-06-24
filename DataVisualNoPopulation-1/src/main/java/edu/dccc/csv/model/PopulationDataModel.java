package edu.dccc.csv.model;

public class PopulationDataModel {
    String year;
    String population;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPopulations() {
        return population;
    }

    public void setPopulations(String population) {
        this.population = population.replace(" ","").trim();
    }

    @Override
    public String toString() {
        return
                "year='" + year +
                     " populations= " + population;
    }
}
