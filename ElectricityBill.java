import java.util.Scanner;
public class ElectricityBill {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Electricity Bill Calculation ---");
        System.out.print("Enter Consumer Number: ");
        int consumerNo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Consumer Name: ");
        String consumerName = scanner.nextLine();
        System.out.print("Enter Previous Month Reading (units): ");
        double previousReading = scanner.nextDouble();
        System.out.print("Enter Current Month Reading (units): ");
        double currentReading = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Type of EB Connection (Domestic/Commercial): ");
        String connectionType = scanner.nextLine();
        BillCalculator billCalculator = new BillCalculator(consumerNo, consumerName, previousReading, currentReading, connectionType);
        billCalculator.calculateBill();
        billCalculator.displayBill();
        scanner.close();
    }
}
class BillCalculator {
    private int consumerNo;
    private String consumerName;
    private double previousReading;
    private double currentReading;
    private String connectionType;
    private double unitsConsumed;
    private double billAmount;
   public BillCalculator(int consumerNo, String consumerName, double previousReading, double currentReading, String connectionType) {
        this.consumerNo = consumerNo;
        this.consumerName = consumerName;
        this.previousReading = previousReading;
        this.currentReading = currentReading;
        this.connectionType = connectionType;
        this.unitsConsumed = currentReading - previousReading;
        this.billAmount = 0.0;
    }
      public void calculateBill() {
        if (connectionType.equalsIgnoreCase("Domestic")) {
            if (unitsConsumed <= 100) {
                billAmount = unitsConsumed * 1;
            } else if (unitsConsumed <= 200) {
                billAmount = (100 * 1) + ((unitsConsumed - 100) * 2.50);
            } else if (unitsConsumed <= 500) {
                billAmount = (100 * 1) + (100 * 2.50) + ((unitsConsumed - 200) * 4);
            } else {
                billAmount = (100 * 1) + (100 * 2.50) + (300 * 4) + ((unitsConsumed - 500) * 6);
            }
        } else if (connectionType.equalsIgnoreCase("Commercial")) {
            if (unitsConsumed <= 100) {
                billAmount = unitsConsumed * 2;
            } else if (unitsConsumed <= 200) {
                billAmount = (100 * 2) + ((unitsConsumed - 100) * 4.50);
            } else if (unitsConsumed <= 500) {
                billAmount = (100 * 2) + (100 * 4.50) + ((unitsConsumed - 200) * 6);
            } else {
                billAmount = (100 * 2) + (100 * 4.50) + (300 * 6) + ((unitsConsumed - 500) * 7);
            }
 } else {
            System.out.println("Invalid connection type entered. Bill cannot be calculated.");
            billAmount = 0;
        }
    }
        public void displayBill() {
        System.out.println("\n--- Electricity Bill Details ---");
        System.out.println("Consumer Number: " + consumerNo);
        System.out.println("Consumer Name: " + consumerName);
        System.out.println("Previous Reading: " + previousReading + " units");
        System.out.println("Current Reading: " + currentReading + " units");
        System.out.println("Units Consumed: " + unitsConsumed + " units");
        System.out.println("Connection Type: " + connectionType);
        System.out.printf("Bill Amount: Rs. %.2f%n", billAmount);
    }
}
