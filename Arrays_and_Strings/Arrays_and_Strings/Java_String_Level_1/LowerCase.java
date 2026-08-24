import java.util.Scanner;

class LowerCase {
    static String lower(String s) {
        String r = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                c = (char)(c + 32);
            }

            r += c;
        }

        return r;
    }

    static boolean cmp(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        String a = lower(s);
        String b = s.toLowerCase();

        System.out.println("Using charAt(): " + a);
        System.out.println("Using toLowerCase(): " + b);
        System.out.println("Both results are same: " + cmp(a, b));

        sc.close();
    }
}
