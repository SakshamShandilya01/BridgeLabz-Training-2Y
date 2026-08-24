import java.util.Scanner;

class StoreNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] a = new double[10];
        int n = 0;
        double sum = 0.0;

        while (n < a.length) {
            double x = sc.nextDouble();
            if (x <= 0) {
                break;
            }
            a[n] = x;
            n++;
        }

        System.out.println("Numbers:");
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
            sum += a[i];
        }
        System.out.println("Sum = " + sum);
        sc.close();
    }
}
