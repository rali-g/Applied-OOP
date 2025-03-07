import shape.Rectangle;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class RectangleTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double width;
        double height;
        String color;
        try
        {
            System.out.print("Enter the width of the rectangle: ");
            width = sc.nextDouble();
            System.out.print("Enter the height of the rectangle: ");
            height = sc.nextDouble();
            System.out.print("Enter the color of the rectangle: ");
            color = sc.next();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return;
        }
        Rectangle rectangle = new Rectangle(width, height);
        rectangle.setColor(color);

        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println("Color: " + color);
        System.out.println("Perimeter: " + String.format("%.2f", rectangle.getPerimeter()));
        System.out.println("Area: " + String.format("%.2f", rectangle.getArea()));
    }
}