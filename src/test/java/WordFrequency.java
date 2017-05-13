import java.util.Arrays;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;

public class WordFrequency {
    public static String handle(String text) {
        if (!text.equals("")) {
            return Arrays.stream(text.split(" ")).collect(groupingBy((w) -> w)).entrySet().stream()
            .sorted((e1, e2) -> e2.getValue().size() - e1.getValue().size()).map((e) -> e.getKey() + " " + e.getValue().size()).collect(joining("\r\n"));
        }
        return "";
    }
}
