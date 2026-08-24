import java.util.Scanner;

class RockPaperScissors {
    static String choice() {
        int n = (int)(Math.random() * 3);

        if (n == 0) {
            return "Rock";
        } else if (n == 1) {
            return "Paper";
        }

        return "Scissors";
    }

    static String win(String u, String c) {
        if (u.equals(c)) {
            return "Draw";
        }

        if ((u.equals("Rock") && c.equals("Scissors")) ||
            (u.equals("Paper") && c.equals("Rock")) ||
            (u.equals("Scissors") && c.equals("Paper"))) {
            return "Player";
        }

        return "Computer";
    }

    static String[][] stats(int p, int c, int n) {
        String[][] a = new String[2][3];

        a[0][0] = "Player";
        a[0][1] = String.valueOf(p);
        a[0][2] = String.format("%.2f", p * 100.0 / n);

        a[1][0] = "Computer";
        a[1][1] = String.valueOf(c);
        a[1][2] = String.format("%.2f", c * 100.0 / n);

        return a;
    }

    static void display(String[][] a) {
        System.out.println("Winner\tWins\tPercentage");

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i][0] + "\t" + a[i][1] + "\t" + a[i][2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Invalid number of games.");
            return;
        }

        int p = 0;
        int c = 0;

        for (int i = 1; i <= n; i++) {
            String u = sc.next();
            String x = u.toLowerCase();

            if (x.equals("rock")) {
                u = "Rock";
            } else if (x.equals("paper")) {
                u = "Paper";
            } else if (x.equals("scissors")) {
                u = "Scissors";
            } else {
                System.out.println("Invalid choice.");
                i--;
                continue;
            }

            String v = choice();
            String w = win(u, v);

            if (w.equals("Player")) {
                p++;
            } else if (w.equals("Computer")) {
                c++;
            }

            System.out.println("Game " + i + ": Player = " + u + ", Computer = " + v + ", Winner = " + w);
        }

        String[][] a = stats(p, c, n);
        display(a);

        sc.close();
    }
}
