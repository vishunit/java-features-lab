import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class User {
    private String name;
    private int id;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // No equals() or hashCode() defined!
    public String toString() {
        return name + ":" + id;
    }
 /*   @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }*/

}

public class EqualsHashCodeDemo {
    public static void main(String[] args) {
        User user1 = new User("Alice", 1);
        User user2 = new User("Alice", 1); // same content, different objects

        // Compare using .equals (default: reference equality)
        System.out.println("user1.equals(user2)? " + user1.equals(user2)); // false

        // Store in a HashSet
        Set<User> userSet = new HashSet<>();
        userSet.add(user1);
        userSet.add(user2); // Should not add, but it does!

        System.out.println("Set size: " + userSet.size());  // 2
        System.out.println("Set contents: " + userSet);
    }
}
