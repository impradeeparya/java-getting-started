package version.fourteen;

public class FeatureTester {

    public static void main(String[] args) {

        Car altoLxi = new Car("A1", "Silver", "B6", 16);
        Car duplicateAltoLxi = new Car("A1", "Silver", "B6", 16);
        Car altoVxi = new Car("A2", "White", "B6", 16);

        System.out.println(altoLxi);
        System.out.println(altoLxi.modelNumber());
        System.out.println(Car.getCompany());
        System.out.println(Car.COMPANY);


        System.out.println(altoVxi);
        System.out.println(altoLxi.equals(altoVxi));
        System.out.println(altoLxi.equals(duplicateAltoLxi));

    }
}
