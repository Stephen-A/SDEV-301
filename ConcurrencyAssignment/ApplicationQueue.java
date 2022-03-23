import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ApplicationQueue {

    private BlockingQueue<Application> apps = new LinkedBlockingQueue<>();

    /**
     * This method is used to put a new application into the Queue
     * @param app Application object created
     */
    public void addApplication(Application app){
        try {
            apps.put(app);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * This method is used to remove an application from the Queue to be processed
     * @return the application taken from the Queue
     */
    public Application removeApplication(){
        Application removed = null;
        try {
            removed = apps.take();
        } catch (InterruptedException e ){
            e.printStackTrace();
        }
        return removed;
    }
}
