import java.util.Scanner;

public class Task5 {
    private static void printInAscii()
    {
        System.out.println((int)'A');
        System.out.println((int)'B');
        System.out.println((int)'C' + "\n");
        System.out.println((int)'a');
        System.out.println((int)'b');
        System.out.println((int)'c' + "\n");
        System.out.println((int)'0');
        System.out.println((int)'1');
        System.out.println((int)'2' + "\n");
        System.out.println((int)'$');
        System.out.println((int)'*');
        System.out.println((int)'+');
        System.out.println((int)'/');
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        printInAscii();
    }
}
