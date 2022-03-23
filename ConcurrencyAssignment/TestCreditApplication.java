/**
 * Stephen Allen
 * 03/23/2022
 * SDEV 301
 *
 * This creates new Threads and assigns them to be either a producer(Applicant) or consumer(CreditCompany).
 * The producer Threads are in charge of creating new applications and adding them to the Queue.
 * The consumer Threads are in charge of taking the applications from the Queue and processing the information.
 */

public class TestCreditApplication {

    public static void main(String[] args) {

        ApplicationQueue applicationQueue = new ApplicationQueue();

        // create 3 producer threads and 2 consumer threads
        Thread[] producers = new Thread[3];
        Thread[] consumers = new Thread[2];

        for (int i = 0; i < producers.length; i++) {
            producers[i] = new Thread(new Applicants(applicationQueue), "P"+(i+1));
            producers[i].start();
        }

        for (int i = 0; i < consumers.length; i++) {
            consumers[i] = new Thread(new CreditCompany(applicationQueue),"C"+(i+1));
            consumers[i].start();
        }
    }
}
