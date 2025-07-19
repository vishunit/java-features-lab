import java.util.Optional;
import java.util.List;

public class OptionalDemo {

    // Simple User class
    static class User {
        private String name;
        private String email;

        User(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }
    }

    // Simulated user database
    private static List<User> users = List.of(
            new User("Alice", "alice@example.com"),
            new User("Bob", "bob@example.com")
    );

    // Method that returns Optional<User>
    public static Optional<User> findUserByEmail(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst(); // returns Optional<User>
    }

    // Main method to test the logic
    public static void main(String[] args) {
        String emailToSearch = "bob@example.com";
        Optional<User> userOpt = findUserByEmail(emailToSearch);

        // 1. Using ifPresent()
        userOpt.ifPresent(user ->
                System.out.println("User found: " + user.getName())
        );

        // 2. Using orElse()
        User user = userOpt.orElse(new User("Guest", "guest@example.com"));
        System.out.println("Final user: " + user.getName());

        // 3. Using orElseThrow()
        try {
            User foundUser = findUserByEmail("notfound@example.com")
                    .orElseThrow(() -> new RuntimeException("User not found"));
            System.out.println("Found: " + foundUser.getName());
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Will print "User not found"
        }
    }
}
