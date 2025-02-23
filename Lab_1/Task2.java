import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int originalNumber;
        int number;
        String inputString = sc.nextLine();
        try {
            originalNumber = Integer.parseInt(inputString);
        }
        catch (NumberFormatException e) {
            System.out.println("Wrong input");
            return;
        }
        if(inputString.length() != 5)
        {
            System.out.println("Wrong input");
            return;
        }
        number = originalNumber;
        int digit1 = number % 10;
        number /= 10;
        int digit2 = number % 10;
        number /= 10;
        int digit3 = number % 10;
        number /= 10;
        int digit4 = number % 10;
        number /= 10;
        int digit5 = number % 10;

        String resultString;
        boolean isPalindrome = (digit1 == digit5) && (digit2 == digit4);
        if(isPalindrome) {
            resultString = "isPalindrome";
        }
        else {
            resultString = "isNotPalindrome";
        }
        System.out.println(resultString);
    }
    }
