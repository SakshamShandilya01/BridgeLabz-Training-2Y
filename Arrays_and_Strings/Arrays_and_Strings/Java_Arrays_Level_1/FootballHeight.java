import java.util.Scanner;

class FootballHeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] h = new double[11];
        double sum = 0;

        for (int i = 0; i < h.length; i++) {
            h[i] = sc.nextDouble();
            sum += h[i];
        }

        double mean = sum / h.length;
        System.out.println("Mean height = " + mean);
        sc.close();
    }
}
