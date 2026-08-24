import java.util.Scanner;

class Cards {
    static String[] deck() {
        String[] s = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] r = {
            "2", "3", "4", "5", "6", "7", "8",
            "9", "10", "Jack", "Queen", "King", "Ace"
        };

        String[] a = new String[s.length * r.length];
        int k = 0;

        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < r.length; j++) {
                a[k] = r[j] + " of " + s[i];
                k++;
            }
        }

        return a;
    }

    static String[] shuffle(String[] a) {
        for (int i = 0; i < a.length; i++) {
            int n = i + (int)(Math.random() * (a.length - i));
            String t = a[i];
            a[i] = a[n];
            a[n] = t;
        }

        return a;
    }

    static String[][] distribute(String[] a, int p, int n) {
        if (n > a.length || n % p != 0) {
            return null;
        }

        int k = n / p;
        String[][] b = new String[p][k];

        for (int i = 0; i < n; i++) {
            b[i % p][i / p] = a[i];
        }

        return b;
    }

    static void display(String[][] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println("Player " + (i + 1) + ":");

            for (int j = 0; j < a[i].length; j++) {
                System.out.println(a[i][j]);
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int p = sc.nextInt();

        if (n < 1 || n > 52 || p < 1 || p > n || n % p != 0) {
            System.out.println("Cards cannot be equally distributed.");
            return;
        }

        String[] a = deck();
        a = shuffle(a);

        String[][] b = distribute(a, p, n);

        if (b != null) {
            display(b);
        }

        sc.close();
    }
}
