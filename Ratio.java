package ratioCalc;

import java.util.Scanner;

public class Ratio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        double calcium = 0;
        double phosphorus = 0;
        System.out.println("Enter Calcium: ");
        System.out.println("1: mmol/l");
        System.out.println("2: convert from mg/dl");
        input = scanner.nextInt();
        switch (input) {
            case 1:
                System.out.println("Calcium: ");
                calcium = scanner.nextDouble();
                break;
            case 2:
                System.out.println("Calcium: ");
                calcium = scanner.nextDouble();
                calcium = convertCa(calcium);
                break;
        }
        System.out.println("Enter phosphorus: ");
        System.out.println("1: mmol/l");
        System.out.println("2: convert from mg/dl");
        input = scanner.nextInt();
        switch (input) {
            case 1:
                System.out.println("Phosphorus: ");
                phosphorus = scanner.nextDouble();
                break;
            case 2:
                System.out.println("Phosphorus: ");
                phosphorus = scanner.nextDouble();
                phosphorus = convertP(phosphorus);
                break;
        }

        System.out.println("Enter: ");
        System.out.println("1: pH");
        System.out.println("2: albumins g/l");
        input = scanner.nextInt();
        switch (input) {
            case 1:
                System.out.println("pH: ");
                double pH = scanner.nextDouble();
                double ca = calciumCorrectedpH(calcium, pH);
                System.out.println("Ca/P ratio: " + ratio(ca, phosphorus));
                break;
            case 2:
                System.out.println("Albumins: ");
                double albumins = scanner.nextDouble();
                double ca2 = calciumCorrectedAlbumins(calcium, albumins);
                System.out.println("Ca/P ratio: " + ratio(ca2, phosphorus));
                break;
        }
    }

    public static double ratio(double calciumCorrected, double phosphorus) {
        return calciumCorrected / phosphorus;
    }


    public static double calciumCorrectedAlbumins(double calcium, double parameter) {
        return calcium + 0.02 * (40 - parameter);
    }

    public static double calciumCorrectedpH(double calcium, double parameter) {
        return calcium + 0.5 * (7.40 - parameter);
    }


    public static double convertCa(double calcium) {
        return 0.25 * calcium;
    }

    public static double convertP(double phosphorus) {
        return 0.323 * phosphorus;
    }
}
