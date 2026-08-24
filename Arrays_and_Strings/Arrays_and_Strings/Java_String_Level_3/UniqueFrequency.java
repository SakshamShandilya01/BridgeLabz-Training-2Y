import java.util.Scanner;

class UniqueFrequency {
    static char[] unique(String s) {
        char[] a = new char[s.length()];
        int k = 0;

        for (int i = 0; i < s.length(); i++) {
            boolean x = true;

            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    x = false;
                    break;
                }
            }

            if (x) {
                a[k] = s.charAt(i);
                k++;
            }
        }

        char[] b = new char[k];

        for (int i = 0; i < k; i++) {
            b[i] = a[i];
        }

        return b;
    }

    static String[][] freq(String s) {
        int[] f = new int[256];

        for (int i = 0; i < s.length(); i++) {
            f[s.charAt(i)]++;
        }

        char[] u = unique(s);
        String[][] a = new String[u.length][2];

        for (int i = 0; i < u.length; i++) {
            a[i][0] = String.valueOf(u[i]);
            a[i][1] = String.valueOf(f[u[i]]);
        }

        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String[][] a = freq(s);

        System.out.println("Character\tFrequency");

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i][0] + "\t\t" + a[i][1]);
        }

        sc.close();
    }
}
