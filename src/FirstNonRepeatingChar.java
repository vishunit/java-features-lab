import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {

    public static Character firstNonRepeatingChar(String str) {
        // LinkedHashMap keeps insertion order
        Map<Character, Integer> charCount = new LinkedHashMap<>();

        // Count frequency of each character
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Find the first char with count 1
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return null; // or throw Exception if you prefer
    }

    public static void main(String[] args) {
        String input = "swiss";
        Character result = firstNonRepeatingChar(input);
        if (result != null) {
            System.out.println("First non-repeating character is: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }
}
