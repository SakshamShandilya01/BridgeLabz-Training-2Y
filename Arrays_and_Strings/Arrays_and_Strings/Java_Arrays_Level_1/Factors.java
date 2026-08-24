import java.util.Scanner;

class Factors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Invalid number.");
            sc.close();
            return;
        }

        int m = 10;
        int[] a = new int[m];
        int k = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                if (k == m) {
                    m *= 2;
                    int[] t = new int[m];
                    for (int j = 0; j < a.length; j++) {
                        t[j] = a[j];
                    }
                    a = t;
                }
                a[k++] = i;
            }
        }

        System.out.println("Factors:");
        for (int i = 0; i < k; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        sc.close();
    }
}
