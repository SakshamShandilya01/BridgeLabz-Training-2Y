import java.util.Scanner;

class StudentScorecard {
    static int[][] marks(int n) {
        int[][] a = new int[n][3];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = (int)(Math.random() * 90) + 10;
            }
        }

        return a;
    }

    static double[][] calc(int[][] a) {
        double[][] b = new double[a.length][3];

        for (int i = 0; i < a.length; i++) {
            int t = a[i][0] + a[i][1] + a[i][2];
            double av = t / 3.0;
            double p = t / 3.0;

            b[i][0] = t;
            b[i][1] = Math.round(av * 100.0) / 100.0;
            b[i][2] = Math.round(p * 100.0) / 100.0;
        }

        return b;
    }

    static String[][] grade(double[][] a) {
        String[][] b = new String[a.length][1];

        for (int i = 0; i < a.length; i++) {
            double p = a[i][2];

            if (p >= 80) {
                b[i][0] = "A";
            } else if (p >= 70) {
                b[i][0] = "B";
            } else if (p >= 60) {
                b[i][0] = "C";
            } else if (p >= 50) {
                b[i][0] = "D";
            } else if (p >= 40) {
                b[i][0] = "E";
            } else {
                b[i][0] = "R";
            }
        }

        return b;
    }

    static void display(int[][] a, double[][] b, String[][] c) {
        System.out.println("P\tC\tM\tTotal\tAverage\tPercentage\tGrade");

        for (int i = 0; i < a.length; i++) {
            System.out.println(
                a[i][0] + "\t" +
                a[i][1] + "\t" +
                a[i][2] + "\t" +
                (int)b[i][0] + "\t" +
                b[i][1] + "\t" +
                b[i][2] + "\t\t" +
                c[i][0]
            );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Invalid number of students.");
            return;
        }

        int[][] a = marks(n);
        double[][] b = calc(a);
        String[][] c = grade(b);

        display(a, b, c);

        sc.close();
    }
}
