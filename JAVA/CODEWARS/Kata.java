package JAVA.CODEWARS;
import java.util.Scanner;

public class Kata {
    public static String bmi(double weight, double height) {
        double bmi = weight / (height * height);
        if (bmi <= 18.5) {
            return "Underweight";
        } else if (bmi <= 25.0) {
            return "Normal";
        } else if (bmi <= 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input your weight (in kg):");
        double weight = sc.nextDouble();

        System.out.println("Input your height (in meters):");
        double height = sc.nextDouble();

        String result = bmi(weight, height);
        System.out.println("Your BMI category is: " + result);

        sc.close(); // Close the scanner to avoid resource leak
    }
}
