package version.fourteen;

/**
 * Created by p0a00hg on 16/04/24
 **/
public record Car(String modelNumber, String color, String engineType, int fuelCapacity) {

    public static final String COMPANY = "Maruti";

    public static String getCompany() {
        return COMPANY;
    }
}
