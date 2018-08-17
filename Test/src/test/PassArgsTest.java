package test;

public class PassArgsTest {
    public static void main(String[] args) {
        PassArgsTest argsTest = new PassArgsTest();

        // int is a primitive data type
        int number = 1;
        argsTest.changeInt(number);
        System.out.println("Updated number: " + number);

        // Since String is a class, it is a reference data type.
        // String is immutable.
        String city = "San Jose";
        argsTest.changeString(city);
        System.out.println("Updated city: " + city);

        // StringBuilder is a class and the characters that make up the object is mutable (can be changed).
        // See https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html for more info.
        StringBuilder name = new StringBuilder("George");
        argsTest.changeStringBuilder(name);
        System.out.println("Updated name: " + name);

        int[] arr = new int[] { 2016 };
        argsTest.changeArray(arr);
        System.out.println("Updated array: " + arr[0]);
    }

    public void changeInt(int number) {
        number = 7;
    }

    public void changeString(String city) {
        city = city.toUpperCase();
    }

    public void changeStringBuilder(StringBuilder name) {
        name.append(" Washington");
    }

    public void changeArray(int[] arr) {
        arr[0] = 2000;
    }
}