import java.util.*; // used for Math.Random()

public class Applicants implements Runnable{

    private ApplicationQueue mySharedQueue;

    public Applicants(ApplicationQueue mySharedQueue){
        this.mySharedQueue = mySharedQueue;
    }

    /**
     * This method will run for 60 seconds (60000ms), create new Application objects, and add them to the ApplicationQueue.
     * The application will be assigned a randomly generated credit score between 300 and 850, and a
     * randomly generated requested limit between 5000 and 50000. Once it is added to the ApplicationQueue, a message
     * will display confirming that it has been added. After adding to the ApplicationQueue, the program will
     * "flip a coin" and decide how long to call the Thread.sleep() before continuing.
     * Once the Thread has finished processing, a message will display to show that it has finished.
     */
    public void run(){
        // use a timer to run program for 60 seconds
        long start = System.currentTimeMillis();
        // Display that the current thread as started
        System.out.println(Thread.currentThread().getName() + ": started!");
        // run program for an amount of time
        while (System.currentTimeMillis() - start < 60000) {
            // create a new application and assign it a random credit score between 350 - 850, and a random credit limit between 5000 - 50000
            Application application = new Application(new Random().nextInt((850 - 300) + 300), new Random().nextInt(50000 - 5000) + 5000);
            // while the program is running, add the new applications into mySharedQueue
            mySharedQueue.addApplication(application);
            // display message in the console that includes the thread name and the ID of the application
            System.out.println(Thread.currentThread().getName() + ": created application #" + application.getNextId());

            // "flip a coin" on whether to delay the thread before creating a new application
            // if yes, sleep between 100 - 1200 ms
            if (Math.random() * 2 + 1 == 1) {
                try {
                    Thread.sleep(new Random().nextInt(1200 - 100) + 100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        // display message showing the Thread has finished
        System.out.println(Thread.currentThread().getName() + " finished");
    }
}
