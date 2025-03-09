import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class ValidNumber {
    public static void main(String[] args) {
        int count = 0;
        int totalCount = 0;
        for (int i = 1; i <= 6; i++)
        {
            for(int j = 4; j <= 8; j++)
            {
                for(int k = 3; k <= 7; k++)
                {
                    for (int l = 1; l <= 9; l++)
                    {
                        for(int m = 1; m <= 8; m++)
                        {
                            if((i * 10000 + j * 1000 + k * 100 + l * 10 + m) % 12 == 0){
                                count++;
                            }
                            totalCount++;
                        }
                    }
                }
            }
        }
        System.out.println("Number of valid digits is: " + count);
        System.out.println("Total number of digits is: " + totalCount);
        System.out.println("Probability of valid digits is: " + String.format("%.2f", (double)count / totalCount * 100) + "%");

    }
}
