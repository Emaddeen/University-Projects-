/**
 * This class uses threads to simulate the Alice & Bob
 * spending spree scenario: Alice and Bob compete to empty
 * a bank account they both have access to.
 */
public class AliceBob {
    /**
     * Main method just creates an object of this class
     * and calls the runSim() method.
     */
    public static void main(String[] args) {
        (new AliceBob()).runSim();
    }
    private int balance = 1000000;
    /**
     * Each thread calls this method, which continuously
     * deducts $100 from the account balance as long as
     * there is money in the account to spend.
     */
    public int spend(String name) {
        int totalSpent = 0;
        //critical section moved
        while(canSpend(name)){
            //critical section moved
            totalSpent += 100;
        }
        return totalSpent;
    }
    public synchronized boolean canSpend(String name){
        //critical section
        if(balance>=100){
            System.out.println(name + " Spends $100");
            balance-=100;
        //critical section
            return true;
        } else {
            return false;
        }
    }
    /**
     * Runs the simulation by creating two threads, one
     * for Alice and one for Bob, and waiting for those
     * threads to end. Once both threads end, the
     * method prints the final results.
     */
    public void runSim() {
        SpendThread alice = new SpendThread("Alice");
        SpendThread bob = new SpendThread("Bob");
        alice.start();
        bob.start();
        try {
            alice.join(); // Wait for Alice thread to end
            bob.join(); // Wait for Bob thread to end
            System.out.println("\nAlice spent $"+alice.total);
            System.out.println("Bob spent $"+bob.total);
            System.out.println("Remaining balance $"+balance);
        } catch (InterruptedException ex) {
            System.out.println("Bummer.");
        }
    }
    /**
     * This class defines a thread that will spend the
     * money in the account. The simulation creates two
     * instances of this class (two threads), one for Alice
     * and one for Bob.
     */
    public class SpendThread extends Thread {
        String name;
        int total;
        public SpendThread(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            total = spend(name);
        }
    }
}