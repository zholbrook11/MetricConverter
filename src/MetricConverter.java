import java.util.Scanner;
import java.util.InputMismatchException; 
public class MetricConverter {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=".repeat(30));
        System.out.println("Welcome to Metric Converter!!!");
        System.out.println("=".repeat(30));
        System.out.println("Type 'exit' to quit the program");
       
        while (true){
            System.out.println("Please select an option for conversion:");
            System.out.println("1 ~ kg to lb");
            System.out.println("2 ~ mm to in");
            System.out.println("3 ~ km to mile");
            System.out.println("4 ~ g to oz");
            System.out.println("5 ~ yard to ft");

            String input = scanner.next();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }

            int userOption;
            try {
                userOption = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please select an option (1-5) or type 'exit' to quit.");
                continue;
            }

            int[] optionArr = {1, 2, 3, 4, 5};
            boolean found = false;

            for (int option : optionArr) {
                if (option == userOption) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Invalid input. Please select an option (1-5) or type 'exit' to quit.");
                continue;
            }
            System.out.println("Please enter the quantity of the unit you wish to converge:");
            
            double quantity = 0;

            boolean validQuantity = false;

            while (!validQuantity) {

                try {
                    quantity = scanner.nextDouble();
                    validQuantity = true;
                } catch (InputMismatchException e) {
                    System.out.println("Please input a numerical value to convert units. Try again:");
                    scanner.next();
                    continue;
                }
            }
            switch (userOption) {
                case 1: 
                    double lbs = (quantity * 2.205);
                    System.out.println(quantity + " kilograms is equal to " + lbs + " pounds.");
                    
                    break;
                case 2:
                    double inches = (quantity / 25.4);
                    System.out.println(quantity + " millimeters is equal to " + inches + " inches.");
                    break;

                case 3:
                    double miles = (quantity / 1.609);
                    System.out.println(quantity + " kilometers is equal to " + miles + " miles.");
                    break;

                case 4:
                    double ounces = (quantity / 28.35);
                    System.out.println(quantity + " grams is equal to " + ounces + " ounces.");
                    break;

                case 5: 
                    double feet = (quantity * 3);
                    System.out.println(quantity + " yards is equal to " + feet + " feet.");

                    break;
            
                default:
                    System.out.println("Invalid option.");
                    break;
            }

        }

        scanner.close();
    }
}
