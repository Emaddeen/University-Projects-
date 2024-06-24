import java.util.ArrayList;

public class ElectricCarsList {
    ArrayList<ElectricCar> carlist = new ArrayList<>();

    public static void main(String[] args) {
        ElectricCarsList electricCarsList = new ElectricCarsList();
        electricCarsList.addCars();
        electricCarsList.printcars();
    }

    class ElectricCar {
        String modelName;
        double mfgPrice;
        int maxrange;
        double useNewsRating;
        int rank;

        //used right click and then generate constructer
        public ElectricCar(String modelName, double mfgPrice, double useNewsRating, int maxrange, int rank) {
            this.modelName = modelName;
            this.mfgPrice = mfgPrice;
            this.maxrange = maxrange;
            this.useNewsRating = useNewsRating;
            this.rank = rank;
        }

        public String toString() {
            return
                    modelName + " ,$" +
                            mfgPrice + ", " +
                            maxrange + ", " +
                            useNewsRating + ", " +
                            rank;
        }
    }

    public void addCars() {
        carlist.add(new ElectricCar("2023 Polestar 2", 61600, 8.3, 100, 7));
        carlist.add(new ElectricCar("2023 Lucid Air", 179000, 8.6, 140, 5));
        carlist.add(new ElectricCar("2023 BMW i7", 119300, 8.9, 85, 3));
        carlist.add(new ElectricCar("2023 Porsche Taycan", 190000, 8.2, 88, 8));
        carlist.add(new ElectricCar("2022 Audi e-tron GT", 142400, 8.5, 83, 6));
        carlist.add(new ElectricCar("2022 Lucid Air", 169000, 9.1, 122, 2));
        carlist.add(new ElectricCar("2022 Mercedes-Benz EQS Sedan", 147500, 9.2, 99, 1));
        carlist.add(new ElectricCar("2022 BMW i4", 65900, 8.6, 108, 4));
        carlist.add(new ElectricCar("2023 Toyota bZ4X", 48780, 6.9, 48780, 9));
        carlist.add(new ElectricCar("2023 Tesla Model X", 138990, 7.6, 97, 10));


    }

    public void printcars() {
        for (ElectricCar car : carlist) {
            System.out.println(car);
        }
    }


}


