import java.util.Scanner;

class MergeSort {
    static void sort(int[] a, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            sort(a, l, m);
            sort(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    static void merge(int[] a, int l, int m, int r) {
        int[] b = new int[r - l + 1];

        int i = l;
        int j = m + 1;
        int k = 0;

        while (i <= m && j <= r) {
            if (a[i] <= a[j]) {
                b[k] = a[i];
                i++;
            } else {
                b[k] = a[j];
                j++;
            }
            k++;
        }

        while (i <= m) {
            b[k] = a[i];
            i++;
            k++;
        }

        while (j <= r) {
            b[k] = a[j];
            j++;
            k++;
        }

        for (i = 0; i < b.length; i++) {
            a[l + i] = b[i];
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

        sort(a, 0, a.length - 1);
        display(a);

        sc.close();
    }
}
