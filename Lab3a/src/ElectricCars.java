import java.util.ArrayList;

public class ElectricCars {
    ArrayList<ElectricCar> carList = new ArrayList<>();

    class ElectricCar {
        String modelName;
        double mfgPrice;
        int maxRange;
        double usNewsRating; // 1.0-10.0
        int rank;

        public ElectricCar(String modelName, double mfgPrice, int maxRange, double usNewsRating, int rank) {
            this.modelName = modelName;
            this.mfgPrice = mfgPrice;
            this.maxRange = maxRange;
            this.usNewsRating = usNewsRating;
            this.rank = rank;
        }

        @Override
        public String toString() {
            return "ElectricCar{ " +
                    "modelName = '" + modelName + '\'' +
                    ", mfgPrice = " + mfgPrice +
                    ", maxRange = " + maxRange +
                    ", usNewsRating = " + usNewsRating +
                    ", rank = " + rank +
                    '}';
        }
    }

    public void addCars() {
        carList.add(new ElectricCar("2021 Mini Electric Hardtop (Cooper SE)", 29900.00, 8, 110, 7));
        carList.add(new ElectricCar("2021 BMW i3", 44450, 7, 153, 5));
        carList.add(new ElectricCar("2023 MINI Electric Hardtop", 27400, 7, 226, 3));
        carList.add(new ElectricCar("2021 Chevrolet Bolt EV", 36500, 8, 259, 8));
        carList.add(new ElectricCar("2022 Audi e-tron GT", 99900, 8, 238, 6));
        carList.add(new ElectricCar("2022 Lucid Air", 16900, 121, 9.1, 2));
        carList.add(new ElectricCar("2022 Mercedes-Benz EQS Sedan", 147500, 97, 9.2, 1));
        carList.add(new ElectricCar("2021 Tesla Model 3", 44990, 8, 353, 4));
        carList.add(new ElectricCar("2021 Tesla Model S", 94990, 8, 412, 9));


    }

    public void printCars() {
        for (ElectricCar car : carList) {
            System.out.println(car);

        }
    }

    public static void main(String[] args) {
        ElectricCars cl = new ElectricCars();
        cl.addCars();
        cl.printCars();
    }


}
