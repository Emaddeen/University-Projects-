import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Demo {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        int n = 5;
        Looper[] y = new Looper[n];
        Thread[] x = new Thread[n];
        for (int i = 0; i < n; i++) {
            Looper axe = new Looper();
            Thread object = new Thread(axe);
            
            x[i] = object;
            y[i] = axe;
            
            Callable<String> task = () -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                    return object.getName();
                } catch (InterruptedException e) {
                    throw new IllegalStateException("Bad 74.", e);    
                }
            };
            
            ExecutorService executor = Executors.newFixedThreadPool(1);
            Future<String> future = executor.submit(task);
         
            System.out.println("Future check : " + future.isDone());
            try {
                String doneornot = future.get();
            System.out.println("Future check : " + future.isDone());
            System.out.print("result  : " + doneornot + "\n\n");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        
        for (Thread i : x) { 
                 i.start();
        }

        boolean work = true;
        
        while (work == true) {
            if (y[0].getCounter() == y[1].getCounter() && y[0].getCounter() != 1 && y[0].getCounter() != 3 && y[2].getCounter() == y[0].getCounter() && y[0].getCounter() == y[3].getCounter() && y[0].getCounter() == y[4].getCounter()) {
                work = false;
                for (Looper i : y) {
                	i.setAlive(false);
                }
                for (Thread i : x) {
                    i.stop();
                    System.out.println(i.getName() + " Dead.");
                }
            } else {
                System.out.println("Counter 1: " + y[0].getCounter());
                System.out.println("Counter 2: " + y[1].getCounter());
                System.out.println("Counter 3: " + y[2].getCounter());
                System.out.println("Counter 4: " + y[3].getCounter());
                System.out.println("Counter 5: " + y[4].getCounter());
                
            }
            try {
				TimeUnit.MILLISECONDS.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } 
        System.out.println("Counter 1: " + y[0].getCounter());
        System.out.println("Counter 2: " + y[1].getCounter());
        System.out.println("Counter 3: " + y[2].getCounter());
        System.out.println("Counter 4: " + y[3].getCounter());
        System.out.println("Counter 5: " + y[4].getCounter());
        return;
    }
}