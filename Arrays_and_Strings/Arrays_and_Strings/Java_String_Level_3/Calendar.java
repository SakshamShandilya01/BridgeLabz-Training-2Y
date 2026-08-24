import java.util.Scanner;

class Calendar {
    static String month(int m) {
        String[] a = {
            "January", "February", "March", "April",
            "May", "June", "July", "August",
            "September", "October", "November", "December"
        };

        return a[m - 1];
    }

    static boolean leap(int y) {
        return y % 400 == 0 || (y % 4 == 0 && y % 100 != 0);
    }

    static int days(int m, int y) {
        int[] a = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (m == 2 && leap(y)) {
            return 29;
        }

        return a[m - 1];
    }

    static int first(int m, int y) {
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;

        return (1 + x + 31 * m0 / 12) % 7;
    }

    static void display(int m, int y) {
        System.out.println(month(m) + " " + y);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        int d = first(m, y);

        for (int i = 0; i < d; i++) {
            System.out.print("    ");
        }

        for (int i = 1; i <= days(m, y); i++) {
            System.out.printf("%3d ", i);

            if ((i + d) % 7 == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int y = sc.nextInt();

        if (m < 1 || m > 12 || y < 1) {
            System.out.println("Invalid input.");
            return;
        }

        display(m, y);

        sc.close();
    }
}
