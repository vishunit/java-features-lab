import java.util.concurrent.atomic.AtomicInteger;
import java.io.*;

public class KeywordDemo implements Serializable {
    // volatile ensures visibility of changes across threads
    private volatile boolean running = true;

    // AtomicInteger provides atomic operations for thread-safety
    private AtomicInteger counter = new AtomicInteger(0);

    // transient fields are not serialized
    private transient String tempData = "This won't be serialized";

    public void demonstrateVolatile() {
        Thread thread = new Thread(() -> {
            while (running) {
                // Do some work
            }
            System.out.println("Thread stopped due to volatile flag change");
        });

        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // This change will be visible to the other thread immediately
        running = false;
    }

    public void demonstrateAtomicInteger() {
        // Thread-safe increment
        int newValue = counter.incrementAndGet();
        System.out.println("AtomicInteger value after increment: " + newValue);

        // Thread-safe compare-and-set
        boolean updated = counter.compareAndSet(newValue, 10);
        System.out.println("Update successful? " + updated + ", new value: " + counter.get());
    }

    public void demonstrateTransient() throws IOException, ClassNotFoundException {
        // Serialize the object
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(this);
        oos.close();

        // Deserialize the object
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        KeywordDemo deserialized = (KeywordDemo) ois.readObject();

        System.out.println("After deserialization - tempData: " + deserialized.tempData);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        KeywordDemo demo = new KeywordDemo();

        System.out.println("=== Demonstrating volatile ===");
        demo.demonstrateVolatile();

        System.out.println("\n=== Demonstrating AtomicInteger ===");
        demo.demonstrateAtomicInteger();

        System.out.println("\n=== Demonstrating transient ===");
        demo.demonstrateTransient();
    }
}