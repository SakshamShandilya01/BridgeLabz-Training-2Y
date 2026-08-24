import java.util.Scanner;

class NestedFrequency {
    static String[] freq(String s) {
        char[] a = s.toCharArray();
        int[] f = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            if (a[i] == '0') {
                continue;
            }

            f[i] = 1;

            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j]) {
                    f[i]++;
                    a[j] = '0';
                }
            }
        }

        int n = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != '0') {
                n++;
            }
        }

        String[] b = new String[n * 2];
        int k = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != '0') {
                b[k] = String.valueOf(a[i]);
                b[k + 1] = String.valueOf(f[i]);
                k += 2;
            }
        }

        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String[] a = freq(s);

        System.out.println("Character\tFrequency");

        for (int i = 0; i < a.length; i += 2) {
            System.out.println(a[i] + "\t\t" + a[i + 1]);
        }

        sc.close();
    }
}
