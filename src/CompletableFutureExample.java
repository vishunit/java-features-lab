import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFutureExample demo = new CompletableFutureExample();
        demo.runExample();
    }

    public void runExample() throws ExecutionException, InterruptedException {
        // 1. Asynchronously fetch user name
        CompletableFuture<String> userFuture = CompletableFuture.supplyAsync(() -> fetchUserName());

        // 2. Asynchronously fetch user email
        CompletableFuture<String> emailFuture = CompletableFuture.supplyAsync(() -> fetchUserEmail());

        // 3. Combine both results
        CompletableFuture<String> combinedFuture = userFuture.thenCombine(emailFuture, (name, email) -> {
            return "User Info: " + name + " <" + email + ">";
        });

        // 4. Print result
        System.out.println(combinedFuture.get());  // blocking call for demo
    }

    private String fetchUserName() {
        sleep(1);
        return "Vishal";
    }

    private String fetchUserEmail() {
        sleep(2);
        return "vishal@example.com";
    }

    private void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
