import java.util.Scanner;

class Bonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] sal = new double[10];
        double[] yrs = new double[10];
        double[] bon = new double[10];
        double[] ns = new double[10];
        double tb = 0, ts = 0, tn = 0;

        for (int i = 0; i < sal.length; i++) {
            while (true) {
                double s = sc.nextDouble();
                double y = sc.nextDouble();
                if (s >= 0 && y >= 0) {
                    sal[i] = s;
                    yrs[i] = y;
                    break;
                }
            }
        }

        for (int i = 0; i < sal.length; i++) {
            if (yrs[i] > 5) {
                bon[i] = sal[i] * 0.05;
            } else {
                bon[i] = sal[i] * 0.02;
            }
            ns[i] = sal[i] + bon[i];
            tb += bon[i];
            ts += sal[i];
            tn += ns[i];
        }

        System.out.println("Total bonus = " + tb);
        System.out.println("Total old salary = " + ts);
        System.out.println("Total new salary = " + tn);
        sc.close();
    }
}
