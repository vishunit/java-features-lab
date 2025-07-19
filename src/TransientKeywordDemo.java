import java.io.*;

// A simple class with transient field
class User1 implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private transient String password;  // This will not be serialized

    public User1(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String toString() {
        return "Username: " + username + ", Password: " + password;
    }
}

public class TransientKeywordDemo {
    public static void main(String[] args) {
        User1 originalUser = new User1("alice", "secret123");

        // Serialize the user object
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.ser"))) {
            oos.writeObject(originalUser);
            System.out.println("Serialized: " + originalUser);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("----------------------------------");

        // Deserialize the user object
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.ser"))) {
            User1 deserializedUser = (User1) ois.readObject();
            System.out.println("Deserialized: " + deserializedUser);  // Password will be null
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
