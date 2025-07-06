import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {

    public static void main(String[] args) {
        // Create a thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit 5 tasks to the executor
        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println("Starting Task " + taskId + " on thread " + Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(2); // simulate time-consuming task
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Finished Task " + taskId);
            });
        }

        // Shutdown the executor after task submission
        executor.shutdown();

        try {
            // Wait for all tasks to finish (max wait: 10 seconds)
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("All tasks completed");
    }
}
