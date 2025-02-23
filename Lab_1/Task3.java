import java.util.Scanner;

public class Task3 {
    private static void swap(int []digits)
    {
        int temp = digits[0];
        digits[0] = digits[2];
        digits[2] = temp;

        temp = digits[1];
        digits[1] = digits[3];
        digits[3] = temp;
    }
    private static int getNum(int[] digits)
    {
        int mult = 1;
        int result = 0;
        for(int i = digits.length - 1; i >= 0; i--) {
            result += digits[i] * mult;
            mult *= 10;
        }
        return result;
    }
    private static int encrypt(int number)
    {
        int [] digits = new int [4];
        for(int i = digits.length - 1; i >= 0; i--)
        {
            digits[i] = (number % 10 + 7) % 10;
            number /= 10;
        }
        swap(digits);
        return getNum(digits);
    }
    private static int decrypt(int number)
    {
        int [] digits = new int [4];
        for(int i = digits.length - 1; i >= 0; i--)
        {
            digits[i] = number % 10;
            number /= 10;
        }
        swap(digits);
        for(int i = digits.length - 1; i >= 0; i--)
        {
            if(digits[i] - 7 < 0){
                digits[i] += 3;
            }
            else{
                digits[i] -= 7;
            }
        }
        return getNum(digits);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int originalNumber;
        try
        {
            originalNumber = Integer.parseInt(sc.next());
        }
        catch(NumberFormatException e)
        {
            System.out.println("Wrong input");
            return;
        }
        if(originalNumber < 1000 || originalNumber >= 10000)
        {
            System.out.println("Wrong input");
            return;
        }
        System.out.println(encrypt(originalNumber));
        System.out.println(decrypt(encrypt(originalNumber)));
    }
}
