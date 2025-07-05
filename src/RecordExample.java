// Compile with Java 16 or above

public class RecordExample {

    // Define a record to hold immutable Person data
    public record Person(String name, int age) {}

    public static void main(String[] args) {
        // Create a person record
        Person person = new Person("Alice", 30);

        // Access fields using auto-generated methods
        System.out.println("Name: " + person.name());
        System.out.println("Age: " + person.age());

        // toString, equals, and hashCode are auto-implemented
        Person another = new Person("Alice", 30);

        System.out.println("Are they equal? " + person.equals(another)); // true
        System.out.println("Person details: " + person); // Person[name=Alice, age=30]
    }
}
