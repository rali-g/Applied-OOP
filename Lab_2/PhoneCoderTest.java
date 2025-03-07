import java.util.Scanner;

public class PhoneCoderTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        try {
            input = sc.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        if (input.length() != 4) {
            System.out.println("Invalid input");
            return;
        }
        PhoneCoder pc = new PhoneCoder();

        int key = 0;
        try {
            key = sc.nextInt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        if (key < 1 || key > 9) {
            System.out.println("Invalid key");
            return;
        }
        pc.setKey(key);

        System.out.println(pc.encode(input));
        System.out.println(pc.decode(pc.encode(input)));
    }
}
