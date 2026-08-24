import java.util.Scanner;

class BMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] w = new double[n];
        double[] h = new double[n];
        double[] b = new double[n];
        String[] s = new String[n];

        for (int i = 0; i < n; i++) {
            while (true) {
                w[i] = sc.nextDouble();
                h[i] = sc.nextDouble();
                if (w[i] > 0 && h[i] > 0) break;
            }
        }

        for (int i = 0; i < n; i++) {
            b[i] = w[i] / (h[i] * h[i]);
            if (b[i] <= 18.4) s[i] = "Underweight";
            else if (b[i] <= 24.9) s[i] = "Normal";
            else if (b[i] <= 39.9) s[i] = "Overweight";
            else s[i] = "Obese";
        }

        for (int i = 0; i < n; i++) {
            System.out.println(h[i] + " " + w[i] + " " + b[i] + " " + s[i]);
        }
        sc.close();
    }
}
