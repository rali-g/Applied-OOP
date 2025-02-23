import java.util.Scanner;

public class Task4 {
    private static char fromIndexToSymbol(int index){
        if(index == 0)
            return 'A';
        else if(index == 1)
            return 'C';
        else if(index == 2)
            return 'G';
        else if(index == 3)
            return 'T';
        return '0';
    }
    private static String fromDecimalToFourthNumericSystem(int input)
    {
        String output = "";
        while(input > 0)
        {
            int index = input % 4;
            input /= 4;
            output += fromIndexToSymbol(index);
        }
        return new StringBuilder(output).reverse().toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int number;
        try{
            number = Integer.parseInt(input);
        }
        catch(NumberFormatException e){
            System.out.println("Wrong input");
            return;
        }
        if(number < 1000 || number >= 10000)
        {
            System.out.println("Wrong input");
            return;
        }
        System.out.println(fromDecimalToFourthNumericSystem(number));
    }
}
