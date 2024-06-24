/*
 * This class contains static methods that run the simulation by
 * creating a set of threads.
 */
public class Test {

	public static void main(String[] args) {
		testAlgorithm1();
	}
    
	public static void testAlgorithm1()
    {
        OS os = new OS();
        for(int i=0; i<5; i++) {
            os.createSimThread(5, 30, 0, 50);
        }
        for(int i=0; i<5; i++) {
        	os.createSimThread(25, 30, 1, 50);
        }
    }
	
    public static void testAlgorithm2() {
        OS os = new OS();
        for(int i=0; i<4; i++) {
                os.createSimThread(30, 50, 0, 10);
        }
        for(int i=0; i<6; i++) {
                os.createSimThread(4);
        }
    }
    
}