import java.util.Scanner;

class BMI {
    static String status(double b) {
        if (b < 18.5) {
            return "Underweight";
        } else if (b < 25) {
            return "Normal";
        } else if (b < 30) {
            return "Overweight";
        }

        return "Obese";
    }

    static String[][] calc(double[][] a) {
        String[][] b = new String[a.length][4];

        for (int i = 0; i < a.length; i++) {
            double w = a[i][0];
            double h = a[i][1] / 100.0;
            double x = w / (h * h);

            b[i][0] = String.valueOf(a[i][1]);
            b[i][1] = String.valueOf(w);
            b[i][2] = String.format("%.2f", x);
            b[i][3] = status(x);
        }

        return b;
    }

    static void display(String[][] a) {
        System.out.println("Height\tWeight\tBMI\tStatus");

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i][0] + "\t" + a[i][1] + "\t" + a[i][2] + "\t" + a[i][3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] a = new double[10][2];

        for (int i = 0; i < a.length; i++) {
            a[i][0] = sc.nextDouble();
            a[i][1] = sc.nextDouble();
        }

        String[][] b = calc(a);
        display(b);

        sc.close();
    }
}
