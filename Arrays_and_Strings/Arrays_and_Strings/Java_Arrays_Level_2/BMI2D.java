import java.util.Scanner;

class BMI2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[][] p = new double[n][3];
        String[] s = new String[n];

        for (int i = 0; i < n; i++) {
            while (true) {
                p[i][0] = sc.nextDouble();
                p[i][1] = sc.nextDouble();
                if (p[i][0] > 0 && p[i][1] > 0) break;
            }
        }

        for (int i = 0; i < n; i++) {
            p[i][2] = p[i][0] / (p[i][1] * p[i][1]);
            if (p[i][2] <= 18.4) s[i] = "Underweight";
            else if (p[i][2] <= 24.9) s[i] = "Normal";
            else if (p[i][2] <= 39.9) s[i] = "Overweight";
            else s[i] = "Obese";
        }

        for (int i = 0; i < n; i++) {
            System.out.println(p[i][1] + " " + p[i][0] + " " + p[i][2] + " " + s[i]);
        }
        sc.close();
    }
}
