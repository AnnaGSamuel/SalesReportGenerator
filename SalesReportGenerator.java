import java.util.Scanner;

public class SalesReportGenerator {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.print("Enter the number of products : ");
        int num = sc.nextInt();
        sc.nextLine();

        double[] sales = new double[num];
        String[] products = new String[num];

        double totalSales = 0;
        double highestSales = 0,averageSales;
        int highestSalesIndex = -1;

        for(int i=0;i<num;i++)
        {
            System.out.print("Enter product name : ");
            products[i] = sc.nextLine();

            System.out.print("Enter product sales : ");
            sales[i] = sc.nextDouble();

            sc.nextLine();

        }

        for(int i=0;i<num;i++)
        {
            totalSales += sales[i];
            if(sales[i] > highestSales) {
                highestSales = sales[i];
                highestSalesIndex = i;
                System.out.println("Highest sales index : "+highestSalesIndex);
            }
        }
        averageSales = totalSales / num;

        System.out.println("Sales Report:");
        System.out.println("Total Sales : "+totalSales);
        System.out.println("Average Sales : "+averageSales);
        System.out.println("Highest-selling product : "+products[highestSalesIndex]);
    }
}
