import java.io.PrintStream;
import java.util.Scanner;

class PredatorPrey{
    public static void main (String[] args) {
            /*
            a=0.1 is for prey birth exceeds death.
            b=0.01 is for the rate of predation.
            c=0.01 is for the rate which predators death exceeds birth w/o food.
            d=0.00002 is for the predator increase in presence of food.
             */
        Scanner input = new Scanner(System.in);
        double a = 0.1;
        double b = 0.01;
        double c = 0.01;
        double d = 0.00002;

        System.out.println(" What is the population of prey");
        double PreyPopulation = input.nextInt();

        System.out.println(" What is the population of predators");
        double PredPopulation = input.nextDouble();

        System.out.println(" What is the number of periods");
        double NumberPer = input.nextDouble();


        for (int i = 1; i <= NumberPer; i++) {
            double newPreyPop = PreyPopulation * (1 + a - b * PredPopulation);
            PredPopulation = PredPopulation * (1 - c + d * PreyPopulation);
            PreyPopulation = newPreyPop;
            System.out.println(String.format("Period %2d:  Prey population:  %.0f Predator population:  %.0f", i,  PreyPopulation,  PredPopulation ));

        }
    }
}
