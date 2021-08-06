package Utility;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public final class ConsoleLogger {
    public static void log(Object sender){
        System.out.printf("[%s] - %s: %s%n",
                sender.getClass().getName(),
                LocalTime.now().truncatedTo(ChronoUnit.SECONDS),
                sender);
    }
}
