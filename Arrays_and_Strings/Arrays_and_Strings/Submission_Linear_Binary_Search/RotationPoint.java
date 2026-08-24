import java.util.Scanner;

class RotationPoint {
    static int search(int[] a) {
        int l = 0;
        int r = a.length - 1;

        while (l < r) {
            int m = l + (r - l) / 2;

            if (a[m] > a[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        int i = search(a);

        System.out.println("Index: " + i);
        System.out.println("Rotation point: " + a[i]);

        sc.close();
    }
}
