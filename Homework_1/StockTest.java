import java.util.Scanner;

public class StockTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name;
        String symbol;
        double currentPrice;
        double previousClosingPrice;
        try {
            System.out.println("Enter the name of the stock: ");
            name = sc.nextLine();
            System.out.println("Enter the symbol of the stock: ");
            symbol = sc.nextLine();
            System.out.println("Enter the previous price of the stock: ");
            previousClosingPrice = sc.nextDouble();
            System.out.println("Enter the current price of the stock: ");
            currentPrice = sc.nextDouble();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        Stock stock = new Stock();
        stock.setName(name);
        stock.setSymbol(symbol);
        stock.setCurrentPrice(currentPrice);
        stock.setPreviousClosingPrice(previousClosingPrice);

        System.out.println("Name: " + stock.getName());
        System.out.println("Symbol: " + stock.getSymbol());
        System.out.println(String.format("Price: %.2f", stock.getCurrentPrice()));
        System.out.println(String.format("PreviousPrice: %.2f", stock.getPreviousClosingPrice()));
        System.out.println(String.format("Price Change: %.2f", stock.changePercent()) + "%");
    }
}
