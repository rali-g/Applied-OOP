import java.text.NumberFormat;
import java.util.Random;

public class RandomNumberGenerator {
    static int drawRandomNumber(){
        Random rand = new Random();
        double randomNumber = rand.nextDouble();
        if(randomNumber <= 0.2) {
            return 1;
        }
        if(randomNumber <= 0.5){
            return 2;
        }
        return 3;
    }
    public static void main(String[] args) {
        printProbability(10000);
        printProbability(60000);
    }
    private static void printProbability(double loopCount){
        int countOne = 0, countTwo = 0, countThree = 0;
        for (int i = 1; i <= loopCount; i++) {
            int currentNumber = drawRandomNumber();
            if (currentNumber == 1) {
                countOne++;
            } else if (currentNumber == 2) {
                countTwo++;
            } else {
                countThree++;
            }
        }
        NumberFormat formatter = NumberFormat.getPercentInstance();
        formatter.setMaximumFractionDigits(2);
        formatter.setMinimumFractionDigits(2);
        double probOne = countOne / loopCount;
        double probTwo = countTwo / loopCount;
        double probThree = countThree / loopCount;
        System.out.println("Method called " + loopCount + " times\n");
        System.out.println("Probability of one: " + formatter.format(probOne));
        System.out.println("Probability of two: " + formatter.format(probTwo));
        System.out.println("Probability of three: " + formatter.format(probThree));
        System.out.println();
    }
}
