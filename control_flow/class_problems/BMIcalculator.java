package control_flow.class_problems;

import java.util.Random;

public class BMIcalculator {

    public static String getBmiStatus(double bmi) {

        if (bmi < 18.5) {
            return "Underweight";
        } 
        else if (bmi < 25) {
            return "Normal";
        } 
        else if (bmi < 30) {
            return "Overweight";
        } 
        else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {

        System.out.println("\nWellness Report");
        System.out.println("Person\tHeight(m)\tWeight(kg)\tBMI\tStatus");

        for (int i = 0; i < heights.length; i++) {

            double bmi = weights[i] / (heights[i] * heights[i]);

            String status = getBmiStatus(bmi);

            System.out.printf(
                "%d\t%.2f\t\t%.2f\t\t%.2f\t%s%n",
                i + 1, heights[i], weights[i], bmi, status
            );
        }
    }

    public static void main(String[] args) {

        Random random = new Random();

        double[] heights = new double[10];
        double[] weights = new double[10];

        for (int i = 0; i < 10; i++) {

            heights[i] = 1.50 + random.nextDouble() * 0.50;

            weights[i] = 40 + random.nextDouble() * 60;
        }

        printWellnessReport(heights, weights);
    }
}
