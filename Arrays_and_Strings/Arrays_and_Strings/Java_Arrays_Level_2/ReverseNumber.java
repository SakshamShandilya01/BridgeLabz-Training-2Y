import java.util.Scanner;

class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Invalid number.");
            sc.close();
            return;
        }

        int t = n, c = 0;
        while (t != 0) {
            c++;
            t /= 10;
        }

        int[] a = new int[c];
        int[] b = new int[c];
        t = n;

        for (int i = 0; i < a.length; i++) {
            a[i] = t % 10;
            t /= 10;
        }

        for (int i = 0; i < b.length; i++) {
            b[i] = a[a.length - 1 - i];
        }

        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]);
        }
        System.out.println();
        sc.close();
    }
}
