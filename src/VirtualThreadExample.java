public class VirtualThreadExample {

    public static void main(String[] args) throws InterruptedException {
        // Define a simple task that simulates a blocking operation
        Runnable task = () -> {
            String threadName = Thread.currentThread().toString();
            System.out.println("Started: " + threadName);
            try {
                // Simulate a blocking task (e.g., network or database call)
                Thread.sleep(1000); // This won't block the underlying OS thread in virtual threads
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finished: " + threadName);
        };

        System.out.println("Launching virtual threads...");

        // Start 10 virtual threads
        for (int i = 0; i < 10; i++) {
            //new Thread(task).start(); // Traditional thread
            Thread.startVirtualThread(task); // Creates and starts a new virtual thread
        }

        // Give enough time for all threads to complete
        Thread.sleep(2000); // Sleep main thread to allow virtual threads to finish
        System.out.println("All virtual threads launched!");
    }
}
