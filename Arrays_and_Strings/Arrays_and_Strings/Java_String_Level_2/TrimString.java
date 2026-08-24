import java.util.Scanner;

class TrimString {
    static int[] trim(String s) {
        int st = 0;
        int en = s.length() - 1;

        while (st <= en && s.charAt(st) == ' ') {
            st++;
        }

        while (en >= st && s.charAt(en) == ' ') {
            en--;
        }

        return new int[]{st, en + 1};
    }

    static String sub(String s, int st, int en) {
        String r = "";

        for (int i = st; i < en; i++) {
            r += s.charAt(i);
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

        int[] p = trim(s);
        String a = sub(s, p[0], p[1]);
        String b = s.trim();

        System.out.println("Using charAt(): " + a);
        System.out.println("Using trim(): " + b);
        System.out.println("Both results are same: " + cmp(a, b));

        sc.close();
    }
}
