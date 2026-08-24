import java.util.Scanner;

class SplitWords {
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

    static boolean cmp(String[] a, String[] b) {
        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        String[] a = split(s);
        String[] b = s.trim().split("\\s+");

        System.out.println("Using charAt():");

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();
        System.out.println("Using split():");

        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }

        System.out.println();
        System.out.println("Both results are same: " + cmp(a, b));

        sc.close();
    }
}
