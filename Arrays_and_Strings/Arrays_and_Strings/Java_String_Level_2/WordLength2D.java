import java.util.Scanner;

class WordLength2D {
    static int len(String s) {
        int n = 0;

        while (true) {
            try {
                s.charAt(n);
                n++;
            } catch (StringIndexOutOfBoundsException e) {
                break;
            }
        }

        return n;
    }

    static String[] split(String s) {
        int n = len(s);
        int c = 0;
        boolean word = false;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != ' ' && !word) {
                c++;
                word = true;
            } else if (s.charAt(i) == ' ') {
                word = false;
            }
        }

        String[] a = new String[c];
        int k = 0;
        String w = "";

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch != ' ') {
                w += ch;
            } else if (w.length() > 0) {
                a[k] = w;
                k++;
                w = "";
            }
        }

        if (w.length() > 0) {
            a[k] = w;
        }

        return a;
    }

    static String[][] data(String[] a) {
        String[][] b = new String[a.length][2];

        for (int i = 0; i < a.length; i++) {
            b[i][0] = a[i];
            b[i][1] = String.valueOf(len(a[i]));
        }

        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String[] a = split(s);
        String[][] b = data(a);

        System.out.println("Word\tLength");

        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i][0] + "\t" + Integer.parseInt(b[i][1]));
        }

        sc.close();
    }
}
