import java.util.Scanner;

class SearchChallenge {
    static int missing(int[] a) {
        int n = a.length;
        boolean[] v = new boolean[n + 2];

        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0 && a[i] <= n + 1) {
                v[a[i]] = true;
            }
        }

        for (int i = 1; i <= n + 1; i++) {
            if (!v[i]) {
                return i;
            }
        }

        return n + 1;
    }

    static void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
    }

    static int search(int[] a, int x) {
        int l = 0;
        int r = a.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (a[m] == x) {
                return m;
            } else if (a[m] < x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        int x = sc.nextInt();

        System.out.println("First missing positive: " + missing(a));

        sort(a);

        System.out.println("Target index: " + search(a, x));

        sc.close();
    }
}
