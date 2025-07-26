import java.util.function.*;

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {

        // Predicate<T>: Checks if a number is even
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4)); // true
        System.out.println("Is 5 even? " + isEven.test(5)); // false

        // Function<T, R>: Converts Integer to String describing even/odd
        Function<Integer, String> evenOrOdd = n -> (n % 2 == 0) ? "Even" : "Odd";
        System.out.println("7 is " + evenOrOdd.apply(7)); // Odd

        // Consumer<T>: Prints a number with a message
        Consumer<String> greeter = name -> System.out.println("Hello, " + name + "!");
        greeter.accept("World"); // Hello, World!

        // Supplier<T>: Supplies a random number
        Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println("Random number: " + randomSupplier.get());
    }
}
