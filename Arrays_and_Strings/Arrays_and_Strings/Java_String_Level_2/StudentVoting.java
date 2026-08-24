import java.util.Scanner;

class StudentVoting {
    static int[] age(int n) {
        int[] a = new int[n];

        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random() * 90) + 10;
        }

        return a;
    }

    static String[][] check(int[] a) {
        String[][] b = new String[a.length][2];

        for (int i = 0; i < a.length; i++) {
            b[i][0] = String.valueOf(a[i]);

            if (a[i] < 0) {
                b[i][1] = "false";
            } else if (a[i] >= 18) {
                b[i][1] = "true";
            } else {
                b[i][1] = "false";
            }
        }

        return b;
    }

    static void display(String[][] a) {
        System.out.println("Age\tCan Vote");

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i][0] + "\t" + a[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 10;
        int[] a = age(n);
        String[][] b = check(a);

        display(b);

        sc.close();
    }
}
