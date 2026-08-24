import java.util.Scanner;

class UniqueCharacters {
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

    static char[] unique(String s) {
        int n = len(s);
        char[] a = new char[n];
        int k = 0;

        for (int i = 0; i < n; i++) {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        char[] a = unique(s);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        sc.close();
    }
}
