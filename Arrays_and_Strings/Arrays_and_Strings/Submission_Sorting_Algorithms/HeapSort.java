import java.util.Scanner;

class HeapSort {
    static void sort(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            heap(a, a.length, i);
        }

        for (int i = a.length - 1; i > 0; i--) {
            int t = a[0];
            a[0] = a[i];
            a[i] = t;

            heap(a, i, 0);
        }
    }

    static void heap(int[] a, int n, int i) {
        int k = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && a[l] > a[k]) {
            k = l;
        }

        if (r < n && a[r] > a[k]) {
            k = r;
        }

        if (k != i) {
            int t = a[i];
            a[i] = a[k];
            a[k] = t;

            heap(a, n, k);
        }
    }

    static void display(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        sort(a);
        display(a);

        sc.close();
    }
}
