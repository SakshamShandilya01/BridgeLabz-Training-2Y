import java.util.Scanner;

class SelectionSort {
    static void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int k = i;

            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[k]) {
                    k = j;
                }
            }

            int t = a[i];
            a[i] = a[k];
            a[k] = t;
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
