import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class PeriodOfDayDemo {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("B", Locale.ENGLISH);

        LocalTime[] testTimes = {
                LocalTime.of(2, 0),
                LocalTime.of(8, 0),
                LocalTime.of(13, 0),
                LocalTime.of(18, 0),
                LocalTime.of(22, 0)
        };

        for (LocalTime time : testTimes) {
            String period = formatter.format(time);
            System.out.println(time + " -> " + period);
        }

        System.out.println("\nCurrent time: " + LocalTime.now());
        System.out.println("Period of day: " + formatter.format(LocalTime.now()));
    }
}
