import java.util.Scanner;

class CountingSort {
    static void sort(int[] a) {
        int[] c = new int[9];

        for (int i = 0; i < a.length; i++) {
            c[a[i] - 10]++;
        }

        int k = 0;

        for (int i = 0; i < c.length; i++) {
            while (c[i] > 0) {
                a[k] = i + 10;
                k++;
                c[i]--;
            }
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
