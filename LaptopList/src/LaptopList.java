import java.util.ArrayList;

public class LaptopList {
    ArrayList<LaptopList> laptopLists = new ArrayList<>();
    public void main(String[] args) {
        Laptoplist LTlist = new Laptoplist();

    }
    public void addLaptops()
    {
        ArrayList<LaptopList> laptopLists = new ArrayList<>();
        laptopLists.add(new LaptopList());

    class Laptoplist {
        String modelName;
        double Price;
        int storage;
        double Rating; // 1.0-10.0
        int rank;

        public Laptoplist(String modelName, double price, int storage, double rating, int rank) {
            this.modelName = modelName;
            Price = price;
            this.storage = storage;
            Rating = rating;
            this.rank = rank;
        }

        @Override
        public String toString() {
            return
                    modelName + "," +
                    String.format("$%.2f", Price) + "," +
                    storage + "," +
                    Rating + "," +
                    rank;

        }
    }

}}
