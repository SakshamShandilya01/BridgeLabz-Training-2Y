import java.util.Scanner;

class Palindrome {
    static boolean one(String s) {
        int st = 0;
        int en = s.length() - 1;

        while (st < en) {
            if (s.charAt(st) != s.charAt(en)) {
                return false;
            }

            st++;
            en--;
        }

        return true;
    }

    static boolean two(String s, int st, int en) {
        if (st >= en) {
            return true;
        }

        if (s.charAt(st) != s.charAt(en)) {
            return false;
        }

        return two(s, st + 1, en - 1);
    }

    static char[] reverse(String s) {
        char[] a = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            a[i] = s.charAt(s.length() - 1 - i);
        }

        return a;
    }

    static boolean three(String s) {
        char[] a = s.toCharArray();
        char[] b = reverse(s);

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println("Logic 1: " + one(s));
        System.out.println("Logic 2: " + two(s, 0, s.length() - 1));
        System.out.println("Logic 3: " + three(s));

        sc.close();
    }
}
