import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AirTrafficControlSimulation {
    static final int MIN_FLIGHT_SPACING = 10;
    int numberOfArrivals;
    int arrivalQueueEmpty = 0;
    int numberOfDivertedArrivals = 0;

    int departureQueueEmpty = 0;
    int numberOfDeniedDepartures = 0;
    int numberOfDepartures;

    int fltSpacingCounter;
    int flightNumberCounter;
    int timeInterval;
    int timerCounter = 0;

    Random r = new Random(System.nanoTime());


    enum FlightType {Arrival, Departure}

    ArrayDeque<Flight> arrivalQueue = new ArrayDeque<Flight>();
    ArrayList<Flight> arrivalStatistics = new ArrayList<>();
    ArrayDeque<Flight> departureQueue = new ArrayDeque<Flight>();
    ArrayList<Flight> departureStatistics = new ArrayList<>();


    class Flight {
        String flightNumber;
        FlightType flightType;
        int minuteInQueue;
        int minuteOutQueue;

        // constructor
        public Flight(String flightNumber, FlightType flightType) {
            this.flightNumber = flightNumber;
            this.flightType = flightType;
        }

        public String toString() {
            return flightType + ": " + flightNumber;
        }

        //  "minute" that flight entered the queue
        public void setMinuteInQueue(int minute) {
            this.minuteInQueue = minute;
        }

        // "minute" that flight exits the queue
        // difference is time in queue
        public void setMinuteOutQueue(int minute) {
            this.minuteOutQueue = minute;
        }

        public int timeInQueue() {
            return minuteOutQueue - minuteInQueue;
        }

    }

    public static void main(String[] args) {
        double meanArrivalFreq = 0.0;
        double meanDepartureFreq = 0.0;
        AirTrafficControlSimulation sim = new AirTrafficControlSimulation();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter mean departure frequency (0.0 > df < 1.0): ");
        if (scanner.hasNextDouble())
            meanDepartureFreq = scanner.nextDouble();
        System.out.println("Enter mean arrival frequency 0.0 > af < 1.0): ");
        if (scanner.hasNextDouble())
            meanArrivalFreq = scanner.nextDouble();
        // Check if total probability of arrivals + departures > 100%
        if (meanDepartureFreq + meanArrivalFreq > 1.0) {
            System.out.println("Mean departure frequency plus mean arrival frequency cannot exceed 100%. Try again...");
            return;
        }

        for (int i = 0; i < 720; i++) {
            sim.processArrival(meanArrivalFreq);
            sim.processDeparture(meanDepartureFreq);
            if (sim.arrivalQueue.size() == 0)
                sim.arrivalQueueEmpty++;
            if (sim.departureQueue.size() == 0)
                sim.departureQueueEmpty++;
        }
        sim.printSimSummaryStatistics();
    }


    void processArrival(double meanArrivalFreq) {
        int count = 0;
        timerCounter++;
        timeInterval++;
        if ((count = getPoissonRandom(meanArrivalFreq)) > 0)
            addToArrivalQueue(count);
        if (timerCounter >= 10) {
            if (arrivalQueue.size() > 0) {
                removeFromArrivalQueue();
                timerCounter = 0;
            }
        }
    }


    void processDeparture(double meanDepartureFreq) {
        int count = 0;
        fltSpacingCounter++;
        timeInterval++;
        if ((count = getPoissonRandom(meanDepartureFreq)) > 0)
            addToDepartureQueue(count);
        if (fltSpacingCounter >= MIN_FLIGHT_SPACING) {
            if (departureQueue.size() > 0 && arrivalQueue.size() == 0) {
                removeFromDepartureQueue();
                fltSpacingCounter = 0;
            }
        }
    }

    int getPoissonRandom(double mean) {
        double L = Math.exp(-mean);
        int x = 0;
        double p = 1.0;
        do {
            p = p * r.nextDouble();
            x++;
        } while (p > L);
        return x - 1;
    }

    public void addToArrivalQueue(int count) {
        for (int i = 0; i < count; i++) {
            Flight arrivalFlight = new Flight("AA" + flightNumberCounter++, FlightType.Arrival);
            if (arrivalQueue.size() < 5) {
                arrivalFlight.setMinuteInQueue(timeInterval);
                arrivalQueue.add(arrivalFlight);

            } else {
                this.numberOfDivertedArrivals++;
                System.out.println("Arrival queue full. Flight " + arrivalFlight + " rerouted at: " + timeInterval / 60 + ":" + String.format("%02d", timeInterval % 60) + " hours");
            }
        }
    }

    public void removeFromArrivalQueue() {
        if (arrivalQueue.size() > 0) {
            Flight arrivalFlight = arrivalQueue.removeFirst();
            arrivalFlight.setMinuteOutQueue(timeInterval);
            arrivalStatistics.add(arrivalFlight);
            System.out.println("Flight " + arrivalFlight + " arrived at: " + +timeInterval / 60 + ":" + String.format("%02d", timeInterval % 60) + " hours");
            numberOfArrivals++;

        }
    }

    void addToDepartureQueue(int count) {
        for (int i = 0; i < count; i++) {
            Flight departureFlight = new Flight("AA" + flightNumberCounter++, FlightType.Departure);
            if (departureQueue.size() < 5) {
                departureFlight.setMinuteInQueue(timeInterval);
                departureQueue.add(departureFlight);

            } else {
                this.numberOfDeniedDepartures++;
                System.out.println("Arrival queue full. Flight " + departureFlight + " rerouted at: " + timeInterval / 60 + ":" + String.format("%02d", timeInterval % 60) + " hours");
            }
        }
    }

    void removeFromDepartureQueue() {
        if (departureQueue.size() > 0) {
            Flight departureFlight = departureQueue.removeFirst();
            departureFlight.setMinuteOutQueue(timeInterval);
            departureStatistics.add(departureFlight);
            System.out.println("Flight " + departureFlight + " arrived at: " + +timeInterval / 60 + ":" + String.format("%02d", timeInterval % 60) + " hours");
            numberOfDepartures++;

        }

    }


    private void printSimSummaryStatistics() {
        int ttlDepartureTimeInQueue = 0;
        int ttlArrivalTimeInQueue = 0;
        double avgDepartureQueueTime = 0.0;
        double avgArrivalQueueTime = 0.0;
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("\n***********************************************************************");
        System.out.println("Overseer Screen:- Air Traffic Control Simulator { Summary Statistics}");
        System.out.println("***********************************************************************");
        System.out.println("time period simulated " + timeInterval / 60 + ":" + String.format("%02d", timeInterval % 60) + " hours");
        // I separated the arrival and departure statistics to simulate better efficiency for the readers of the schedule
        //Arrival Statistics
        System.out.println("Arrival Statistics: ");
        System.out.println("number of flight arrivals " + numberOfArrivals);
        System.out.println("average number of arrivals per hour " + String.format("%.2f", (double) (numberOfArrivals) / (timeInterval / 60.0)));
        System.out.println("Arrivals left in Queue " + arrivalQueue.size());
        for (Flight flt : arrivalStatistics) {
            ttlArrivalTimeInQueue = ttlArrivalTimeInQueue + flt.timeInQueue();
        }
        if (arrivalStatistics.size() > 0)
            avgArrivalQueueTime = ttlArrivalTimeInQueue / arrivalStatistics.size();
        System.out.println("average arrival time of flights in queue " + df.format(avgArrivalQueueTime) + "-minutes");
        //Departure Statistics
        System.out.println("diverted Arrivals " + this.numberOfDivertedArrivals);
        System.out.println("number of flight departures " + numberOfDepartures);
        System.out.println("average number of departures per hour " + String.format("%.2f", (double) (numberOfDepartures) / (timeInterval / 60.0)));
        System.out.println("Departure left in Queue " + departureQueue.size());
        System.out.println("denied Departures " + this.numberOfDeniedDepartures);
        for (Flight flt : departureStatistics) {
            ttlDepartureTimeInQueue = ttlDepartureTimeInQueue + flt.timeInQueue();
        }
        if (departureStatistics.size() > 0)
            avgDepartureQueueTime = ttlDepartureTimeInQueue / departureStatistics.size();
        System.out.println("average departure time of flights in queue " + df.format(avgDepartureQueueTime) + "-minutes");
        // Sum and Total Statistics
        int flightsSum = numberOfArrivals + numberOfDepartures;
        System.out.println("total number of flights at the airport " + flightsSum);
        //assuming all the denied and diverted flights count as late(I know it's possible for them to still arrive on time)
        int lateFlightsSum = numberOfDeniedDepartures + numberOfDivertedArrivals;
        System.out.println("number of late flights " + lateFlightsSum);
        int emptyQueueInstances = arrivalQueueEmpty + departureQueueEmpty;
        double pctIdle = (double) emptyQueueInstances / timeInterval * 100.0;
        System.out.println("percentage of idle time on the run way " + df.format(pctIdle) + "%");


    }

}

