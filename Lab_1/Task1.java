import java.util.Scanner;

public class Task1 {
    private static double fahrenheitToCelsius(double fahrenheit)
    {
        return (5.0 / 9.0 * (fahrenheit - 32));
    }
    private static double celsiusToFahrenheit(double celsius)
    {
        return (9.0 / 5.0 * celsius + 32);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the type\n 1. Fahrenheit: \n 2. Celsius: ");
        int currentType = sc.nextInt();
        if(currentType == 1)
        {
            System.out.println("Please enter the value");
            double fahrenheit = sc.nextDouble();
            System.out.println("Celsius: " + String.format("%.2f", fahrenheitToCelsius(fahrenheit)));
        }
        else if(currentType == 2)
        {
            System.out.println("Please enter the value");
            double celsius = sc.nextDouble();
            System.out.println("Fahrenheit: " + String.format("%.2f", celsiusToFahrenheit(celsius)));
        }
        else
        {
            System.out.println("Wrong input");
        }
    }
}
