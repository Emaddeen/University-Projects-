import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

enum EngineType {Jet, Rocket, Electric, TurboProp, Piston}

public class FlightLists {
    ArrayList<Flight> fltArray = new ArrayList<>();
    ArrayList<AircraftType> airType = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm");

    public static void main(String[] args) throws java.text.ParseException {
        FlightLists flts = new FlightLists();
        flts.addAircraftTypes();
        flts.addFlights();
        flts.printFlights();
    }

    public void addAircraftTypes() {
        airType.add(new AircraftType("Boeing", "737-800", "B738", EngineType.Jet, 2));
        airType.add(new AircraftType("Embraer", "A-20", "E314", EngineType.TurboProp, 1));
        airType.add(new AircraftType("Airbus", "A-340-500", "A-340-500", EngineType.Electric, 3));
        airType.add(new AircraftType("Comic", "C77R", "CN1", EngineType.Jet, 1));
        airType.add(new AircraftType("Dornier GmbH", "D228", "D28", EngineType.Piston,2 ));

    }

    public void addFlights() throws java.text.ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm");
        fltArray.add(new Flight("205", "AA", "PHL", "SVO", sdf.parse("1-28-2022 06:00"), sdf.parse("1-28-2021 18:30"), airType.get(0), "B20"));
        fltArray.add(new Flight("317","Cheap O Air","OSL","NCE",sdf.parse("3-14-2022 05:30"),sdf.parse("3-15-2022 13:00"),airType.get(1),"C31"));
        fltArray.add(new Flight("972","United","PMI","OPO",sdf.parse("5-3-2022 18:00"),sdf.parse("5-3-2022 23:00"),airType.get(2),"B12"));
        fltArray.add(new Flight("726","United","CDG","KEF",sdf.parse("7-21-2022 01:00"),sdf.parse("7-21-2022 04:30"),airType.get(3),"E21"));
        fltArray.add(new Flight("122","AA","FUE","FCO",sdf.parse("12-31-2022 03:00"),sdf.parse("12-31-2022 07:15"),airType.get(4),"K10"));

    }

    public void printFlights() {
        for (Flight flt : fltArray) {
            System.out.println(flt);
        }
    }

    class AircraftType {

        String manufacturer;
        String model;
        String typeDesignator;
        EngineType engineType;
        int numberEngines;

        public AircraftType(String manufacturer, String model, String typeDesignator, EngineType engineType, int numberEngines) {
            this.manufacturer = manufacturer;
            this.model = model;
            this.typeDesignator = typeDesignator;
            this.engineType = engineType;
            this.numberEngines = numberEngines;
        }

        public String toString() {
            return "A/C " + manufacturer +
                    " " + model +
                    " " + engineType +
                    " " + numberEngines;
        }
    }

    class Flight {
        private String flightNumber;
        private String airline;
        private String origin;
        private AircraftType aircraftType;
        private String destination;
        private Date scheduledDeparture;
        private Date scheduledArrival;
        private String gate;

        public Flight(String flightNumber, String airline, String origin, String destination, Date scheduledDeparture, Date scheduledArrival, AircraftType aircraftType, String gate) {
            this.flightNumber = flightNumber;
            this.airline = airline;
            this.origin = origin;
            this.aircraftType = aircraftType;
            this.destination = destination;
            this.scheduledDeparture = scheduledDeparture;
            this.scheduledArrival = scheduledArrival;
            this.gate = gate;
        }

        public String toString() {
            return airline + " " + flightNumber + " " + origin + "/" + destination + " Departs: " + sdf.format(scheduledDeparture) +
                    " Arrives: " + sdf.format(scheduledArrival) + " " + aircraftType.toString() + " Gate: " + gate;
        }
    }

}