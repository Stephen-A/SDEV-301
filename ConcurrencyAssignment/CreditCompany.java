public class CreditCompany implements Runnable {

    private ApplicationQueue mySharedQueue;

    public CreditCompany(ApplicationQueue mySharedQueue) {
        this.mySharedQueue = mySharedQueue;
    }

    /**
     * This method checks to see if the ApplicationQueue has any elements stored inside.
     * If there are any elements, the application will be removed from the queue and processed.
     * Applications that have a randomly generated credit score lower than 580 are automatically denied and
     * will display a message. A different message will be displayed with the use of the acceptedApplication()
     * method if an application has a randomly generated credit score between 580 and 800. This will display a
     * message and assigned the approved limit to the application depending on the generated credit score.
     */
    public void run() {

        Application application;
        while (mySharedQueue != null) {
            application = mySharedQueue.removeApplication();

            // if the generated application credit score is less than 580, decline the application
            if (application.getCreditScore() < 580) {
                System.out.println(Thread.currentThread().getName() + ": Application #" + application.getApplicationId() +
                        " with credit score " + application.getCreditScore() + " is not approved");
            }

            // if the generated application credit score is between 580 and 669
            if (application.getCreditScore() >= 580 && application.getCreditScore() <= 669) {
                application.setApprovedLimit(5000); // set the approved limit to 5000
                System.out.println(acceptedApplication(application));

            // if the generated application credit score is >= 670 and 739
            } else if (application.getCreditScore() >= 670 && application.getCreditScore() <= 739) {
                application.setApprovedLimit(10000); // set the approved limit to 10000
                System.out.println(acceptedApplication(application));

            // if the generated application credit score is between 740 and 799
            } else if (application.getCreditScore() >= 740 && application.getCreditScore() <= 799) {
                application.setApprovedLimit(25000); // set the approved limit to 25000
                System.out.println(acceptedApplication(application));

            // if the generated application credit score greater than or equal to 800
            } else if (application.getCreditScore() >= 800) {
                application.setApprovedLimit(50000); // set the approved limit to 50000
                System.out.println(acceptedApplication(application));
            }
        }
    }

    /**
     *
     * @param application application from the mySharedQueue ApplicationQueue
     * @return formatted string to display when credit score is between 580 and 800
     */
    public String acceptedApplication(Application application){
        return Thread.currentThread().getName() + ": Application #" + application.getApplicationId() +
                " with credit score " + application.getCreditScore() + " is approved for $" + application.getApprovedLimit() +
                " (requested: $" + application.getRequestedLimit() + ")";
    }
}
