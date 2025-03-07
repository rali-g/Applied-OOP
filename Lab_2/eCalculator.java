import java.util.Scanner;

public class eCalculator { //e^x
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        double result = 1;
        double current = 1;
        int power = 1;
        while(Math.abs(current) > 0.001) {
            current = current * x / power;
            result += current;
            power++; //
        }
        System.out.println("e^" + x + " = " + result);
    }
}
