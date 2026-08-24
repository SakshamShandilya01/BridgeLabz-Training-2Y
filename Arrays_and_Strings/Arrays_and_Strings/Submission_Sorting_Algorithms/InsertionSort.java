import java.util.Scanner;

class InsertionSort {
    static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int x = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > x) {
                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = x;
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
