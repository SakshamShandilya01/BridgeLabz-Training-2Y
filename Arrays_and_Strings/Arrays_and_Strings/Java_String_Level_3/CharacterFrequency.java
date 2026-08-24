import java.util.Scanner;

class CharacterFrequency {
    static String[][] freq(String s) {
        int[] f = new int[256];

        for (int i = 0; i < s.length(); i++) {
            f[s.charAt(i)]++;
        }

        int n = 0;

        for (int i = 0; i < 256; i++) {
            if (f[i] > 0) {
                n++;
            }
        }

        String[][] a = new String[n][2];
        int k = 0;

        for (int i = 0; i < 256; i++) {
            if (f[i] > 0) {
                a[k][0] = String.valueOf((char)i);
                a[k][1] = String.valueOf(f[i]);
                k++;
            }
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
