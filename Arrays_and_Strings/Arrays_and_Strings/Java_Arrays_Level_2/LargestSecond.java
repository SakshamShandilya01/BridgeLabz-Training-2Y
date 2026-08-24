import java.util.Scanner;

class LargestSecond {
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

        while (n != 0) {
            if (k == m) break;
            a[k++] = n % 10;
            n /= 10;
        }

        int max = 0, sec = 0;
        for (int i = 0; i < k; i++) {
            if (a[i] > max) {
                sec = max;
                max = a[i];
            } else if (a[i] > sec && a[i] != max) {
                sec = a[i];
            }
        }

        System.out.println("Largest = " + max);
        System.out.println("Second largest = " + sec);
        sc.close();
    }
}
