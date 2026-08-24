import java.util.Scanner;

class ShortestLongest {
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

    static int[] find(String[][] a) {
        int si = 0;
        int li = 0;

        for (int i = 1; i < a.length; i++) {
            int x = Integer.parseInt(a[i][1]);
            int y = Integer.parseInt(a[si][1]);
            int z = Integer.parseInt(a[li][1]);

            if (x < y) {
                si = i;
            }

            if (x > z) {
                li = i;
            }
        }

        return new int[]{si, li};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String[] a = split(s);

        if (a.length == 0) {
            System.out.println("No words found.");
            return;
        }

        String[][] b = data(a);
        int[] r = find(b);

        System.out.println("Shortest string: " + b[r[0]][0]);
        System.out.println("Longest string: " + b[r[1]][0]);

        sc.close();
    }
}
