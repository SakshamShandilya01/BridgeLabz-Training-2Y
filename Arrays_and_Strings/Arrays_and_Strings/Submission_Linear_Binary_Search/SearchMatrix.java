import java.util.Scanner;

class SearchMatrix {
    static boolean search(int[][] a, int x) {
        int r = a.length;
        int c = a[0].length;
        int l = 0;
        int h = r * c - 1;

        while (l <= h) {
            int m = l + (h - l) / 2;
            int i = m / c;
            int j = m % c;

            if (a[i][j] == x) {
                return true;
            } else if (a[i][j] < x) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] a = new int[r][c];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int x = sc.nextInt();

        System.out.println(search(a, x));

        sc.close();
    }
}
