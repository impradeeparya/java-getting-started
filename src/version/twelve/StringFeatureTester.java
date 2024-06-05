package version.twelve;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringFeatureTester {


    public static void main(String[] args) throws IOException {

        stringOperations();
        fileOperations();
        collectionOperations();
        numberFormattingOperations();
        switchOperations();
        objectInstanceOf();
    }

    private static void objectInstanceOf() {
        Object firstName = "Pradeep";
        if(firstName instanceof String s){
            System.out.println(s.length());
        }
    }

    private static void switchOperations() {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        String typeOfDay = switch (dayOfWeek) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "Working Day";
            case SATURDAY, SUNDAY -> {
                System.out.println("hello world");
                yield "Day Off";
            }
        };
        System.out.println(typeOfDay);
    }

    private static void numberFormattingOperations() {
        NumberFormat likesShort =
                NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.SHORT);
        likesShort.setMaximumFractionDigits(2);
        System.out.println(likesShort.format(2592));

        NumberFormat likesLong =
                NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.LONG);
        likesLong.setMaximumFractionDigits(2);
        System.out.println(likesLong.format(2592));
    }

    private static void collectionOperations() {
        double mean = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.teeing(Collectors.summingDouble(i -> i),
                        Collectors.counting(), (sum, count) -> sum / count));
        System.out.println(mean);
    }

    private static void fileOperations() throws IOException {
        Path filePath1 = Files.createTempFile("file1", ".txt");
        Path filePath2 = Files.createTempFile("file2", ".txt");
        Files.writeString(filePath1, "Java 12 Article");
        Files.writeString(filePath2, "Java 12 Article");

        long mismatch = Files.mismatch(filePath1, filePath2);
        System.out.println(mismatch);
    }

    private static void stringOperations() {
        String text = "Hello Batman.\n Do you bleed.";
        text.indent(2);
        System.out.println(text);


        text = "Marvel";
        String transformed = text.transform(input -> new StringBuilder(input).reverse().toString());
        System.out.println(transformed);
    }


}
