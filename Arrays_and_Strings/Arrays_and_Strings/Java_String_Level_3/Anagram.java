import java.util.Scanner;

class Anagram {
    static boolean check(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        int[] x = new int[256];
        int[] y = new int[256];

        for (int i = 0; i < a.length(); i++) {
            x[a.charAt(i)]++;
            y[b.charAt(i)]++;
        }

        for (int i = 0; i < 256; i++) {
            if (x[i] != y[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();
        String b = sc.nextLine();

        System.out.println("Anagram: " + check(a, b));

        sc.close();
    }
}
