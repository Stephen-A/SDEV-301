import java.util.concurrent.atomic.AtomicInteger;

public class Application {

    private static AtomicInteger nextId = new AtomicInteger(10000);
    private int applicationId;
    private int creditScore;
    private int requestedLimit;
    private int approvedLimit;
    private boolean approved;


    public Application(int creditScore, int requestedLimit) {
        this.applicationId = getApplicationId();
        this.creditScore = creditScore;
        this.requestedLimit = requestedLimit;
    }

    // used to increment nextId
    public void increment(){
        nextId.incrementAndGet();
    }

    // getters
    public int getNextId(){
        applicationId = nextId.get();
        increment();
        return applicationId;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public int getRequestedLimit() {
        return requestedLimit;
    }

    public boolean isApproved() {
        return approved;
    }

    public int getApprovedLimit() {
        return approvedLimit;
    }

    // setters
    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public void setRequestedLimit(int requestedLimit) {
        this.requestedLimit = requestedLimit;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public void setApprovedLimit(int approvedLimit) {
        this.approvedLimit = approvedLimit;
    }
}
