import java.util.Scanner;

class StudentGrade2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] m = new int[n][3];
        double[] per = new double[n];
        char[] g = new char[n];

        for (int i = 0; i < n; i++) {
            while (true) {
                m[i][0] = sc.nextInt();
                m[i][1] = sc.nextInt();
                m[i][2] = sc.nextInt();
                if (m[i][0] >= 0 && m[i][1] >= 0 && m[i][2] >= 0) break;
            }
        }

        for (int i = 0; i < n; i++) {
            per[i] = (m[i][0] + m[i][1] + m[i][2]) / 3.0;
            if (per[i] >= 80) g[i] = 'A';
            else if (per[i] >= 70) g[i] = 'B';
            else if (per[i] >= 60) g[i] = 'C';
            else if (per[i] >= 50) g[i] = 'D';
            else if (per[i] >= 40) g[i] = 'E';
            else g[i] = 'R';
        }

        for (int i = 0; i < n; i++) {
            System.out.println(m[i][0] + " " + m[i][1] + " " + m[i][2] + " " + per[i] + " " + g[i]);
        }
        sc.close();
    }
}
