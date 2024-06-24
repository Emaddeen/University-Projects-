/**
 * Implements the scheduling algorithm used by the simulation.
 * Currently implements Round Robin (with preemption on) and FCFS (with preemption off).
 * 
 * @author Adam Fischbach - Widener University
 * @version Fall 2015
 */

import java.util.Queue;
import java.util.LinkedList;

public class Scheduler {

    private Queue<SimThread>[] readyQueues;   // Queue of runnable threads
    private OS os;                       // Reference to the "OS"
    
    /**
     * Constructor.
     * @param os A reference to the simulation's OS object.
     */
    public Scheduler(OS os)
    {
        this.os = os;
        readyQueues = new LinkedList[5];

            for(int i =0; i<5;i++){
                readyQueues[i] = new LinkedList<>();
            }
        os.setPreempt(true);// Turn preemption on for Round Robin.
    }
    
    /**
     * The simulation calls this method when a SimThread enters the Queued state.
     * @param st The SimThread to place into Ready queue(s).
     * @param code Identifies why the thread is entering the queue:
     *                  0 - a new thread
     *                  1 - thread returning from Blocked state
     *                  2 - thread has exceeded its time quantum
     *                  3 - thread has been preempted for a higher priority thread
     */
    public void enqueue(SimThread st, int code)
    {
        //1 finding the st priority
        //2 put st in the corsiponding priority level
        // use an if statment to check the if the proority matches the Q its being put in
        // if not go to the next Q

        // updating the priority level use code
        if(code == 2){
            if(st.getPriority()>0){
                st.setPriority(st.getPriority() - 1);
            }
        } else if(code == 1){
            if(st.getPriority()<4){
            st.setPriority(st.getPriority() + 1);
        }
        }else if(code == 3){
            os.preemptRunningThread(st);
        }

        readyQueues[st.getPriority()].add(st);

    	if(os.getRunning() == null)
    		scheduleThread();
    }

    /**
     * The simulation calls this method when it's time to schedule a thread.
     * Use the os.setRunning() method to tell the simulation which thread to schedule. 
     */
    public void scheduleThread() {
        for (int i = 0; i < 5; i++) {
            if(!readyQueues[i].isEmpty()){
                SimThread threadToSchedule = readyQueues[i].remove();
                os.setRunning(threadToSchedule);
                break;
            }

        }

    }
}