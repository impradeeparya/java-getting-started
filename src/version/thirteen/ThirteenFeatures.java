package version.thirteen;


public class ThirteenFeatures {

    public static void main(String[] args) {


        switchYield();
        jsonFormatting();

        String url = "pradeep";
        url = String.join("/", url, null);
        System.out.println(url);
    }

    private static void jsonFormatting() {
        String JSON_TEXT = """
                {
                    "firstName": "Pradeep",
                    "lastName": "Arya"
                }
                """;
        System.out.println(JSON_TEXT);
    }

    private static void switchYield() {
        var me = 4;
        var operation = "doubleMe";
        var output = switch (operation) {
            case "doubleMe" -> {
                System.out.println(me);
                yield me * 2;
            }
            case "squareMe" -> me * me;
            default -> me;
        };
        System.out.println(output);
    }
}
