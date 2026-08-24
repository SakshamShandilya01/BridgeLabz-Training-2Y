import java.util.Scanner;

class BubbleSort {
    static void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            boolean x = false;

            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                    x = true;
                }
            }

            if (!x) {
                break;
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
