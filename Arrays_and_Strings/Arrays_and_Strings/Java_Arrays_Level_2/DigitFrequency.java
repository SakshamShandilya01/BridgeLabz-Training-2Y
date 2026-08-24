import java.util.Scanner;

class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Invalid number.");
            sc.close();
            return;
        }

        int t = n, c = 0;
        if (t == 0) c = 1;
        while (t != 0) {
            c++;
            t /= 10;
        }

        int[] d = new int[c];
        int[] f = new int[10];
        t = n;

        for (int i = 0; i < d.length; i++) {
            d[i] = t % 10;
            t /= 10;
            f[d[i]]++;
        }

        for (int i = 0; i < f.length; i++) {
            if (f[i] > 0) {
                System.out.println(i + " = " + f[i]);
            }
        }
        sc.close();
    }
}
