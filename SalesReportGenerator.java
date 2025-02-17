import java.util.Scanner;

public class SalesReportGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt for the number of products with input validation
        int num;
        while (true) {
            System.out.print("Enter the number of products: ");
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                if (num > 0) {
                    sc.nextLine(); // Consume newline
                    break;
                } else {
                    System.out.println("Error: Number of products must be greater than zero. Try again.");
                }
            } else {
                System.out.println("Error: Invalid input. Please enter a valid integer.");
                sc.next(); // Clear invalid input
            }
        }

        // Initialize arrays and variables
        double[] sales = new double[num];
        String[] products = new String[num];
        double totalSales = 0, highestSales = 0, averageSales;
        int highestSalesIndex = -1;

        // Collect product details using a for loop with error handling
        for (int i = 0; i < num; i++) {
            System.out.print("Enter product name: ");
            products[i] = sc.nextLine(); // Read product name

            // Sales input validation
            while (true) {
                System.out.print("Enter product sales: ");
                if (sc.hasNextDouble()) {
                    sales[i] = sc.nextDouble();
                    sc.nextLine(); // Consume newline
                    if (sales[i] >= 0) {
                        break;
                    } else {
                        System.out.println("Error: Sales value cannot be negative. Try again.");
                    }
                } else {
                    System.out.println("Error: Invalid input. Please enter a numeric sales value.");
                    sc.next(); // Clear invalid input
                }
            }
        }
        // Calculate total sales and determine highest-selling product using nested if conditions
        for (int i = 0; i < num; i++) {
            totalSales += sales[i];

            if (i == 0) {
                highestSales = sales[i];
                highestSalesIndex = i;
            } else {
                if (sales[i] > highestSales) {
                    highestSales = sales[i];
                    highestSalesIndex = i;
                }
            }
        }
        // Calculate average sales
        averageSales = totalSales / num;

        // Display the Sales Report using loops
        System.out.println("\nSales Report using for loop:");
        System.out.println("----------------------------");
        System.out.println("Total Sales: " + totalSales);
        System.out.println("Average Sales: " + averageSales);
        System.out.println("Highest-selling product: " + products[highestSalesIndex] + " (Sales: " + highestSales + ")");

        System.out.println("\nSales Report product-wise :");
        System.out.println("------------------------------");
        int i = 0;
        while (i < num) {
            System.out.println("Product: " + products[i] + " | Sales: " + sales[i]);
            i++;
        }
    }
}
