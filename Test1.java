import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(" ----- Java Calculator ----- ");

        // Taking input
        System.out.print("Enter first number:- ");
        double num1 = sc.nextDouble();

        System.out.print("Enter second number:- ");
        double num2 = sc.nextDouble();

        System.out.println("Choose an operation: + , - ,  * , /");
        char operator = sc.next().charAt(0);

        double result;


        switch (operator) {
            case '+':
                result = num1 + num2;
                System.out.println("Addition: " + result);
                break;
            case '-':
                result = num1 - num2;
                System.out.println("Subtraction: " + result);
                break;
            case '*':
                result = num1 * num2;
                System.out.println("Multiplication: " + result);
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                    System.out.println("division: " + result);
                } else {
                    System.out.println("Error! Division by zero is not allowed.");
                }
                break;
            default:
                System.out.println("Invalid operator!");
        }

        sc.close();
    }
}





